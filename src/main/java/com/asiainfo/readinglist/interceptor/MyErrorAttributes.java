package com.asiainfo.readinglist.interceptor;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes,includeStackTrace);

        errorAttributes.put("myName","我不吃番茄");//自定义数据
//        errorAttributes.put("myAge","不告诉你");//自定义数据
        errorAttributes.put("trace",requestAttributes.getAttribute("extra",0));
        return errorAttributes;
    }
}
