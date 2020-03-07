package com.macro.mall.tiny.service;

import com.macro.mall.tiny.dto.WebLog;


import java.util.List;

public interface LogService  {
    int createLog(WebLog webLog);
    List<WebLog> getWebLogList();

}
