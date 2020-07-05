package com.dongholab.api

import com.dongholab.api.dataset.CustomUserDetails
import com.dongholab.api.util.SecurityUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithAnonymousUser
import org.springframework.security.test.context.support.WithUserDetails

@SpringBootTest
class ApiApplicationTests {

    @Test
    fun contextLoads() {
    }

//    @Test
//    @WithAnonymousUser
//    fun getAuthWithoutLogin() {
//        CustomUserDetails customUserDetails = SecurityUtil.getCustomUserDetails()
//
//        Assertions.assertNull(customUserDetails);
//    }
//
//    @Test
//    @WithUserDetails(value = "user@test.com", userDetailsServiceBeanName = "customUserDetailsService")
//    fun getAuthWithLogin() {
//        CustomUserDetails customUserDetails = SecurityUtillKt.getCustomUserDetails();
//
//        Assertions.assertEquals("user@test.com", customUserDetails.getUsername());
//    }

}
