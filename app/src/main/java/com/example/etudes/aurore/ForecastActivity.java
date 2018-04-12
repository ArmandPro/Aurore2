package com.example.etudes.aurore;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
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

        /*ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.layout_forecast);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(800);
        animationDrawable.setExitFadeDuration(800);

        animationDrawable.start();*/

        int colorRed = ContextCompat.getColor(getApplicationContext(), R.color.Red);
        int colorRedLight = ContextCompat.getColor(getApplicationContext(), R.color.RedLight);
        int kplow = 2;
        int kpmed = 3;
        int kphi = 4;


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
        tv0.setText(" " + ForecastValue.FORECAST[0][1]);
        if(ForecastValue.FORECAST[0][1]== kpmed) {
            tv0.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[0][1]>= kphi){
            tv0.setTextColor(colorRed); }

        tv1.setText(" " + ForecastValue.FORECAST[0][2]);
        if(ForecastValue.FORECAST[0][2]== kpmed) {
            tv1.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[0][2]>= kphi){
            tv1.setTextColor(colorRed); }

        tv2.setText(" " + ForecastValue.FORECAST[0][3]);
        if(ForecastValue.FORECAST[0][3]== kpmed) {
            tv2.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[0][3]>= kphi){
            tv2.setTextColor(colorRed); }

        tv3.setText(" " + ForecastValue.FORECAST[0][4]);
        if(ForecastValue.FORECAST[0][4]== kpmed) {
            tv3.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[0][4]>= kphi){
            tv3.setTextColor(colorRed); }

        tv4.setText(" " + ForecastValue.FORECAST[0][5]);
        if(ForecastValue.FORECAST[0][5]== kpmed) {
            tv4.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[0][5]>= kphi){
            tv4.setTextColor(colorRed); }

        tv5.setText(" " + ForecastValue.FORECAST[0][6]);
        if(ForecastValue.FORECAST[0][6]== kpmed) {
            tv5.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[0][6]>= kphi){
            tv5.setTextColor(colorRed); }

        tv6.setText(" " + ForecastValue.FORECAST[0][7]);
        if(ForecastValue.FORECAST[0][7]== kpmed) {
            tv6.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[0][7]>= kphi){
            tv6.setTextColor(colorRed); }

        tv7.setText(" " + ForecastValue.FORECAST[1][0]);
        if(ForecastValue.FORECAST[1][0]== kpmed) {
            tv7.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[1][0]>= kphi){
            tv7.setTextColor(colorRed); }






        tv10.setText(" " + ForecastValue.FORECAST[1][1]);
        if(ForecastValue.FORECAST[1][1]== kpmed) {
            tv10.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[1][1]>= kphi){
            tv10.setTextColor(colorRed); }

        tv11.setText(" " + ForecastValue.FORECAST[1][2]);
        if(ForecastValue.FORECAST[1][2]== kpmed) {
            tv11.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[1][2]>= kphi){
            tv11.setTextColor(colorRed); }

        tv12.setText(" " + ForecastValue.FORECAST[1][3]);
        if(ForecastValue.FORECAST[1][3]== kpmed) {
            tv12.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[1][3]>= kphi){
            tv12.setTextColor(colorRed); }

        tv13.setText(" " + ForecastValue.FORECAST[1][4]);
        if(ForecastValue.FORECAST[1][4]== kpmed) {
            tv13.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[1][4]>= kphi){
            tv13.setTextColor(colorRed); }

        tv14.setText(" " + ForecastValue.FORECAST[1][5]);
        if(ForecastValue.FORECAST[1][5]== kpmed) {
            tv14.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[1][5]>= kphi){
            tv14.setTextColor(colorRed); }

        tv15.setText(" " + ForecastValue.FORECAST[1][6]);
        if(ForecastValue.FORECAST[1][0]== kpmed) {
            tv15.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[1][0]>= kphi){
            tv15.setTextColor(colorRed); }

        tv16.setText(" " + ForecastValue.FORECAST[1][7]);
        if(ForecastValue.FORECAST[1][7]== kpmed) {
            tv16.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[1][7]>= kphi){
            tv7.setTextColor(colorRed); }

        tv17.setText(" " + ForecastValue.FORECAST[2][0]);
        if(ForecastValue.FORECAST[2][0]== kpmed) {
            tv17.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[2][0]>= kphi){
            tv17.setTextColor(colorRed); }







        tv110.setText(" " + ForecastValue.FORECAST[2][1]);
        if(ForecastValue.FORECAST[2][1]== kpmed) {
            tv110.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[2][1]>= kphi){
            tv110.setTextColor(colorRed); }

        tv111.setText(" " + ForecastValue.FORECAST[2][2]);
        if(ForecastValue.FORECAST[2][2]== kpmed) {
            tv111.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[2][2]>= kphi){
            tv111.setTextColor(colorRed); }

        tv112.setText(" " + ForecastValue.FORECAST[2][3]);
        if(ForecastValue.FORECAST[2][3]== kpmed) {
            tv112.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[2][3]>= kphi){
            tv112.setTextColor(colorRed); }

        tv113.setText(" " + ForecastValue.FORECAST[2][4]);
        if(ForecastValue.FORECAST[2][4]== kpmed) {
            tv113.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[2][4]>= kphi){
            tv113.setTextColor(colorRed); }

        tv114.setText(" " + ForecastValue.FORECAST[2][5]);
        if(ForecastValue.FORECAST[2][5]== kpmed) {
            tv114.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[2][5]>= kphi){
            tv114.setTextColor(colorRed); }

        tv115.setText(" " + ForecastValue.FORECAST[2][6]);
        if(ForecastValue.FORECAST[2][6]== kpmed) {
            tv115.setTextColor(colorRedLight);
        }else if(ForecastValue.FORECAST[2][6]>= kphi){
            tv115.setTextColor(colorRed); }

        tv116.setText(" " + ForecastValue.FORECAST[2][7]);
        tv117.setText(" "); //no forecast





    }
}
