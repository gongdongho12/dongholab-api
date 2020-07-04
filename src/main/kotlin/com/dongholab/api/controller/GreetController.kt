package com.dongholab.api.controller

import com.dongholab.api.dataset.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetController {
    @GetMapping("/greet")
    fun greet(): String {
        return "Hello, World"
    }

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) = Greeting(10, "Hello, $name")
}