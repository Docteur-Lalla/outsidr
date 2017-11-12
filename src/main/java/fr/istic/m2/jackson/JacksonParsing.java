package fr.istic.m2.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import fr.istic.m2.entities.Meteo;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class JacksonParsing {

    ObjectMapper map;

    public JacksonParsing(){
        this.map = new ObjectMapper();
    }

    public void firstParsing() throws IOException {
        map.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        List<Meteo> me = map.readValue(new URL("http://api.openweathermap.org/data/2.5/box/city?bbox=-4.860856545312458,41.309041165576524,9.674055564062542,51.10892986765849,100000&APPID=cd04d5db91342e48c53e08b7a2fe6b2d"), MeteoList.class).getMeteoList();
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
