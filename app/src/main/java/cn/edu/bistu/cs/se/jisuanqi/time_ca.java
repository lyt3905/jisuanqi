package cn.edu.bistu.cs.se.jisuanqi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

import cn.edu.bistu.cs.se.jisuanqi.R;

public class time_ca extends AppCompatActivity {
    LocalDate start;
    LocalDate now;
    private TextView first_t;
    private TextView second_t;
    private TextView third_t;
    private Button first_b;
    private Button second_b;
    private Button third_b;
    Calendar calendar= Calendar.getInstance(Locale.CHINA);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_ca);

        first_b=findViewById(R.id.first_button);
        second_b=findViewById(R.id.second_button);
        third_b=findViewById(R.id.jisuanriqi_button);

        first_t=findViewById(R.id.first_text);
        second_t=findViewById(R.id.second_text);
        third_t=findViewById(R.id.jisuanriqi_text);

        first_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(time_ca.this, 2, new DatePickerDialog.OnDateSetListener() {
                    // 绑定监听器(How the parent is notified that the date is set.)
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // 此处得到选择的时间，可以进行你想要的操作
                        start= LocalDate.of(year, monthOfYear + 1, dayOfMonth);
                        first_t.setText("您选择了：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
                    }
                } , calendar.get(Calendar.YEAR)
                        , calendar.get(Calendar.MONTH)
                            , calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        second_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(time_ca.this, 2, new DatePickerDialog.OnDateSetListener() {
                    // 绑定监听器(How the parent is notified that the date is set.)
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // 此处得到选择的时间，可以进行你想要的操作
                        now= LocalDate.of(year, monthOfYear + 1, dayOfMonth);
                        second_t.setText("您选择了：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
                    }
                } , calendar.get(Calendar.YEAR)
                        , calendar.get(Calendar.MONTH)
                        , calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        third_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long i=now.toEpochDay() - start.toEpochDay();
                third_t.setText(i+"天");
            }
        });



    }
}
