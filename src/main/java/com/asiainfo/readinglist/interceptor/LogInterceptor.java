package com.asiainfo.readinglist.interceptor;

import org.slf4j.MDC;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 日志拦截器组件，在输出日志中加上sessionId
 *
 * @author yuhao.wang3
 */
public class LogInterceptor extends HandlerInterceptorAdapter {
    /**
     * 会话ID
     */
    private final static String SESSION_KEY = "sessionId";

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

        // 删除SessionId
        MDC.remove(SESSION_KEY);
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        // 设置SessionId
        String token = UUID.randomUUID().toString();
        MDC.put(SESSION_KEY, token);
        return true;
    }
}