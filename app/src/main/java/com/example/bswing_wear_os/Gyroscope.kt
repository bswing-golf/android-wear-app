package com.example.bswing_wear_os

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class Gyroscope: SensorEventListener {

    private var x: Double = 0.00
    private var y: Double = 0.00
    private var z: Double = 0.00

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
        val mySensor: Sensor = sensorEvent.sensor

        when(mySensor.getType()) {
            Sensor.TYPE_GYROSCOPE -> {
                this.x = sensorEvent.values[0].toDouble()
                this.y = sensorEvent.values[1].toDouble()
                this.z = sensorEvent.values[2].toDouble()
            }
        }
    }

    fun getGyroscopeData(): Array<Double> {
        return arrayOf(this.x, this.y, this.z)
    }

}