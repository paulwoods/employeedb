package org.mrpaulwoods.employee.security.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.util.logging.Slf4j
import org.mrpaulwoods.employee.security.User
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
class StatelessLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final TokenAuthenticationService tokenAuthenticationService
    private final UserDetailsService userDetailsService

    protected StatelessLoginFilter(String urlMapping,
                                   TokenAuthenticationService tokenAuthenticationService,
                                   UserDetailsService userDetailsService,
                                   AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(urlMapping))
        this.userDetailsService = userDetailsService
        this.tokenAuthenticationService = tokenAuthenticationService
        setAuthenticationManager(authManager)
    }

    /** Parses the {username: "xxx", password:"yyy"} json string, and attempts to login **/

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        final User user = new ObjectMapper().readValue(request.getInputStream(), User.class)

        final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(
                user.username, user.password)

        return getAuthenticationManager().authenticate(loginToken)
    }

    /** the login was successful. create the token **/

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authentication) throws IOException, ServletException {

        // Lookup the complete User object from the database and create an Authentication for it
        final User authenticatedUser = userDetailsService.loadUserByUsername(authentication.getName())
        final UserAuthentication userAuthentication = new UserAuthentication(authenticatedUser)

        // Add the custom token as HTTP header to the response
        tokenAuthenticationService.addAuthentication(response, userAuthentication)

        // Add the authentication to the Security context
        SecurityContextHolder.getContext().setAuthentication(userAuthentication)
    }
}