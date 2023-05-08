package org.project.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.project.entities.Station;
import org.project.entities.Worker;
import org.project.repositories.StationRepository;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class StationService {
    private StationRepository stationRepository;

    public Station findById(long id) {
        log.debug("Start service for getting station id {}", id);
        return stationRepository.findById(id).orElse(null);
    }

    public Station save(@NonNull Station station) {
        log.debug("Start service for saving station");
        return stationRepository.save(station);
    }

    public void update(@NonNull Station station) {
        log.debug("Start service for updating station");
        stationRepository.save(station);
    }

    public List<Station> findAll() {
        log.debug("Start service for getting all stations");
        return stationRepository.findAll();
    }

    public void deleteById(long id) {
        log.debug("Start service for deleting station id {}", id);
        stationRepository.deleteById(id);
    }
    public void addWorker(@NonNull Station station, @NonNull Worker worker){
        log.debug("Start service for adding worker to the station");
        station.getWorkers().add(worker);
    }
    public void deleteWorker(@NonNull Station station, @NonNull Worker worker){
        log.debug("Start service for deleting worker from the station");
        station.getWorkers().remove(worker);
    }
}
