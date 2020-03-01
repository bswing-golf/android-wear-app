package com.example.bswing_wear_os

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

// m/s^2
class Accelerometer: SensorEventListener {

    private val accelerometerData: FloatArray = FloatArray(3)

    private val sensorManager: SensorManager = Helper.currentContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    fun initializeSensor() {
        this.sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun deInitializeSensor() {
        this.sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        when(sensorEvent.sensor.type) {
            Sensor.TYPE_ACCELEROMETER -> {
                System.arraycopy(sensorEvent.values, 0, this.accelerometerData, 0, this.accelerometerData.size)
            }
        }
    }

    fun getAccelerometerData(): FloatArray {
        return this.accelerometerData
    }

}