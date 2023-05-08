package org.project.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.project.entities.Worker;
import org.project.repositories.WorkerRepository;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class WorkerService {
    private WorkerRepository workerRepository;

    public Worker findById(long id) {
        log.debug("Start service for getting worker id {}", id);
        return workerRepository.findById(id).orElse(null);
    }

    public Worker save(@NonNull Worker worker) {
        log.debug("Start service for saving worker");
        return workerRepository.save(worker);
    }

    public void update(@NonNull Worker worker) {
        log.debug("Start service for updating worker");
        workerRepository.save(worker);
    }

    public List<Worker> findAll() {
        log.debug("Start service for getting all workers");
        return workerRepository.findAll();
    }

    public void deleteById(long id) {
        log.debug("Start service for deleting worker id {}", id);
        workerRepository.deleteById(id);
    }

}
