package fr.istic.m2.entities;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MeteoMail{

    @Scheduled(cron = "*/10 * * * * *")
    public void Test(){
        System.out.println("test");
    }
}
