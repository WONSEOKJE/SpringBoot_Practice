package com.example.demo.calendarcontroller;

import com.example.demo.dto.Calendar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class CalendarController {

    private ArrayList<Calendar> calendar = new ArrayList<>();

    @GetMapping("/all/schedule")
    public ArrayList<Calendar> schedule() {
        return calendar;
    }

    @GetMapping("/put/schedule")
    public ArrayList<Calendar> putSchedule(Calendar c) {
        boolean flag = true;
        for (int i = 0; i < calendar.size(); i++) {
            if (calendar.get(i).getDate().equals(c.getDate())) {
                calendar.set(i,c);
                flag = false;
            }
        }
        if (flag) {
            calendar.add(c);
        }
        return calendar;
    }

}
