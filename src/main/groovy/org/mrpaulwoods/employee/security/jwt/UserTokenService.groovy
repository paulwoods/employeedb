package org.mrpaulwoods.employee.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.mrpaulwoods.employee.security.EmployeeUserDetailsService
import org.mrpaulwoods.employee.security.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * This class converts between Users and JWT Tokens.
 */
@Service
public class UserTokenService {

    @Autowired
    EmployeeUserDetailsService employeeUserDetailsService

    @Value(value = '${token.secret}')
    String secret

    User tokenToUser(String token) {
        assert secret

        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject()

        employeeUserDetailsService.loadUserByUsername username
    }

    String userToToken(User user) {
        assert secret

        Jwts.builder()
                .setSubject(user.username)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()
    }


}
