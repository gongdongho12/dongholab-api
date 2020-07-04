package com.dongholab.api.config

import com.dongholab.api.dataset.MemberRole
import com.dongholab.api.entity.Member
import com.dongholab.api.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class BeanConfig {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

    @Bean
    fun applicationRunner(): ApplicationRunner {
        return object : ApplicationRunner {

            @Autowired
            lateinit var memberService: MemberService

            @Throws(Exception::class)
            override fun run(args: ApplicationArguments) {
                val admin = Member(1,
                        "admin@test.com",
                        "password",
                        mutableSetOf(MemberRole.ADMIN, MemberRole.USER))
                memberService.saveMember(admin)
            }
        }
    }
}