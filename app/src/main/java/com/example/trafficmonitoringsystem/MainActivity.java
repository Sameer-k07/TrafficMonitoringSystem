package com.example.trafficmonitoringsystem;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    InputStream inputStream1, inputStream2, inputStream3, inputStream4;
    String[] ids1, ids2, ids3, ids4;
    TextView t1, t2, t3, t4;
    CountDownTimer timer1, timer2, timer3, timer4;
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.textTV1);
        t2 = (TextView) findViewById(R.id.textTV2);
        t3 = (TextView) findViewById(R.id.textTV3);
        t4 = (TextView) findViewById(R.id.textTV4);

        inputStream1 = getResources().openRawResource(R.raw.test1);
        inputStream2 = getResources().openRawResource(R.raw.test2);
        inputStream3 = getResources().openRawResource(R.raw.test3);
        inputStream4 = getResources().openRawResource(R.raw.test4);

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream1));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(inputStream3));
        BufferedReader reader4 = new BufferedReader(new InputStreamReader(inputStream4));
        int te1 = 0, te2 = 0, te3 = 0, te4 = 0;
        try {
            String csvLine1;
            while ((csvLine1 = reader1.readLine()) != null) {
                ids1 = csvLine1.split(",");

                try {
                    te1 = Integer.parseInt(ids1[0]);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Unknown 1", Toast.LENGTH_LONG).show();
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        }


        try {
            String csvLine2;
            while ((csvLine2 = reader2.readLine()) != null) {
                ids2 = csvLine2.split(",");

                try {
                    te2 = Integer.parseInt(ids2[0]);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Unknown 2", Toast.LENGTH_LONG).show();
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        }


        try {
            String csvLine3;
            while ((csvLine3 = reader3.readLine()) != null) {
                ids3 = csvLine3.split(",");

                try {
                    te3 = Integer.parseInt(ids3[0]);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Unknown 3", Toast.LENGTH_LONG).show();
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        }


        try {
            String csvLine4;
            while ((csvLine4 = reader4.readLine()) != null) {
                ids4 = csvLine4.split(",");

                try {
                    te4 = Integer.parseInt(ids4[0]);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Unknown 4", Toast.LENGTH_LONG).show();
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        }
        /*t1.append(Integer.toString(te1));
        t2.append(Integer.toString(te2));
        t3.append(Integer.toString(te3));
        t4.append(Integer.toString(te4));*/

        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, temp;
        c1 = te1;
        c2 = te1 + te2;
        c3 = te1 + te2 + te3;
        c4 = te1 + te2 + te3 + te4;

        timer1 = new CountDownTimer(c1 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                t1.setText(Long.toString(l / 1000));
            }

            @Override
            public void onFinish() {
                t1.setBackgroundResource(R.drawable.red);
                t2.setBackgroundResource(R.drawable.back);
            }
        }.start();

        timer2 = new CountDownTimer(c2 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                t2.setText(Long.toString(l / 1000));
            }

            @Override
            public void onFinish() {
                t2.setBackgroundResource(R.drawable.red);
                t3.setBackgroundResource(R.drawable.back);
            }
        }.start();

        timer3 = new CountDownTimer(c3 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                t3.setText(Long.toString(l / 1000));
            }

            @Override
            public void onFinish() {
                t3.setBackgroundResource(R.drawable.red);
                t4.setBackgroundResource(R.drawable.back);
            }
        }.start();

        timer4 = new CountDownTimer(c4 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                t4.setText(Long.toString(l / 1000));
            }

            @Override
            public void onFinish() {
                t4.setBackgroundResource(R.drawable.red);
                t1.setBackgroundResource(R.drawable.back);
            }
        }.start();

    }
}
