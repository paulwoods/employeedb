package org.mrpaulwoods.employee.security.jwt

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class StatelessAuthenticationFilter extends GenericFilterBean {

    private final TokenAuthenticationService tokenAuthenticationService

    public StatelessAuthenticationFilter(TokenAuthenticationService taService) {
        this.tokenAuthenticationService = taService
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        SecurityContextHolder.context.authentication = tokenAuthenticationService.getAuthentication(req)
        chain.doFilter req, res
    }

}