package com.dongholab.api.service

import com.dongholab.api.dataset.CustomUserDetails
import com.dongholab.api.repository.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val memberRepository: MemberRepository, private val passwordEncoder: PasswordEncoder): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return memberRepository.findByEmail(username)?.let { CustomUserDetails.from(it) }
                ?: throw UsernameNotFoundException("$username Can Not Found")
    }
}