package org.mrpaulwoods.employee.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

@Service
class EmployeeUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository

    @Autowired
    AuthorityRepository authorityRepository

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
        if (user)
            user
        else
            throw new UsernameNotFoundException(username)
    }

    @PostConstruct
    void init() {
        User user = userRepository.save(new User(username: "paulwoods", password: "alpha"))
        user.authorities << authorityRepository.save(new Authority(user: user, authority: "ROLE_USER"))
        user.authorities << authorityRepository.save(new Authority(user: user, authority: "ROLE_ADMIN"))
    }

}
