package com.codeit.transport

import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.RadioGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jackandphantom.customtogglebutton.CustomToggle
import com.jackandphantom.customtogglebutton.CustomToggle.OnToggleClickListener


class MainActivity : AppCompatActivity() {


    private lateinit var routeCustomToggle: CustomToggle
    private lateinit var distinctCustomToggle: CustomToggle
    private lateinit var radioGroup: RadioGroup
    private lateinit var tableLayout: TableLayout
    private lateinit var nearestTramTextView: TextView
    private lateinit var map: MutableMap<String, Tram>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        routeCustomToggle = findViewById(R.id.routeToggle)
        distinctCustomToggle = findViewById(R.id.distinctToggle)
        radioGroup = findViewById(R.id.radioGroup)
        tableLayout = findViewById(R.id.tableForShed)
        nearestTramTextView = findViewById(R.id.nearestTram)

        map = inzialazeMap()
        // Toast.makeText(this, routeCustomToggle.isEnabled.toString(), Toast.LENGTH_LONG).show()

        routeCustomToggle.setOnToggleClickListener(object : OnToggleClickListener {
            override fun onLefToggleEnabled(enabled: Boolean) {
                fillTableLayout()
            }

            override fun onRightToggleEnabled(enabled: Boolean) {
                fillTableLayout()
            }
        })

        distinctCustomToggle.setOnToggleClickListener(object : OnToggleClickListener {
            override fun onLefToggleEnabled(enabled: Boolean) {
                fillTableLayout()
            }

            override fun onRightToggleEnabled(enabled: Boolean) {
                fillTableLayout()
            }
        })

        radioGroup.setOnCheckedChangeListener { _: RadioGroup, _: Int ->
            fillTableLayout()
        }
    }

    private fun fillTableLayout() {
        var tram = map[getKeyString()]
        tableLayout.isShrinkAllColumns = true
        tableLayout.isStretchAllColumns = true
        for (i in 0..12) {
            val tableRow = TableRow(this)
          /*  tableRow.layoutParams = TableRow.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )*/
            var textView = TextView(this)
            textView.layoutParams =
                TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            var currentTime: MutableList<Int> = getMinutesForGivenHour(i + 5, tram!!)
            textView.text = "" + i + 5
            tableRow.addView(textView, 0)
            tableRow.addView(textView)
            for (j in 0 until currentTime.size) {
                textView.text = currentTime[j].toString()
                //tableRow.addView(textView)
            }

            /*  textView.text = tram!!.list[3].minute.toString()
              tableRow.addView(textView, 0)*/


            tableLayout.addView(tableRow)
        }

    }

    private fun getMinutesForGivenHour(hour: Int, tram: Tram): MutableList<Int> {
        var list = mutableListOf<Int>()
        for (time in tram.list) {
            if (time.hour == hour) {
                list.add(hour)
            }
        }
        return list
    }


    fun getKeyString(): String {
        var key = StringBuilder()
        if (routeCustomToggle.isEnabled) {
            key.append("16 ")
        } else {
            key.append("16A ")
        }
        if (distinctCustomToggle.isEnabled) {
            key.append("Saltovska ")
        } else {
            key.append("Hydropark ")
        }
        when (radioGroup.checkedRadioButtonId) {
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
