package com.example.bswing_wear_os

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

// rad/s
class Gyroscope: SensorEventListener {

    private val gyroscopeData: FloatArray = FloatArray(3)

    private val sensorManager: SensorManager = Helper.currentContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

    fun initializeSensor() {
        this.sensorManager.registerListener(this, gyroscope , SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun deInitializeSensor() {
        this.sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        when(sensorEvent.sensor.type) {
            Sensor.TYPE_GYROSCOPE -> {
                System.arraycopy(sensorEvent.values, 0, this.gyroscopeData, 0, this.gyroscopeData.size)
            }
        }
    }

    fun getGyroscopeData(): FloatArray {
        return this.gyroscopeData
    }

}