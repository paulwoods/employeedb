package org.mrpaulwoods.employee.security.jwt

import groovy.util.logging.Slf4j
import org.mrpaulwoods.employee.security.EmployeeUserDetailsService
import org.mrpaulwoods.employee.security.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Service
@Slf4j
public class TokenAuthenticationService {

    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN"

    @Autowired
    UserTokenService userTokenService

    /** adds the current user's token to the header */

    public void addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
        final User user = authentication.getDetails()
        response.addHeader(AUTH_HEADER_NAME, userTokenService.userToToken(user))
    }

    /** retrieves the current user from the token and stores in authentication object */

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME)

        if (!token) {
            return null
        }

        final User user = userTokenService.tokenToUser(token)
        if (!user) {
            return null
        }

        return new UserAuthentication(user)
    }

}