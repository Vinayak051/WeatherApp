package com.example.weatherapp.controller;

import com.example.weatherapp.service.WeatherSvc;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "*")
public class WeatherCtrl {
    private final WeatherSvc wsvc;

    public WeatherCtrl(WeatherSvc wsvc) {
        this.wsvc = wsvc;
    }

    @GetMapping
    public String getWeather(@RequestParam String city){
        return wsvc.getWeather(city);
    }
}
