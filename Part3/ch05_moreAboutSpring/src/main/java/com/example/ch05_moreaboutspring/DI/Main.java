package com.example.ch05_moreaboutspring.DI;

public class Main {
    public static void main(String args[]){

        String url = "www.naver.com/books/it?page=105&size=20&name=spring"; //인코딩할 url

        //①②③④⑤
        //① Base64로 인코딩 "해줘"
        /*
        Encoder encoder = new Encoder();
        String result = encoder.encode(url);
        System.out.println(result);
        */


        //② 다르게 url 인코딩 해줘
        UrlEncoder urlEncoder = new UrlEncoder();
        String result2 = urlEncoder.encode(url);
        System.out.println(result2);

        //=>생각없이 만들면 걍 이렇게 계속 만듦.
        //추상화를 적용한다면?
        //두 인코더 클래스 모두 같은 동작을 수행함. 인코더 인터페이스를 만들자!

        IEncoder encoder3 = new Base64Encoder();
        String result3 = encoder3.encode(url);

        IEncoder urlEncoder2 = new UrlEncoder();
        String result4 = urlEncoder2.encode(url);

        //IEncoder 인터페이스로 객체를 생성한 모습

        //④ 이 객체...클래스가 걍 갖고 있음 안됨?
        //클래스에다 스태틱 객체를 만들자!

        /*
        Encoder encoder5 = new Encoder();
        String result5 = encoder5.encode(url);
        System.out.println(result5);

         */

        //아 몰라 존나 복잡해

        //⑤ DI -> 외부에서 내가 사용할 객체를 주입

        Encoder DiEncoder = new Encoder(new Base64Encoder());
        //Encoder DiEncoder = new Encoder(new UrlEncoder());
        String DiResult = DiEncoder.encode(url);
        System.out.println(DiResult);

    }
}
