package org.project.repositories;

import org.project.entities.TimePeriod;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimePeriodRepository extends CrudRepository<TimePeriod, Long> {
    @Override
    List<TimePeriod> findAll();
}
