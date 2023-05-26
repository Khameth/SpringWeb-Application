package org.project.services

import org.project.entities.Goal
import org.project.repositories.GoalRepository
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@EnableAutoConfiguration
@SpringBootTest
class GoalServiceTest extends Specification{
    private GoalService goalService
    private GoalRepository goalRepository
    private Goal goal

    def setup(){
        goalRepository = Mock()
        goalService = new GoalService(goalRepository)
        goal = new Goal()
    }

    def "GoalRepository is used in findById(long)"() {
        given:
        GoalRepository stubRepo = Stub(GoalRepository)
        GoalService service = new GoalService(stubRepo)
        stubRepo.findById(1) >> Optional.of(goal)
        when:
        Goal testGoal = service.findById(1)
        then:
        testGoal == goal
    }
    def "GoalRepository is used in save(Goal) "() {
        when:
        goalService.save(goal)
        then:
        1 * goalRepository.save(goal)
    }

    def "GoalRepository is used in update(Goal) "() {
        when:
        goalService.update(goal)
        then:
        1 * goalRepository.save(goal)
    }

    def "GoalRepository is used in findAll() "() {
        when:
        goalService.findAll()
        then:
        1 * goalRepository.findAll()
    }

    def "GoalRepository is used in deleteById(long) "() {
        when:
        goalService.deleteById(1)
        then:
        1 * goalRepository.deleteById(1)
    }
}
