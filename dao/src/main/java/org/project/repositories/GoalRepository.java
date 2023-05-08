package org.project.repositories;

import org.project.entities.Goal;
import org.project.entities.Worker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoalRepository extends CrudRepository<Goal, Long> {
    @Override
    List<Goal> findAll();
}
