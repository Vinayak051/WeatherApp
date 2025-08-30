package com.example.weatherapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherSvc {
    private final String API="70354dc99102e3362a98bcd473ad000e";
    private final String base_url="https://api.openweathermap.org/data/2.5/weather";
    public String getWeather(String city){
        RestTemplate rt=new RestTemplate();
        String url=UriComponentsBuilder.fromHttpUrl(base_url).queryParam("q",city).queryParam("units","metric").queryParam("appid",API).toUriString();
        return rt.getForObject(url,String.class);
    }
}
