package com.example.bswing_wear_os

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class Magnetometer: SensorEventListener {

    private val magnetometerData: FloatArray = FloatArray(3)

    private val sensorManager: SensorManager = Helper.currentContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

    fun initializeSensor() {
        this.sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun deInitializeSensor() {
        this.sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        when(sensorEvent.sensor.type) {
            Sensor.TYPE_MAGNETIC_FIELD -> {
                System.arraycopy(sensorEvent.values, 0, this.magnetometerData, 0, this.magnetometerData.size)
            }
        }
    }

    fun getMagnetometerData(): FloatArray {
        return this.magnetometerData
    }

}