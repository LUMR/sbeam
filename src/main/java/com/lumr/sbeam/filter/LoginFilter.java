package com.lumr.sbeam.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by lumr on 2017/5/9.
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
