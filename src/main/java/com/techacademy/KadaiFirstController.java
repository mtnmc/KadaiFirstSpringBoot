package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KadaiFirstController {
    // http://localhost:8080/dayofweek/20191231
    // 仕様1:指定日の曜日を算定する
    @GetMapping("dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable String val1) {


        int yyyy = Integer.parseInt(val1.substring(0,4));
        int mm = Integer.parseInt(val1.substring(4,6));
        int dd = Integer.parseInt(val1.substring(6));

        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);
        String dayOfWeek  = "";

        switch (cal.get(Calendar.DAY_OF_WEEK)) {
        case Calendar.SUNDAY:
            //日曜日
            dayOfWeek = "Sunday";
            break;
        case Calendar.MONDAY:
            //月曜日
            dayOfWeek = "Monday";
            break;
        case Calendar.TUESDAY:
            //火曜日
            dayOfWeek = "Tuesday";
            break;
        case Calendar.WEDNESDAY:
            //水曜日
            dayOfWeek = "Wednesday";
            break;
        case Calendar.THURSDAY:
            //木曜日
            dayOfWeek = "Thursday";
            break;
        case Calendar.FRIDAY:
            //金曜日
            dayOfWeek = "Friday";
            break;
        case Calendar.SATURDAY:
            //土曜日
            dayOfWeek = "Saturday";
            break;
      }

    return dayOfWeek;
    }

    // 仕様2：四則演算を行なう
    // http://localhost:8080/plus/6/3
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "実行結果 : " + res;
    }

    // http://localhost:8080/minus/6/3
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "実行結果 : " + res;
    }

    // http://localhost:8080/times/6/3
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "実行結果 : " + res;
    }

    // http://localhost:8080/divide/6/3
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "実行結果 : " + res;
    }




}

