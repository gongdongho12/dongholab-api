package com.dongholab.api.entity

import com.dongholab.api.dataset.MemberRole
import org.hibernate.annotations.CreationTimestamp
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import java.time.LocalDateTime
import java.util.stream.Collectors
import javax.persistence.*

@Entity
data class Member(
        @Id
        @GeneratedValue
        var id: Long? = null,

        @Id
        var email: String,
        var password: String,

        @Enumerated(EnumType.STRING)
        @ElementCollection(fetch = FetchType.EAGER)
        var roles: MutableSet<MemberRole>,

        @CreationTimestamp
        var createDt: LocalDateTime = LocalDateTime.now()
){
    fun getAuthorities(): User {
        return User(
                this.email, this.password,
                this.roles.stream().map { role -> SimpleGrantedAuthority("ROLE_$role") }.collect(Collectors.toSet())
        )
    }
}