package com.example.intercepter.intercepter;

import com.example.intercepter.annotation.Auth;
import com.example.intercepter.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component  //spring에 의해 관리됨(bean등록)
public class AuthInterceptor implements HandlerInterceptor {    //이게 뭔데요;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder
                .fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url : {}",url);

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}",hasAnnotation);

        //나의 서버는 모두 public으로 동작하지만
        //Auth 권한을 가진 요청에 대해서는 세션,쿠키 등을 보겠다

        if(hasAnnotation){  //hasAnnotation이 true이면
            //권한 체크
            String query = uri.getQuery();

            log.info("query : {}",query);

            if(query.equals("name=steve"))
                return true;
            throw new AuthException();
        }

        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz){

        //resouce요청( javascript, html 등) -> 권환확인 없이 통과
        if(handler instanceof ResourceHttpRequestHandler)
            return true;

        //어노테이션이 있는가
        HandlerMethod handlerMethod = (HandlerMethod)handler;

        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz))
            //Auth annotation이 있을 때 true
            return true;

        return false;

    }


}
