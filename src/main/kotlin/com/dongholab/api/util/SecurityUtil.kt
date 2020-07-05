package com.dongholab.api.util

import com.dongholab.api.dataset.CustomUserDetails
import org.springframework.security.core.context.SecurityContextHolder

object SecurityUtil {
    fun getCustomUserDetails(): CustomUserDetails? {
        val principal = SecurityContextHolder.getContext().authentication?.principal
        return if (principal is CustomUserDetails) principal else null
    }
}