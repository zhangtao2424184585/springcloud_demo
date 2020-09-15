package com.zt.memservice.web.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Enumeration;

/**
 * @Classname FeignInterceptor
 * @Description TODO
 * @Date 2020/8/20 10:06
 * @Created by zhangtao
 */
@Component
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(feign.RequestTemplate requestTemplate) {
//        //通过RequestContextHolder获取本地请求
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        if (requestAttributes == null) {
//            return;
//        }
//        //获取本地线程绑定的请求对象
//        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
//        //给请求模板附加本地线程头部信息，主要是cookie信息
//        Enumeration headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String name = headerNames.nextElement().toString();
//            requestTemplate.header(name, request.getHeader(name));
//        }
//        if (!request.isRequestedSessionIdValid()) {
//            request.setAttribute(SessionRepositoryFilter.INVALID_SESSION_ID_ATTR, null);
//            requestTemplate.header("cookie", "SESSION=" + request.getSession().getId());
//            System.out.println("SESSION=" + request.getSession().getId());
//        }
//
//
//    }
}
}
