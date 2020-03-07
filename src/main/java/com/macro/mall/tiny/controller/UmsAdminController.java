package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.common.utils.VerifyUtil;
import com.macro.mall.tiny.dto.ChangePassword;
import com.macro.mall.tiny.dto.UmsAdminLoginParam;
import com.macro.mall.tiny.mbg.model.SysMenu;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;
import com.macro.mall.tiny.service.RedisService;
import com.macro.mall.tiny.service.UmsAdminService;
import com.macro.mall.tiny.service.impl.UmsAdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminController.class);
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private RedisService redisService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${constant.verifyCodeKey}")
    private String verifyCodeKey;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result, HttpServletRequest request) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if(redisService.get(umsAdminLoginParam.getUsername())!=null && Integer.parseInt(redisService.get(umsAdminLoginParam.getUsername()))>2){
            if(StringUtils.isEmpty(umsAdminLoginParam.getCode()))
            {
                return CommonResult.validateFailed("请输入验证码");

            }
            HttpSession session=request.getSession();
            String code= (String)session.getAttribute(verifyCodeKey);
            if(umsAdminLoginParam.getCode().equals(code)==false)
            {
                return CommonResult.validateFailed("验证码错误");
            }


        }
        if (token == null) {
            redisService.increment(umsAdminLoginParam.getUsername(),1);
            return CommonResult.validateFailed("用户名或密码错误");
        }
        redisService.remove(umsAdminLoginParam.getUsername());
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        return CommonResult.success(umsAdmin);
}



    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/getUserPermissionList/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SysMenu>> getUserPermissionList(@PathVariable Long adminId) {
        List<SysMenu> permissionList = adminService.getUserPermissionList(adminId);
        return CommonResult.success(permissionList);
    }


    @ApiOperation("修改密码")
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult changePassword(@Validated @RequestBody ChangePassword changePassword, BindingResult result) {

        if(result.hasErrors())
        {
            LOGGER.warn("异常:{}", result.getFieldError().getDefaultMessage());
            return CommonResult.failed(result.getFieldError().getDefaultMessage());
        }
        int resCode=adminService.changePassword(changePassword);
        if(resCode>0)
        {
            return CommonResult.success(resCode);
        }
        else if(resCode==-1)
        {
            return CommonResult.failed("该用户不存在");
        }
        else if(resCode==-2)
        {
            return CommonResult.failed("旧密码错误");

        }
        else
        {
            return CommonResult.failed("修改失败");
        }

    }
    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getVerifyCode(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        VerifyUtil randomValidateCode = new VerifyUtil();
        return CommonResult.success(randomValidateCode.getRandcode(request, response)); //输出验证码图片

    }

}
