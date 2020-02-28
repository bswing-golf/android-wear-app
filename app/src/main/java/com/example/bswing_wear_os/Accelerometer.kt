package com.example.bswing_wear_os

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

// m/s^2
class Accelerometer: SensorEventListener {

    private var x: Double = 0.00
    private var y: Double = 0.00
    private var z: Double = 0.00

    private val sensorManager: SensorManager = Helper.currentContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

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
            Sensor.TYPE_ACCELEROMETER -> {
                this.x = sensorEvent.values[0].toDouble()
                this.y = sensorEvent.values[1].toDouble()
                this.z = sensorEvent.values[2].toDouble()
            }
        }
    }

    fun getAccelerometerData(): Array<Double> {
        return arrayOf(this.x, this.y, this.z)
    }

}