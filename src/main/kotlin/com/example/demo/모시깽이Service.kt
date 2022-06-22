package com.example.demo

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class 모시깽이Service(
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    fun do모시깽이() {
        println("야호~")
        this.applicationEventPublisher.publishEvent(모시깽이했다Event(foo = "모시"))
        this.applicationEventPublisher.publishEvent(모시깽이했다Event(foo = "깽이"))
        println("~호야")
    }
}

data class 모시깽이했다Event(
    val foo: String,
)

//data class 모시깽이했다Event(
//    val foo: String,
//) : ApplicationEvent(foo)
