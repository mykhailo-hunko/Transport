package com.codeit.transport

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import java.time.LocalTime


class TransportActivity : AppCompatActivity() {


    private lateinit var routeRadioGroup: RadioGroup
    private lateinit var tramStopRadioGroup: RadioGroup
    private lateinit var dayRadioGroup: RadioGroup
    private lateinit var table: TableLayout
    private lateinit var nearestTramTextView: TextView
    private lateinit var editText: AutoCompleteTextView

    private lateinit var map: MutableMap<String, Tram>
    private lateinit var timeData: TimeData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transport)
        routeRadioGroup = findViewById(R.id.routeRadioGroup)
        tramStopRadioGroup = findViewById(R.id.tramStopRadioGroup)
        dayRadioGroup = findViewById(R.id.dayRadioGroup)
        table = findViewById(R.id.table)
        nearestTramTextView = findViewById(R.id.nearestTram)
        //map = inzialazeMap()
        map = timeData.getStationMap()
        editText = findViewById(R.id.autoTextView)
        setAdapterForInput()
        fillTableLayout()
        val onCheckedChangeListener = RadioGroup.OnCheckedChangeListener { _: RadioGroup, _: Int ->
            fillTableLayout()
            setAdapterForInput()
        }

        dayRadioGroup.setOnCheckedChangeListener(onCheckedChangeListener)
        routeRadioGroup.setOnCheckedChangeListener(onCheckedChangeListener)
        tramStopRadioGroup.setOnCheckedChangeListener(onCheckedChangeListener)

    }

    private fun setAdapterForInput() {
        val key = getKeyString()
        var stringArray = when {
            key.startsWith("16A_Saltovska") -> {
                resources.getStringArray(R.array.stops_16a_to_hydr)
            }
            key.startsWith("16A_Hydropark") -> {
                resources.getStringArray(R.array.stops_16a_to_salt)
            }
            key.startsWith("16_Saltovska") -> {
                resources.getStringArray(R.array.stops_16_to_hydr)
            }
            else -> {
                resources.getStringArray(R.array.stops_16_to_salt)
            }
        }
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            stringArray
        )
        editText.setAdapter(adapter)
    }

    private fun fillTableLayout() {
        val count = table.childCount
        for (i in 0 until count) {
            val child: View = table.getChildAt(i)
            if (child is TableRow) (child as ViewGroup).removeAllViews()
        }
        val tram: Tram = map[getKeyString()]!!
        setNearestTram(tram)

        for (i in 0..13) {
            val row = TableRow(this)
            var textView = TextView(this)

            val currentTime = getMinutesForGivenHour(i + 5, tram)

            textView.text = if (i + 5 < 10) {
                " " + (i + 5) + " "
            } else {
                "" + (i + 5) + " "
            }
            textView.textSize = 20F
            textView.typeface = Typeface.DEFAULT_BOLD
            textView.setBackgroundColor(Color.WHITE)
            row.addView(textView)

            for (element in currentTime) {
                textView = TextView(this)
                textView.textSize = 18F
                textView.setPadding(10)
                textView.gravity = Gravity.END + Gravity.CENTER_VERTICAL
                textView.setBackgroundColor(Color.WHITE)
                textView.text = "$element "
                row.addView(textView)
            }
            table.addView(row)
        }
    }

    private fun setNearestTram(tram: Tram) {
        val timeNow = LocalTime.now()
        val minutesForAdd = if (tram.information.startsWith("16A")) {
            25L
        } else {
            4L
        }
        for (i in tram.list) {
            if (timeNow.hour - i.hour < 2 || timeNow.hour - i.hour > -2) {
                if (i.plusMinutes(minutesForAdd) > timeNow) {
                    val futureTram = i.plusMinutes(minutesForAdd)

                    val minute =
                        if (futureTram.minute < 10) "0" + futureTram.minute else futureTram.minute
                    nearestTramTextView.text =
                        getString(R.string.the_nearest_tram) + " ${futureTram.hour}:$minute"
                    return
                }
            }
        }
    }

    private fun getMinutesForGivenHour(hour: Int, tram: Tram): List<Int> {
        val list = mutableListOf<Int>()
        for (time in tram.list) {
            if (time.hour == hour) {
                list.add(time.minute)
            }
        }
        return list

    }


    private fun getKeyString(): String {
        val key = StringBuilder()
        when (routeRadioGroup.checkedRadioButtonId) {
            R.id.radioButton16 -> key.append("16_")
            R.id.radioButton16A -> key.append("16A_")
        }
        when (tramStopRadioGroup.checkedRadioButtonId) {
            R.id.saltRadioButton -> key.append("Saltovska_")
            R.id.hydrRadioButton -> key.append("Hydropark_")
        }
        when (dayRadioGroup.checkedRadioButtonId) {
            R.id.weekDayRadioButton -> key.append("Weekday")
            R.id.saturdayRadioButton -> key.append("Saturday")
            R.id.sundayRadioButton -> key.append("Sunday")
        }
        return key.toString()
    }
}