package com.example.filter_2.filter;

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

@Slf4j  //Log를 남기기 위함
//@Component
@WebFilter(urlPatterns = "/api/user/*") //하고자 하는 url 설정
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //전처리. 들어가기 전

        //HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        //HttpServletResponse httpServletResponse = (HttpServletResponse)response;  //응답용으로 생성해둔 빈 response객체

        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper ((HttpServletRequest)request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse)response);

      /*
       BufferedReader br = httpServletRequest.getReader(); //버퍼를 통해 body내용을 받아옴

        br.lines().forEach(line -> {
            log.info("url : {}, line : {}",url,line);
        });
        //버퍼로 받은 body를 한줄씩 log로 남김

       */

        chain.doFilter(request,response);

        //후처리. doFilter가 돌면 response가 만들어짐

        String url = httpServletRequest.getRequestURI();    //어떤 주소를 요청했는지 확인가능
        String contect = new String(httpServletRequest.getContentAsByteArray());
        //content의 내용을 byte로 받아 string으로 저장

        //ContentCachingRequestWrapper에서, 생성자에서는 content의 길이만 지정해 놓고, 내용은 나중에 사용을 한대
        //spring에서 모두 mapping한 다음 사용..?

        String requestContent = new String(httpServletRequest.getContentAsByteArray());
        //content내용을 byteArray로 받음

        String responseContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatusCode = httpServletResponse.getStatus();

          httpServletResponse.copyBodyToResponse();
        //위에서 getContentAsByteArray()로 읽으셔서 커서가 끝으로가 다시 못읽으시거든요, 그래서 다시 저장해주셔야 해요.
        //copyBodyToResponse()로 하세요

        log.info("response status : {}, responseBody : {}",httpStatusCode,responseContent);

        //그니까 씨발, 받아온 body에 대해서 ContentCachingRequestWrapper는 전처리 부분에서는 해당 body의 길이만 알려줄 수 있고,
        //실제 body의 내용은 doFilter() 이후인 후처리 부분에서 저장하기 때문에 후처리 부분에서 body정보를 찍어서 알아낼 수 있다
        //이말이잖아 존나 어렵게 하네

        //log.info를 후처리 부분에서 찍으세요! 정보 저장도 후처리 부분에서 하고
        //진짜 개 ㅈ같네 그냥 전처리 부분에서는 ContentCachingRequestWrapper 생성만 하고 다 후처리에서 하라는 말을
        //뭐 이렇게 어렵게 하냐

        //Filter에서 request와 response를 찍어야 하면 ContentCaching을 생성한 후 doFilter() 이후에
        //requestd의 body에서 내용을 가져다 찍은 다음
        //copyBodyToResponse()를 호출해 줘야 정상적으로 처리됨

        //이런 filter들을 특정 부분에 적용하는 방법ApiController
    }
}
