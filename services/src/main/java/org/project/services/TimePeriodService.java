package org.project.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.project.entities.TimePeriod;
import org.project.repositories.TimePeriodRepository;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class TimePeriodService {
    private TimePeriodRepository timePeriodRepository;

    public TimePeriod findById(long id) {
        log.debug("Start service for getting timePeriod id {}", id);
        return timePeriodRepository.findById(id).orElse(null);
    }

    public TimePeriod save(@NonNull TimePeriod timePeriod) {
        log.debug("Start service for saving timePeriod");
        return timePeriodRepository.save(timePeriod);
    }

    public void update(@NonNull TimePeriod timePeriod) {
        log.debug("Start service for updating timePeriod");
        timePeriodRepository.save(timePeriod);
    }

    public List<TimePeriod> findAll() {
        log.debug("Start service for getting all timePeriods");
        return timePeriodRepository.findAll();
    }

    public void deleteById(long id) {
        log.debug("Start service for deleting timePeriod id {}", id);
        timePeriodRepository.deleteById(id);
    }
}
