package com.example.etudes.aurore;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.layout_forecast);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(800);
        animationDrawable.setExitFadeDuration(800);

        animationDrawable.start();


        TextView tvday0 = findViewById(R.id.textView);

        TextView tv0 = findViewById(R.id.textView2);
        TextView tv1 = findViewById(R.id.textView3);
        TextView tv2 = findViewById(R.id.textView4);
        TextView tv3 = findViewById(R.id.textView5);
        TextView tv4 = findViewById(R.id.textView6);
        TextView tv5 = findViewById(R.id.textView7);
        TextView tv6 = findViewById(R.id.textView8);
        TextView tv7 = findViewById(R.id.textView9);


        TextView tvday10 = findViewById(R.id.textView1);

        TextView tv10 = findViewById(R.id.textView12);
        TextView tv11 = findViewById(R.id.textView13);
        TextView tv12 = findViewById(R.id.textView14);
        TextView tv13 = findViewById(R.id.textView15);
        TextView tv14 = findViewById(R.id.textView16);
        TextView tv15 = findViewById(R.id.textView17);
        TextView tv16 = findViewById(R.id.textView18);
        TextView tv17 = findViewById(R.id.textView19);


        TextView tvday110 = findViewById(R.id.textView11);

        TextView tv110 = findViewById(R.id.textView112);
        TextView tv111 = findViewById(R.id.textView113);
        TextView tv112 = findViewById(R.id.textView114);
        TextView tv113 = findViewById(R.id.textView115);
        TextView tv114 = findViewById(R.id.textView116);
        TextView tv115 = findViewById(R.id.textView117);
        TextView tv116 = findViewById(R.id.textView118);
        TextView tv117 = findViewById(R.id.textView119);



        SimpleDateFormat formater = new SimpleDateFormat("EEEE, d MMM yyyy", new Locale("EN","en"));

        Date today  = new Date();

        //update hour of Quebec
        Date update = new Date();
        update.setHours(18);
        update.setMinutes(05);

        //day after tomorrow
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 2);
        dt = c.getTime();

        //day after after tomorrow
        Date dtt = new Date();
        Calendar cc = Calendar.getInstance();
        cc.setTime(dtt);
        cc.add(Calendar.DATE, 3);
        dtt = cc.getTime();

        if(today.after(update)){
            tvday0.setText("Tomorrow");
            tvday10.setText(formater.format(dt));
            tvday110.setText(formater.format(dtt));
        }else{
            tvday0.setText("Today");
            tvday10.setText(formater.format(today));
            tvday110.setText(formater.format(dt));
        }

        tv0.setText(ForecastValue.FORECAST[1][1]);
        tv1.setText(ForecastValue.FORECAST[1][2]);
        tv2.setText(ForecastValue.FORECAST[1][3]);
        tv3.setText(ForecastValue.FORECAST[1][4]);
        tv4.setText(ForecastValue.FORECAST[1][5]);
        tv5.setText(ForecastValue.FORECAST[1][6]);
        tv6.setText(ForecastValue.FORECAST[1][7]);
        tv7.setText(ForecastValue.FORECAST[2][0]);

        tv10.setText(ForecastValue.FORECAST[2][1]);
        tv11.setText(ForecastValue.FORECAST[2][2]);
        tv12.setText(ForecastValue.FORECAST[2][3]);
        tv13.setText(ForecastValue.FORECAST[2][4]);
        tv14.setText(ForecastValue.FORECAST[2][5]);
        tv15.setText(ForecastValue.FORECAST[2][6]);
        tv16.setText(ForecastValue.FORECAST[2][7]);
        tv17.setText(ForecastValue.FORECAST[3][0]);

        tv110.setText(ForecastValue.FORECAST[3][1]);
        tv111.setText(ForecastValue.FORECAST[3][2]);
        tv112.setText(ForecastValue.FORECAST[3][3]);
        tv113.setText(ForecastValue.FORECAST[3][4]);
        tv114.setText(ForecastValue.FORECAST[3][5]);
        tv115.setText(ForecastValue.FORECAST[3][6]);
        tv116.setText(ForecastValue.FORECAST[3][7]);
        tv117.setText(" "); //no forecast





    }
}
