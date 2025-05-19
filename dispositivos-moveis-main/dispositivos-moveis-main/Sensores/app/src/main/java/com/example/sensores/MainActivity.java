package com.example.sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager mSensorManager;
    Sensor sensor;
    TextView lbl1,lbl2,lbl3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lbl1 = findViewById(R.id.lbla);
        lbl2 = findViewById(R.id.lbla2);
        lbl3 = findViewById(R.id.lbla3);

        mSensorManager =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        mSensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    public void onSensorChanged(SensorEvent event) {

        lbl1.setText("X: "+String.valueOf(event.values[0]));
        lbl2.setText("Y: "+String.valueOf(event.values[1]));
        lbl3.setText("Z: "+String.valueOf(event.values[2]));
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}