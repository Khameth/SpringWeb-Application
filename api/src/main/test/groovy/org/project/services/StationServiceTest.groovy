package org.project.services

import org.project.entities.Station
import org.project.repositories.StationRepository
import spock.lang.Specification


class StationServiceTest extends Specification{
    private StationService stationService
    private StationRepository stationRepository
    private Station station

    def setup(){
        stationRepository = Mock()
        stationService = new StationService(stationRepository)
        station = new Station()
    }

    def "StationRepository is used in findById(long)"() {
        given:
        StationRepository stubRepo = Stub(StationRepository)
        StationService service = new StationService(stubRepo)
        stubRepo.findById(1) >> Optional.of(station)
        when:
        Station testStation = service.findById(1)
        then:
        testStation == station
    }
    def "StationRepository is used in save(Station) "() {
        when:
        stationService.save(station)
        then:
        1 * stationRepository.save(station)
    }

    def "StationRepository is used in update(Station) "() {
        when:
        stationService.update(station)
        then:
        1 * stationRepository.save(station)
    }

    def "StationRepository is used in findAll() "() {
        when:
        stationService.findAll()
        then:
        1 * stationRepository.findAll()
    }

    def "StationRepository is used in deleteById(long) "() {
        when:
        stationService.deleteById(1)
        then:
        1 * stationRepository.deleteById(1)
    }
}
