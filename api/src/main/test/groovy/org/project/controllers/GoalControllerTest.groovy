package org.project.controllers

import org.project.controllers.exception.ExceptionHandlerController
import org.project.entities.Goal
import org.project.services.GoalService
import org.project.services.StationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification


@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration
class GoalControllerTest extends Specification{
    @Autowired
    private MockMvc mockMvc
    private Goal goal = new Goal()
    private GoalService goalService
    private StationService stationService
    private GoalController goalController


    def setup() {
        goalService = Mock()
        stationService = Mock()
        goalController = new GoalController(goalService,stationService)
        mockMvc = MockMvcBuilders.standaloneSetup(goalController).setControllerAdvice(new ExceptionHandlerController()).build()
    }

    def "Status is OK and model has attribute Goal and view returned for /goals/{id}"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(goalController).setControllerAdvice(new ExceptionHandlerController()).build()
        goalService.findById(1) >> goal
        expect: "status is ok"
        mockMvc.perform(MockMvcRequestBuilders.get("/goals/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("goal", goal))
                .andExpect(MockMvcResultMatchers.view().name("goals/goal_info"))
    }

    def "GoalService is used in /goal{id}"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/goals/1"))
        then:
        1 * goalService.findById(1)
    }

    def "Status is OK and model has attribute Goal and view returned for /goals/add/new"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(goalController).setControllerAdvice(new ExceptionHandlerController()).build()
        expect: "status is ok"
        mockMvc.perform(MockMvcRequestBuilders.get("/goals/add/new"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("goal", goal))
                .andExpect(MockMvcResultMatchers.view().name("goals/goal_add"))
    }

    def "GoalService is used in /goals/add"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.post("/goals/add"))
        then:
        1 * goalService.save(*_)
    }

    def "Status is OK and model has attribute Goal and view returned for /goals/edit/{id}"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(goalController).setControllerAdvice(new ExceptionHandlerController()).build()
        goalService.findById(1) >> goal
        expect: "status is ok"
        mockMvc.perform(MockMvcRequestBuilders.get("/goals/edit/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("goal", goal))
                .andExpect(MockMvcResultMatchers.view().name("goals/goal_edit"))
    }

    def "GoalService is used in /goals/edit/{id}"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/goals/edit/1"))
        then:
        1 * goalService.findById(1)
    }

    def "GoalService is used in /goals/edit"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.post("/goals/edit"))
        then:
        1 * goalService.update(*_)
    }

    def "GoalService is used in /goals/delete/{id}"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/goals/delete/1"))
        then:
        1 * goalService.deleteById(*_)
    }
}
