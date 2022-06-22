package com.example.demo

import com.example.demo.test.event.ApplicationEventRecorder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
//@RecordApplicationEvents
internal class 모시깽이ServiceTest {
    @Autowired
    private lateinit var sut: 모시깽이Service

//    @Autowired
//    private lateinit var events: ApplicationEvents

    @Autowired
    private lateinit var applicationEventRecorder: ApplicationEventRecorder

    @BeforeEach
    fun beforeEach() {
        this.applicationEventRecorder.startRecording()
        this.applicationEventRecorder.clearRecordedEvents()
    }

    @AfterEach
    fun afterEach() {
        this.applicationEventRecorder.stopRecording()
        this.applicationEventRecorder.clearRecordedEvents()
    }

    @Test
    fun `do모시깽이 메서드는 이벤트를 발행한다`() {
        sut.do모시깽이()

        assertThat(this.applicationEventRecorder.getEvents())
            .containsExactly(
                모시깽이했다Event(foo = "모시"),
                모시깽이했다Event(foo = "깽이"),
            )
    }
}
