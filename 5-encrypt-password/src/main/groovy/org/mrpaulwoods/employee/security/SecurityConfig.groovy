package org.mrpaulwoods.employee.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    EmployeeUserDetailsService employeeUserDetailsService

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth
                .userDetailsService(employeeUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder())
    }

    @Override
    protected void configure(HttpSecurity http) {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/login/**").permitAll()

                .anyRequest().authenticated()
                .and()

        // configure the login form

                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()

        // configure the logout form

                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("http://www.google.com")
                .permitAll()
                .and()

    }

}
