package com.example.etudes.aurore;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class Forecast extends AsyncTask<URL, Integer, List<String>> {



    private List<String> inputList = new ArrayList<>();

    public boolean upDateForecast(){

        URL url = null;
        try {
            url = new URL("https://services.swpc.noaa.gov/text/3-day-geomag-forecast.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        new Forecast().execute(url);

        System.out.println("size:    "+inputList.size());
        for(String element : inputList){
            System.out.println(element);
        }


        return true;
    }



    public void print(){
        for( int i = 0; i<3; i++)
        {
            for( int j = 0; j<8; j++)
            {
                System.out.print(ForecastValue.FORECAST[i][j]+"kp");
            }
            System.out.println();
        }
    }




    @Override
    protected List<String> doInBackground(URL... urls) {
        int count = urls.length;
        long totalSize = 0;
        for (int i = 0; i < count; i++) {

            URL oracle = urls[0];

            BufferedReader in = null;
            try {
                in = new BufferedReader(
                        new InputStreamReader(oracle.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String tempInput;
            // int j = 0;
            try {

                while ((tempInput = in.readLine()) != null){
                    inputList.add(tempInput);
                    //System.out.println(inputList.get(j)+"coucou"+j);
                    //j++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return inputList;
    }



    @Override
    protected void onPostExecute(List<String> input){

        System.out.println("COUCOU FROM   onPostExecute");
        System.out.println("size:    "+inputList.size());
        int i = 0;
        for(String element : inputList){
            System.out.println(element+" line: "+i);
            i++;
        }

        int j=17;
        while(j<25){

            for(int k=1; k<4; k++){
                String[] parts = inputList.get(j).split("       ");
                ForecastValue.FORECAST[k-1][j-17] = Integer.parseInt(parts[k].replaceAll("\\s+",""));
            }

            j++;
        }

        print();

    }







}
