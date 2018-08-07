package com.zlz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
//import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class AuthFilter extends ZuulFilter {
//    private Logger logger = LogF

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext rt = RequestContext.getCurrentContext();
        HttpServletRequest request = rt.getRequest();
        Enumeration<String> parameterName = request.getParameterNames();
        List<String> list = new ArrayList<>();
        while (parameterName.hasMoreElements()) {

            String name = parameterName.nextElement();
            list.add(name);
            System.out.println(name + "xxxxxxxxxxxxxxxxxx:" + request.getParameter(name));
        }
        if (list.size() <= 0) {
            rt.setSendZuulResponse(false);
            rt.setResponseBody("At least one parameter");
        }
        return null;
    }

/*
filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：

pre：可以在请求被路由之前调用

routing：在路由请求时候被调用

post：在routing和error过滤器之后被调用

error：处理请求时发生错误时被调用

filterOrder：通过int值来定义过滤器的执行顺序

shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。
这里，我们直接返回true，所以该过滤器总是生效。

run：过滤器的具体逻辑。需要注意，这里我们通过rt.setSendZuulResponse(false)令zuul过滤该请求，
不对其进行路由，然后通过rt.setResponseStatusCode(401)设置了其返回的错误码，
当然我们也可以进一步优化我们的返回，比如，通过rt.setResponseBody(body)对返回body内容进行编辑等。
，或者重新定向到一个错误页面

*/


}