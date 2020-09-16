package com.guangzhou.college.api.service.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class ApiLoginService {
    public boolean login(Map<String,String> params) {
       log.info("execute login operation....");
        return true;
    }
}
