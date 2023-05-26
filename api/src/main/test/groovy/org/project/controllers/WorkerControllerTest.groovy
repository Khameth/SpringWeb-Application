package org.project.controllers

import org.project.controllers.exception.ExceptionHandlerController
import org.project.entities.Worker
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
class WorkerControllerTest extends Specification{
    @Autowired
    private MockMvc mockMvc
    private Worker worker = new Worker()
    private WorkerService workerService
    private WorkerController workerController


    def setup() {
        workerService = Mock()
        workerController = new WorkerController(workerService)
        mockMvc = MockMvcBuilders.standaloneSetup(workerController).setControllerAdvice(new ExceptionHandlerController()).build()
    }

    def "Status is OK and model has attribute Worker and view returned for /workers/{id}"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(workerController).setControllerAdvice(new ExceptionHandlerController()).build()
        workerService.findById(1) >> worker
        expect: "status is ok"
        mockMvc.perform(MockMvcRequestBuilders.get("/workers/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("worker", worker))
                .andExpect(MockMvcResultMatchers.view().name("workers/worker_info"))
    }

    def "WorkerService is used in /worker{id}"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/workers/1"))
        then:
        1 * workerService.findById(1)
    }

    def "Status is OK and model has attribute Station and view returned for /workers/add/new"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(workerController).setControllerAdvice(new ExceptionHandlerController()).build()
        expect: "status is ok"
        mockMvc.perform(MockMvcRequestBuilders.get("/workers/add/new"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("worker", worker))
                .andExpect(MockMvcResultMatchers.view().name("workers/worker_add"))
    }

    def "WorkerService is used in /workers/add"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.post("/workers/add"))
        then:
        1 * workerService.save(*_)
    }

    def "Status is OK and model has attribute Worker and view returned for /worker/edit/{id}"() {
        given:
        mockMvc = MockMvcBuilders.standaloneSetup(workerController).setControllerAdvice(new ExceptionHandlerController()).build()
        workerService.findById(1) >> worker
        expect: "status is ok"
        mockMvc.perform(MockMvcRequestBuilders.get("/workers/edit/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("worker", worker))
                .andExpect(MockMvcResultMatchers.view().name("workers/worker_edit"))
    }

    def "WorkerService is used in /workers/edit/{id}"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/workers/edit/1"))
        then:
        1 * workerService.findById(1)
    }

    def "WorkerService is used in /workers/edit"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.post("/workers/edit"))
        then:
        1 * workerService.update(*_)
    }

    def "WorkerService is used in /workers/delete/{id}"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/workers/delete/1"))
        then:
        1 * workerService.deleteById(*_)
    }
}
