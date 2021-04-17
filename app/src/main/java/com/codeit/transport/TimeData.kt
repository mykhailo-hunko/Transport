package com.codeit.transport

import android.content.Context
import java.time.LocalTime

class TimeData{
    var context : Context? = null
    private val schedule: MutableList<MutableList<LocalTime>> = mutableListOf()
    private val numberOfWays: Int = 12;
    private val _stopsNames : MutableList<String> = mutableListOf("16A_Saltovska_Weekday", "16A_Saltovska_Saturday", "16A_Saltovska_Sunday", "16_Saltovska_Weekday", "16_Saltovska_Saturday", "16_Saltovska_Sunday", "16A_Hydropark_Weekday", "16A_Hydropark_Saturday", "16A_Hydropark_Sunday", "16_Hydropark_Weekday", "16_Hydropark_Saturday", "16_Hydropark_Sunday")
    private val _salt16Weekday : MutableList<String> = mutableListOf("05:49" , "06:10" , "06:25" , "06:45" , "07:09" , "07:36" , "07:49" , "08:12" , "08:32" , "08:57" , "09:21" , "09:38" , "09:57" , "10:40" , "11:02" , "11:26" , "11:48" , "12:02" , "12:26" , "12:51" , "13:13" , "13:48" , "14:13" , "14:35" , "14:57" , "15:11" , "15:35" , "16:03" , "16:33" , "17:00" , "17:27");
    private val _salt16Saturday : MutableList<String> = mutableListOf("05:48" , "06:11" , "06:29" , "06:49" , "07:08" , "07:28" , "07:53" , "08:14" , "08:33" , "08:47" , "09:11" , "09:37" , "10:12" , "10:35" , "10:59" , "11:26" , "11:46" , "12:02" , "12:20" , "12:52" , "13:08" , "13:22" , "13:42" , "14:13" , "14:49" , "15:07" , "15:35" , "15:51" , "16:08" , "16:33");
    private val _salt16Sunday : MutableList<String> = mutableListOf("06:12" , "07:01" , "07:16" , "07:35" , "07:53" , "08:20" , "08:34" , "09:00" , "09:12" , "09:42" , "10:23" , "10:45" , "11:00" , "11:32" , "11:46" , "12:14" , "12:28" , "12:54" , "13:14" , "13:50" , "14:14" , "14:50" , "15:10" , "15:34" , "15:55" , "16:22" , "16:41" , "16:53" , "17:16");
    private val _hydr16Weekday : MutableList<String> = mutableListOf("06:18" , "06:40" , "06:54" , "07:14" , "07:38" , "08:06" , "08:18" , "08:41" , "09:03" , "09:26" , "09:53" , "10:07" , "10:28" , "11:11" , "11:31" , "11:56" , "12:19" , "12:33" , "12:59" , "13:22" , "13:44" , "14:19" , "14:44" , "15:09" , "15:40" , "16:06" , "16:35" , "17:02" , "17:29" , "17:56");
    private val _hydr16Saturday : MutableList<String> = mutableListOf("06:17" , "06:40" , "06:58" , "07:20" , "07:37" , "07:57" , "08:24" , "08:43" , "09:03" , "09:16" , "09:42" , "10:06" , "10:43" , "11:04" , "11:29" , "11:55" , "12:16" , "12:31" , "12:50" , "13:22" , "13:37" , "13:51" , "14:11" , "14:44" , "15:18" , "15:36" , "16:04" , "16:20" , "16:37" , "17:02");
    private val _hydr16Sunday : MutableList<String> = mutableListOf("06:41" , "07:30" , "07:45" , "08:04" , "08:50" , "09:03" , "09:30" , "09:43" , "10:13" , "10:53" , "11:14" , "11:29" , "12:02" , "12:16" , "12:43" , "13:23" , "13:37" , "14:01" , "14:18" , "14:44" , "15:19" , "15:39" , "16:03" , "16:25" , "16:51" , "17:10" , "17:22" , "17:45");
    private val _salt16AWeekday : MutableList<String> = mutableListOf("05:56" , "06:20" , "06:39" , "06:59" , "07:17" , "07:45" , "08:01" , "08:20" , "08:42" , "09:04" , "09:30" , "09:47" , "10:22" , "10:53" , "11:18" , "11:39" , "11:59" , "12:14" , "12:37" , "12:59" , "13:18" , "14:01" , "14:21" , "14:38" , "14:59" , "15:25" , "15:52" , "16:17" , "16:46" , "17:21" , "17:44");
    private val _salt16ASaturday : MutableList<String> = mutableListOf("05:58" , "06:17" , "06:37" , "07:04" , "07:22" , "07:42" , "08:02" , "08:28" , "08:42" , "08:58" , "09:21" , "09:57" , "10:26" , "10:46" , "11:06" , "11:33" , "11:52" , "12:13" , "12:34" , "13:02" , "13:15" , "13:35" , "13:55" , "14:24" , "15:02" , "15:15" , "15:44" , "16:01" , "16:21" , "16:48");
    private val _salt16ASunday : MutableList<String> = mutableListOf("06:37" , "07:09" , "07:22" , "07:41" , "07:56" , "08:28" , "08:41" , "08:57" , "09:22" , "09:59" , "10:19" , "10:39" , "11:07" , "11:39" , "11:54" , "12:07" , "12:35" , "13:02" , "13:15" , "13:29" , "13:56" , "14:22" , "14:55" , "15:15" , "15:48" , "16:01" , "16:35" , "16:55" , "17:09" , "17:33");
    private val _hydr16AWeekday : MutableList<String> = mutableListOf("06:47" , "07:10" , "07:31" , "07:51" , "08:07" , "08:36" , "08:51" , "09:10" , "09:32" , "09:54" , "10:21" , "10:37" , "11:12" , "11:43" , "12:08" , "12:29" , "12:43" , "13:04" , "13:27" , "13:50" , "14:08" , "14:51" , "15:14" , "15:39" , "16:16" , "16:44" , "17:07" , "17:36" , "18:12" , "18:34");
    private val _hydr16ASaturday : MutableList<String> = mutableListOf("06:46" , "07:05" , "07:25" , "07:53" , "08:11" , "08:30" , "08:52" , "09:18" , "09:32" , "09:47" , "10:12" , "10:47" , "11:18" , "11:37" , "11:58" , "12:23" , "12:42" , "13:03" , "13:26" , "13:53" , "14:06" , "14:27" , "14:46" , "15:14" , "15:52" , "16:08" , "16:36" , "16:51" , "17:11" , "17:40");
    private val _hydr16ASunday : MutableList<String> = mutableListOf("07:25" , "07:57" , "08:11" , "08:29" , "08:47" , "09:19" , "09:31" , "09:47" , "10:13" , "10:51" , "11:09" , "11:29" , "11:59" , "12:31" , "12:45" , "12:57" , "13:25" , "13:53" , "14:06" , "14:20" , "14:48" , "15:12" , "15:47" , "16:07" , "16:38" , "16:53" , "17:26" , "17:46" , "18:01" , "18:23");
    private var _allStops = mutableListOf(
        _salt16AWeekday,
        _salt16ASaturday,
        _salt16ASunday,
        _salt16Weekday,
        _salt16Saturday,
        _salt16Sunday,
        _hydr16AWeekday,
        _hydr16ASaturday,
        _hydr16ASunday,
        _hydr16Weekday,
        _hydr16Saturday,
        _hydr16Sunday
        )

    private var tramMap: MutableMap<String, Tram> = mutableMapOf()
    private var Hydr16Map: MutableMap<Int, String> = mutableMapOf()
    private var Salt16Map: MutableMap<Int, String> = mutableMapOf()
    private var Hydr16AMap: MutableMap<Int, String> = mutableMapOf()
    private var Salt16AMap: MutableMap<Int, String> = mutableMapOf()
    private val currentStationMap: MutableMap<String, Tram> = mutableMapOf()

    val hydr16 = mutableListOf<String>()

    val salt16 = mutableListOf<String>()

    val hydr16A = mutableListOf<String>()

    val salt16A = mutableListOf<String>()

    init{
        for(i in 0 until numberOfWays){
            val list = mutableListOf<LocalTime>()
            for(j in 0 until _allStops[i].size){
                list.add(LocalTime.parse(_allStops[i][j]))
            }
            schedule.add(list)
            val tmpTram = Tram(_stopsNames[i], schedule[i])
            tramMap[_stopsNames[i]] = tmpTram
        }
    }

    fun initAllStations(){
        context?.let {
            hydr16.addAll(it.resources.getStringArray(R.array.stops_16_to_hydr).toList())
            salt16A.addAll(it.resources.getStringArray(R.array.stops_16a_to_salt).toList())
            hydr16A.addAll(it.resources.getStringArray(R.array.stops_16a_to_hydr).toList())
            salt16.addAll(it.resources.getStringArray(R.array.stops_16_to_salt).toList())
        }


        for(i in 0 until hydr16Size){
            Hydr16Map[i] = hydr16[i]
        }

        for(i in 0 until salt16Size){
            Salt16Map[i] = salt16[i]
        }

        for(i in 0 until hydr16ASize){
            Hydr16AMap[i] = hydr16A[i]
        }

        for(i in 0 until salt16ASize){
            Salt16AMap[i] = salt16A[i]
        }
    }

    fun getStationMap(): MutableMap<String, Tram>{
        return tramMap
    }

    fun getCurrentStationMap(): MutableMap<String, Tram>{
        return currentStationMap
    }

    fun getCurrentStationTime(path: String, station: String){
        //for(Pat in Paths.values()){
        //}
        val multiple = when {
            path.startsWith("16A_Saltovska") -> {
                hydr16A.indexOf(hydr16A.firstOrNull{s: String ->s == station})
            }
            path.startsWith("16A_Hydropark") -> {
                salt16A.indexOf(salt16A.firstOrNull{s: String ->s == station})
            }
            path.startsWith("16_Saltovska") -> {
                hydr16.indexOf(hydr16.firstOrNull{s: String ->s == station})
            }
            path.startsWith("16_Hydropark") -> {
                salt16.indexOf(salt16.firstOrNull{s: String ->s == station})
            }
            else ->{
                -1
            }
        }

        generateScheldule(multiple + 1, path)
   }

    private fun generateScheldule(multiple: Int, path: String): MutableMap<String, Tram>{
        val localTimeList:  MutableList<LocalTime> = mutableListOf()

        if(multiple != 1){
            for(i in 0 until (tramMap[path]?.list?.size ?: 0)){
                localTimeList.add(((tramMap[path]?.list?.get(i)?.plusSeconds((multiple*111).toLong()) ?: 0) as LocalTime))
            }
        }
        else{
            for(i in 0 until (tramMap[path]?.list?.size ?: 0)){
                localTimeList.add(((tramMap[path]?.list?.get(i) ?: 0) as LocalTime))
            }
        }

        val tmp = Tram(path, localTimeList)
        currentStationMap[path] = tmp
        return currentStationMap
    }

    companion object {
        const val hydr16Size = 16
        const val salt16Size = 27
        const val hydr16ASize = 27 // 111 секунд
        const val salt16ASize = 16
    }
}