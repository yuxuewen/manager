package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mongo.LogRecordRepository;
import com.macro.mall.tiny.dto.WebLog;
import com.macro.mall.tiny.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRecordRepository logRecordRepository;

    @Override
    public int createLog(WebLog webLog) {
        logRecordRepository.save(webLog);
        return 1;
    }

    @Override
    public List<WebLog> getWebLogList() {
        return null;
    }
}
