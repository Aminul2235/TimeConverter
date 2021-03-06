package listviewjson.learn2crack.com.time;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static listviewjson.learn2crack.com.time.TimeZoneList.showTime;
import static listviewjson.learn2crack.com.time.TimeZoneList.zoneName;

public class TimeConverter extends AppCompatActivity {

    public  TextView cityName,timeShown,currentTime;
    ArrayList arrayList = new ArrayList<GetZones>();
    Button timeZoneButton;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_converter);
        cityName = findViewById(R.id.cityName);
        timeZoneButton=findViewById(R.id.timeZoneButton);
        timeShown=findViewById(R.id.timeShown);
        currentTime=findViewById(R.id.textView19);

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                DateFormat formatter = new SimpleDateFormat("hh:mm aa");
                                Date calendar = Calendar.getInstance().getTime();
                                currentTime.setText(formatter.format(calendar.getTime()).toString());
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();

        timeZoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeConverter.this,TimeZoneList.class);
                startActivity(intent);
                finish();
            }
        });
        cityName.setText(zoneName);
        timeShown.setText(showTime);
    }
}


