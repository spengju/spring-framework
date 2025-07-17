package com.peng.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/7 15:36
 * @Desc:
 */
//@Component
public class PengApplicationEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event);
        PayloadApplicationEvent applicationEvent = (PayloadApplicationEvent) event;
        System.out.println(applicationEvent.getPayload());
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
