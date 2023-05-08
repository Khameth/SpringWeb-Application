package org.project.repositories;


import org.project.entities.Worker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    @Override
    List<Worker> findAll();

}
