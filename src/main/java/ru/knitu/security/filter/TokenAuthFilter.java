package ru.knitu.security.filter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.knitu.security.token.TokenAuthentication;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TokenAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest =(HttpServletRequest) servletRequest;
        String token = httpServletRequest.getParameter("token");
        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
        if(token== null){
            tokenAuthentication.setAuthenticated(false);
        }else {
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
