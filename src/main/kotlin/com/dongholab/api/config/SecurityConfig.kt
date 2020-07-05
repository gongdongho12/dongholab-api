package com.dongholab.api.config

import com.dongholab.api.service.CustomUserDetailsService
import com.dongholab.api.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class SecurityConfig(@Autowired private val accountService: CustomUserDetailsService, @Autowired private val passwordEncoder: PasswordEncoder) : WebSecurityConfigurerAdapter() {

    companion object {
        const val LOGIN_SUCCESS_URL: String = "/member/success"
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder)
    }

    override fun configure(http: HttpSecurity) {
        http.anonymous()
                .and()
                .formLogin()
                .successForwardUrl(LOGIN_SUCCESS_URL)
                .and()
                .authorizeRequests()
                .antMatchers(LOGIN_SUCCESS_URL).hasRole("USER")
                .anyRequest().permitAll()
//                .authenticated()
    }
}