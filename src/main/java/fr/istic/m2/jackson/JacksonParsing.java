package fr.istic.m2.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.istic.m2.entities.City;
import fr.istic.m2.entities.Meteo;
import fr.istic.m2.spring.CityRepository;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
public class JacksonParsing {

    ObjectMapper map;

    @Autowired
    private CityRepository repository;

    public JacksonParsing(){
        this.map = new ObjectMapper();
        map.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public void cityParsing(){
        try {
            repository.deleteAll();
            List<City> city = map.readValue(new File("src/main/resources/city.list.json"), TypeFactory.defaultInstance().constructCollectionType(List.class, City.class));
            for(City c : city){
                if(c.getCountry().equals("FR")){
                    //repository.save(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Meteo> meteoParsing(City city){
        try {
            return map.readValue(new URL("https://api.openweathermap.org/data/2.5/weather?id="+ city.getId() +"&APPID=cd04d5db91342e48c53e08b7a2fe6b2d"), TypeFactory.defaultInstance().constructCollectionType(List.class, Meteo.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
class MeteoList{

    @JsonProperty("calctime")
    private int calctime;

    @JsonProperty("cnt")
    private int cnt;

    @JsonProperty("cod")
    private int cod;

    @JsonProperty("list")
    private List<Meteo> meteoList;

    public List<Meteo> getMeteoList(){return this.meteoList;}

    public void setMeteoList(List<Meteo> meteoList){this.meteoList = meteoList;}
}
