package com.example.demo.test.event

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class ApplicationEventRecorder {
    // events
    private val recordedEvents: MutableList<Any> = mutableListOf()

    // config
    private var on: Boolean = false
    var filterSpringFrameworkEvents: Boolean = true

    fun startRecording() {
        this.on = true
    }

    fun stopRecording() {
        this.on = false
    }

    fun clearRecordedEvents() {
        this.recordedEvents.clear()
    }

    fun getEvents(): List<Any> = this.recordedEvents.toList()

    /**
     * SpringFramework 상의 모든 이벤트를 listen 하고
     * [filterSpringFrameworkEvents] 설정에 따라 SpringFramework의 Event를 필터링한다.
     */
    @EventListener
    fun listen(anyEvent: Any) {
        if (!this.on) {
            return
        }

        if (this.filterSpringFrameworkEvents && anyEvent.isSpringFrameworkEvent()) {
            return
        }

        this.recordedEvents.add(anyEvent)
    }
}

private fun Any.isSpringFrameworkEvent(): Boolean =
    this::class.java.name.startsWith("org.springframework")
