package com.example.bswing_wear_os

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

// unitless
class Rotation: SensorEventListener {

    private val rotationData: FloatArray = FloatArray(4)

    private val sensorManager: SensorManager = Helper.currentContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val rotation = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)

    fun initializeSensor() {
        this.sensorManager.registerListener(this, rotation , SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun deInitializeSensor() {
        this.sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        when(sensorEvent.sensor.type) {
            Sensor.TYPE_ROTATION_VECTOR -> {
                System.arraycopy(sensorEvent.values, 0, this.rotationData, 0, this.rotationData.size)
            }
        }
    }

    fun getRotationData(): FloatArray {
        return this.rotationData
    }

}