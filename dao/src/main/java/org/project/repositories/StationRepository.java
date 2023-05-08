package org.project.repositories;

import org.project.entities.Station;
import org.project.entities.Worker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StationRepository extends CrudRepository<Station, Long> {
    @Override
    List<Station> findAll();
}
