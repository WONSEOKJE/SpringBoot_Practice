package com.example.formtest.calendar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CalendarController {

    ArrayList<HashMap<String,String>> calendar = new ArrayList<>();

    @GetMapping("/all/schedule")
    public ArrayList<HashMap<String,String>> schedule() {
        return calendar;
    }

    @GetMapping("/put/schedule")
    public ArrayList<HashMap<String,String>> putSchedule (@RequestParam HashMap<String,String> map) {
        boolean flag = true;
        for (int i = 0; i < calendar.size(); i++) {
            if (calendar.get(i).get("date").equals(map.get("date"))) {
                calendar.set(i,map);
                flag = false;
            }
        }
        if (flag) {
            calendar.add(map);
        }
        return calendar;
    }
}
