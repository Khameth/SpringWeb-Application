package org.project.config;

import org.project.controllers.*;
import org.project.repositories.*;
import org.project.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public GenderService genderService(GenderRepository genderRepository){
        return new GenderService(genderRepository);
    }
    @Bean
    public GoalService goalService(GoalRepository goalRepository){
        return new GoalService(goalRepository);
    }
    @Bean
    public StationService stationService(StationRepository stationRepository){
        return  new StationService(stationRepository);
    }
    @Bean
    public TimePeriodService timePeriodService(TimePeriodRepository timePeriodRepository) {
        return new TimePeriodService(timePeriodRepository);
    }
    @Bean
    public WorkerService workerService(WorkerRepository workerRepository){
        return new WorkerService(workerRepository);
    }
    @Bean
    public AboutController aboutController(){return new AboutController();}
    @Bean
    public GenderController genderController(GenderService genderService){
        return new GenderController(genderService);
    }
    @Bean
    public GoalController goalController(GoalService goalService,TimePeriodService timePeriodService){
        return new GoalController(timePeriodService,goalService);
    }
    @Bean
    public HomeController homeController(){return new HomeController();}
    @Bean
    public StationController stationController(StationService stationService, WorkerService workerService){
        return new StationController(stationService,workerService);
    }
    @Bean
    public WorkerController workerController(WorkerService workerService){
        return new WorkerController(workerService);
    }
}
