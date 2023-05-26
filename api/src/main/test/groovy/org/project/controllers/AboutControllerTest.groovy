package org.project.controllers

import org.project.controllers.exception.ExceptionHandlerController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification;

@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration
class AboutControllerTest extends Specification {
    @Autowired
    private MockMvc mockMvc
    private AboutController aboutController = new AboutController()

    def "Status is OK and view returned for /about"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(aboutController).setControllerAdvice(new ExceptionHandlerController()).build()
        expect: "status is ok; view about/about returned"
        mockMvc.perform(MockMvcRequestBuilders.get("/about"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("about/about"))
    }
}
