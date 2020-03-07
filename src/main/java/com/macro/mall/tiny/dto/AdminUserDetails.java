package com.macro.mall.tiny.dto;

import com.macro.mall.tiny.mbg.model.SysMenu;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;
import com.macro.mall.tiny.service.impl.UmsAdminServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 * Created by macro on 2018/4/26.
 */
public class AdminUserDetails implements UserDetails {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminUserDetails.class);

    private UmsAdmin umsAdmin;
    private List<SysMenu> permissionList;
    public AdminUserDetails(UmsAdmin umsAdmin, List<SysMenu> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
        for(SysMenu item :permissionList)
        {
            LOGGER.info(StringUtils.isEmpty(item.getPerms())?"true":"false");
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getPerms()!=null)
                .map(permission ->new SimpleGrantedAuthority((!StringUtils.isEmpty(permission.getPerms()))?permission.getPerms():"pms:null"))
                .collect(Collectors.toList());
    }
    
    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
