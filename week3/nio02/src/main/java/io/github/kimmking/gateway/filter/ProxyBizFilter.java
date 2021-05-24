package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

public class ProxyBizFilter implements HttpRequestFilter {
    public static ProxyBizFilter newInstance() {
        return new ProxyBizFilter();
    }

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
         if (uri.startsWith("/api")) {
             HttpHeaders headers = fullRequest.headers();
             if (headers == null) {
                 headers = new DefaultHttpHeaders();
             }
             headers.add("filter-header", "hello world filter");
        } else {
             System.out.println("拦截住");;
        }

    }
}
