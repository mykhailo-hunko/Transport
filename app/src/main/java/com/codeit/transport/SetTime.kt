package com.codeit.transport

import java.time.LocalTime

fun WeekDaySalt16(): Tram {
    return Tram(
        "16 Saltovska Weekday",
        mutableListOf(
            LocalTime.parse("05:49"),
            LocalTime.parse("06:10"),
            LocalTime.parse("06:25"),
            LocalTime.parse("06:45"),
            LocalTime.parse("07:09"),
            LocalTime.parse("07:36"),
            LocalTime.parse("07:49"),
            LocalTime.parse("08:12"),
            LocalTime.parse("08:32"),
            LocalTime.parse("08:57"),
            LocalTime.parse("09:21"),
            LocalTime.parse("09:38"),
            LocalTime.parse("09:57"),
            LocalTime.parse("10:40"),
            LocalTime.parse("11:02"),
            LocalTime.parse("11:26"),
            LocalTime.parse("11:48"),
            LocalTime.parse("12:02"),
            LocalTime.parse("12:26"),
            LocalTime.parse("12:51"),
            LocalTime.parse("13:13"),
            LocalTime.parse("13:48"),
            LocalTime.parse("14:13"),
            LocalTime.parse("14:35"),
            LocalTime.parse("14:57"),
            LocalTime.parse("15:11"),
            LocalTime.parse("15:35"),
            LocalTime.parse("16:03"),
            LocalTime.parse("16:33"),
            LocalTime.parse("17:00"),
            LocalTime.parse("17:27")
        )
    )
}

fun WeekDaySalt16A(): Tram {
    return Tram(
        "16A Saltovska Weekday",
        mutableListOf(
            LocalTime.parse("05:56"),
            LocalTime.parse("06:20"),
            LocalTime.parse("06:39"),
            LocalTime.parse("06:59"),
            LocalTime.parse("07:17"),
            LocalTime.parse("07:45"),
            LocalTime.parse("08:01"),
            LocalTime.parse("08:20"),
            LocalTime.parse("08:42"),
            LocalTime.parse("09:04"),
            LocalTime.parse("09:30"),
            LocalTime.parse("09:47"),
            LocalTime.parse("10:22"),
            LocalTime.parse("10:53"),
            LocalTime.parse("11:18"),
            LocalTime.parse("11:39"),
            LocalTime.parse("11:59"),
            LocalTime.parse("12:14"),
            LocalTime.parse("12:37"),
            LocalTime.parse("12:59"),
            LocalTime.parse("13:18"),
            LocalTime.parse("14:01"),
            LocalTime.parse("14:21"),
            LocalTime.parse("14:38"),
            LocalTime.parse("14:59"),
            LocalTime.parse("15:25"),
            LocalTime.parse("15:52"),
            LocalTime.parse("16:17"),
            LocalTime.parse("16:46"),
            LocalTime.parse("17:21"),
            LocalTime.parse("17:44")
        )
    )
}

fun inzialazeMap(): MutableMap<String, Tram> {
    var map: MutableMap<String, Tram> = mutableMapOf()
    map["16A Saltovska Weekday"] = WeekDaySalt16A()
    map["16 Saltovska Weekday"] = WeekDaySalt16A()
    return map
}