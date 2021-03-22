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


class MainActivity : AppCompatActivity() {


    private lateinit var routeRadioGroup: RadioGroup
    private lateinit var tramStopRadioGroup: RadioGroup
    private lateinit var dayRadioGroup: RadioGroup
    private lateinit var table: TableLayout
    private lateinit var nearestTramTextView: TextView
    private lateinit var toHydroparkButton: Button
    private lateinit var toPavlovaButton: Button
    private lateinit var saltRadioButton: RadioButton
    private lateinit var route16RadioButton: RadioButton
    private lateinit var map: MutableMap<String, Tram>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        routeRadioGroup = findViewById(R.id.routeRadioGroup)
        tramStopRadioGroup = findViewById(R.id.tramStopRadioGroup)
        dayRadioGroup = findViewById(R.id.dayRadioGroup)
        table = findViewById(R.id.table)
        nearestTramTextView = findViewById(R.id.nearestTram)
/*        toHydroparkButton = findViewById(R.id.toHydroparkButton)
        toPavlovaButton = findViewById(R.id.toPavlovaButton)*/
        saltRadioButton = findViewById(R.id.saltRadioButton)
        route16RadioButton = findViewById(R.id.radioButton16)
        map = inzialazeMap()
        fillTableLayout()
        var onCheckedChangeListener = RadioGroup.OnCheckedChangeListener { _: RadioGroup, _: Int ->
            fillTableLayout()
        }

        dayRadioGroup.setOnCheckedChangeListener(onCheckedChangeListener)
        routeRadioGroup.setOnCheckedChangeListener(onCheckedChangeListener)
        tramStopRadioGroup.setOnCheckedChangeListener(onCheckedChangeListener)

     /*   toHydroparkButton.setOnClickListener {
            route16RadioButton.isChecked = false
            saltRadioButton.isChecked = true
        }

        toPavlovaButton.setOnClickListener {
            route16RadioButton.isChecked = true
            saltRadioButton.isChecked = false
        }*/

    }

    private fun fillTableLayout() {
        val count = table.childCount
        for (i in 0 until count) {
            val child: View = table.getChildAt(i)
            if (child is TableRow) (child as ViewGroup).removeAllViews()
        }
        var tram = map[getKeyString()]
        setNearestTram(tram!!)
        for (i in 0..13) {
            val row = TableRow(this)
            var textView = TextView(this)

            var currentTime: MutableList<Int> = getMinutesForGivenHour(i + 5, tram!!)

            textView.text = if (i + 5 < 10) {
                " " + (i + 5) + " "
            } else {
                "" + (i + 5) + " "
            }
            textView.textSize = 20F
            textView.typeface = Typeface.DEFAULT_BOLD
            textView.setBackgroundColor(Color.WHITE)
            row.addView(textView)

            for (j in 0 until currentTime.size) {
                textView = TextView(this)
                textView.textSize = 18F
                textView.setPadding(10)
                textView.gravity = Gravity.END + Gravity.CENTER_VERTICAL//Gravity.CENTER
                textView.setBackgroundColor(Color.WHITE)
                textView.text = currentTime[j].toString() + " "
                row.addView(textView)
            }
            table.addView(row)
        }
    }

    private fun setNearestTram(tram: Tram) {
        var timeNow = LocalTime.now()
        var minutesForAdd = if (tram.information.startsWith("16A")) {
            25L
        } else {
            4L
        }
        for (i in tram.list) {
            if (timeNow.hour == i.hour) {
                if (i.plusMinutes(minutesForAdd) > timeNow) {
                    var futureTram = i.plusMinutes(minutesForAdd)
                    nearestTramTextView.text =
                        "The hearest tram are arriving at: ${futureTram.hour}:${futureTram.minute}"
                    return
                }
            }
        }
    }

    private fun getMinutesForGivenHour(hour: Int, tram: Tram): MutableList<Int> {
        var list = mutableListOf<Int>()
        for (time in tram.list) {
            if (time.hour == hour) {
                list.add(time.minute)
            }
        }
        return list

    }


    private fun getKeyString(): String {
        var key = StringBuilder()
        when (routeRadioGroup.checkedRadioButtonId) {
            R.id.radioButton16 -> key.append("16 ")
            R.id.radioButton16A -> key.append("16A ")
        }
        when (tramStopRadioGroup.checkedRadioButtonId) {
            R.id.saltRadioButton -> key.append("Saltovska ")
            R.id.hydrRadioButton -> key.append("Hydropark ")
        }
        when (dayRadioGroup.checkedRadioButtonId) {
            R.id.weekDayRadioButton -> key.append("Weekday")
            R.id.saturdayRadioButton -> key.append("Saturday")
            R.id.sundayRadioButton -> key.append("Sunday")
        }
        return key.toString()
    }
}
/* companion object {
        private const val WEEKDAY_16_SALT = "16SaltovskaWeekday.json";
        private const val SATURDAY_16_SALT = "16SaltovskaSaturdayday.json";
        private const val SUNDAY_16_SALT = "16SaltovskaSunday.json";
        private const val WEEKDAY_16_HYDROPARK = "16HydroparkWeekday.json";
        private const val SATURDAY_16_HYDROPARK = "16HydroparkSaturdayday.json";
        private const val SUNDAY_16_HYDROPARK = "16HydroparkSunday.json";


        private const val WEEKDAY_16A_SALT = "16ASaltovskaSaturdayday.json";
        private const val SATURDAY_16A_SALT = "16ASaltovskaSaturdayday.json";
        private const val SUNDAY_16A_SALT = "16ASaltovskaSunday.json";
        private const val WEEKDAY_16A_HYDROPARK = "16AHydroparkWeekday.json";
        private const val SATURDAY_16A_HYDROPARK = "16AHydroparkSaturdayday.json";
        private const val SUNDAY_16A_HYDROPARK = "16AHydroparkSunday.json";
    }*/
/*
val dt = LocalTime.parse("23:22");
println(dt.hour)*/
