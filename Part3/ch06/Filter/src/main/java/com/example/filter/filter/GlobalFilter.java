package com.example.filter.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@Component  //spring에 의해 bean으로 관리되는 클래스
@Slf4j
@WebFilter(urlPatterns = "api/user/*")
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        //filter에서는 request와 response를 변경할 수 있음

        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((ContentCachingRequestWrapper)request);
        // Content객체에 내용을 저장해서 이미 한번 읽은 body를 다시 참조할 수 있게 함

        //HttpServletResponse httpServletResponse = (HttpServletResponse)response;

        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((ContentCachingResponseWrapper) response);




        //전처리 구간

        chain.doFilter(request,response);
        String url = httpServletRequest.getRequestURI();    //요청한 URI를 얻음

        //후처리 구간

        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}",url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        //여기서 한번 읽을 때 body의 커서가 body끝에 도달함
        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse();
        //getContentAsByteArray()로 한번 읽은 내용을 저장해 다시 읽을 수 있도록 함


        log.info("response status : {}, responseBody : {}",httpStatus,resContent);


    }
}
