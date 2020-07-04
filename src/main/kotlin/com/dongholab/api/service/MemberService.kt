package com.dongholab.api.service

import com.dongholab.api.entity.Member
import com.dongholab.api.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberService(@Autowired private val memberRepository: MemberRepository,
                     @Autowired private val passwordEncoder: PasswordEncoder): UserDetailsService {

    fun saveMember(member: Member): Member {
        member.password = this.passwordEncoder.encode(member.password)
        return memberRepository.save(member)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        return memberRepository.findByEmail(username)?.getAuthorities()
                ?: throw UsernameNotFoundException("$username Can Not Found")
    }
}