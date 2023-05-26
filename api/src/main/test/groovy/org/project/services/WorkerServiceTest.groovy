package org.project.services

import org.project.entities.Worker
import org.project.repositories.WorkerRepository
import spock.lang.Specification


class WorkerServiceTest extends Specification{
    private WorkerService workerService
    private WorkerRepository workerRepository
    private Worker worker

    def setup(){
        workerRepository = Mock()
        workerService = new WorkerService(workerRepository)
        worker = new Worker()
    }

    def "WorkerRepository is used in findById(long)"() {
        given:
        WorkerRepository stubRepo = Stub(WorkerRepository)
        WorkerService service = new WorkerService(stubRepo)
        stubRepo.findById(1) >> Optional.of(worker)
        when:
        Worker testWorker = service.findById(1)
        then:
        testWorker == worker
    }
    def "WorkerRepository is used in save(Worker) "() {
        when:
        workerService.save(worker)
        then:
        1 * workerRepository.save(worker)
    }

    def "WorkerRepository is used in update(Worker) "() {
        when:
        workerService.update(worker)
        then:
        1 * workerRepository.save(worker)
    }

    def "WorkerRepository is used in findAll() "() {
        when:
        workerService.findAll()
        then:
        1 * workerRepository.findAll()
    }

    def "WorkerRepository is used in deleteById(long) "() {
        when:
        workerService.deleteById(1)
        then:
        1 * workerRepository.deleteById(1)
    }
}