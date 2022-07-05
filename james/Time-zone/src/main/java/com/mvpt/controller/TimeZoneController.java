package com.mvpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.sql.Time;
import java.util.TimeZone;

@Controller
public class TimeZoneController {

    @GetMapping("/time-zone")
    public String getTimeByTimeZone (
            ModelMap modelMap,
            @RequestParam (
                    name = "city",
                    defaultValue = "Asia/Ho_Chi_Minh",
                    required = false
            ) String city
            ){

        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);

        long local_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());

        date.setTime(local_time);

        modelMap.addAttribute("date", date);
        modelMap.addAttribute("city", city);

        return "index";
    }

}
