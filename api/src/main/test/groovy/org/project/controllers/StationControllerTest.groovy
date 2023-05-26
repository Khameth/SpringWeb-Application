package org.project.controllers

import org.project.controllers.exception.ExceptionHandlerController
import org.project.entities.Station
import org.project.services.StationService
import org.project.services.WorkerService
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
class StationControllerTest extends Specification{
    @Autowired
    private MockMvc mockMvc
    private Station station = new Station()
    private StationService stationService
    private WorkerService workerService
    private StationController stationController


    def setup() {
        stationService = Mock()
        workerService = Mock()
        stationController = new StationController(stationService,workerService)
        mockMvc = MockMvcBuilders.standaloneSetup(stationController).setControllerAdvice(new ExceptionHandlerController()).build()
    }

    def "Status is OK and model has attribute Station and view returned for /stations/{id}"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(stationController).setControllerAdvice(new ExceptionHandlerController()).build()
        stationService.findById(1) >> station
        expect: "status is ok"
        mockMvc.perform(MockMvcRequestBuilders.get("/stations/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("station", station))
                .andExpect(MockMvcResultMatchers.view().name("stations/station_info"))
    }

    def "ClassroomService is used in /station{id}"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/stations/1"))
        then:
        1 * stationService.findById(1)
    }

    def "Status is OK and model has attribute Station and view returned for /stations/add/new"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(stationController).setControllerAdvice(new ExceptionHandlerController()).build()
        expect: "status is ok"
        mockMvc.perform(MockMvcRequestBuilders.get("/stations/add/new"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("station", station))
                .andExpect(MockMvcResultMatchers.view().name("stations/station_add"))
    }

    def "StationService is used in /stations/add"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.post("/stations/add"))
        then:
        1 * stationService.save(*_)
    }

    def "Status is OK and model has attribute Station and view returned for /station/edit/{id}"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(stationController).setControllerAdvice(new ExceptionHandlerController()).build()
        stationService.findById(1) >> station
        expect: "status is ok"
        mockMvc.perform(MockMvcRequestBuilders.get("/stations/edit/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("station", station))
                .andExpect(MockMvcResultMatchers.view().name("stations/station_edit"))
    }

    def "StationService is used in /stations/edit/{id}"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/stations/edit/1"))
        then:
        1 * stationService.findById(1)
    }

    def "StationService is used in /stations/edit"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.post("/stations/edit"))
        then:
        1 * stationService.update(*_)
    }

    def "StationService is used in /stations/delete/{id}"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/stations/delete/1"))
        then:
        1 * stationService.deleteById(*_)
    }
}
