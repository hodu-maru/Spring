package com.example.intercepter.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component  //spring에 의해 관리됨(bean등록)
public class AuthInterceptor implements HandlerInterceptor {    //이게 뭔데요;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url =


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


}
