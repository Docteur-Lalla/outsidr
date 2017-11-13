package fr.istic.m2;

import fr.istic.m2.entities.Meteo;
import fr.istic.m2.entities.MeteoMail;
import fr.istic.m2.jackson.JacksonParsing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("fr.istic.m2.entities")
public class Application {
  @Autowired
  private JacksonParsing jackson;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner() {
    return args -> {
      jackson.cityParsing();
    };

  }

}
