package com.hks.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述: 过滤器 token
 *
 * @author hekuangsheng
 * @create 2017-12-11 14:38
 **/
public class TokenFilter extends ZuulFilter {

    private final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public String filterType() {
        // 可以在请求被路由之前调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        LOGGER.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        // 获取请求的参数
        String token = request.getParameter("token");

        if (StringUtils.isNotBlank(token)) {
            //对请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            //不对其进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }
    }

}
