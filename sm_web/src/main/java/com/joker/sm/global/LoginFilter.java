package com.joker.sm.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getRequestURI().toLowerCase().indexOf("login") != -1) {
            filterChain.doFilter(request, response);
        } else {
            if (request.getSession().getAttribute("STAFF") == null) {
                response.sendRedirect(request.getContextPath() + "/toLogin.do");
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
