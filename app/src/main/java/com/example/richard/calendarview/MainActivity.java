package com.example.richard.calendarview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker datePicker=(DatePicker)findViewById(R.id.dataPicker);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        Calendar c =Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        hour=c.get(Calendar.HOUR);
        minute=c.get(Calendar.MINUTE);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                MainActivity.this.year=i;
                MainActivity.this.month=i1;
                MainActivity.this.day=i2;
                showDate(year,month,day,hour,minute);
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                MainActivity.this.hour=i;
                MainActivity.this.minute=i1;
                showDate(year,month,day,hour,minute);
            }
        });
    }

    private void showDate(int year, int month, int day, int hour,int minute) {
        EditText show=(EditText)findViewById(R.id.show);
        show.setText("您选择的时间为："+year+"年"+(month+1)+"月"+day+"天"+hour+"时"+minute+"分");
    }
}
