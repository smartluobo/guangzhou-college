package com.guangzhou.college.cms.scheduled;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
@EnableScheduling
@Slf4j
public class TestScheduledTask {

    @Scheduled(cron = "0 0/30 * * * ?")
    public void orderCloseTaskMethod(){
        log.info("task start.....");
    }
}
