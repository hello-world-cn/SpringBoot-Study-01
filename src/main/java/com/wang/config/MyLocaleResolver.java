package com.wang.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//实现了LocaleResolver就是一个国际化解析器
public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的参数 l
        String language = request.getParameter("l");

        //如果没有, 就使用默认的
        Locale locale = Locale.getDefault();

        //如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            //国家, 地区
            locale = new Locale(split[0], split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
