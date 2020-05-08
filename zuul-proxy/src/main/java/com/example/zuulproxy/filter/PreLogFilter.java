package com.example.zuulproxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description: 添加过滤器
 * @author: HyJan
 * @create: 2020-05-07 15:32
 **/
@Component
@Slf4j
public class PreLogFilter extends ZuulFilter {

    /**
     * 过滤器类型，有pre、routing、post、error四种。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，数值越小优先级越高。
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否进行过滤，返回true会执行过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 自定义的过滤器逻辑，当shouldFilter()返回true时会执行。
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 获取当前的请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        // 从请求上下文中获取请求
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        log.info("remote host{} uri{} method{}",host,uri,method);
        return null;
    }
}
