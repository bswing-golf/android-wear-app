package com.example.bswing_wear_os

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

// m/s^2
class LinearAcceleration: SensorEventListener {

    private val linearAccelerationData: FloatArray = FloatArray(3)

    private val sensorManager: SensorManager = Helper.currentContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)

    fun initializeSensor() {
        this.sensorManager.registerListener(this, accelerometer , SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun deInitializeSensor() {
        this.sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        val mySensor: Sensor = sensorEvent.sensor

        when(mySensor.getType()) {
            Sensor.TYPE_LINEAR_ACCELERATION -> {
                linearAccelerationData[0] = sensorEvent.values[0]
                linearAccelerationData[1] = sensorEvent.values[1]
                linearAccelerationData[2] = sensorEvent.values[2]
            }
        }
    }

    fun getLinearAccelerationData(): FloatArray {
        return this.linearAccelerationData
    }

}