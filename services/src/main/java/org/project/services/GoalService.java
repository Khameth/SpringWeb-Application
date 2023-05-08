package org.project.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.project.entities.Goal;
import org.project.repositories.GoalRepository;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class GoalService {
    private GoalRepository goalRepository;

    public Goal findById(long id) {
        log.debug("Start service for getting goal id {}", id);
        return goalRepository.findById(id).orElse(null);
    }

    public Goal save(@NonNull Goal goal) {
        log.debug("Start service for saving goal");
        return goalRepository.save(goal);
    }

    public void update(@NonNull Goal goal) {
        log.debug("Start service for updating goal");
        goalRepository.save(goal);
    }

    public List<Goal> findAll() {
        log.debug("Start service for getting all goals");
        return goalRepository.findAll();
    }

    public void deleteById(long id) {
        log.debug("Start service for deleting goal id {}", id);
        goalRepository.deleteById(id);
    }
}
