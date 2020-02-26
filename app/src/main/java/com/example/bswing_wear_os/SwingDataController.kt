package com.example.bswing_wear_os

class SwingDataController {

    private val accelerometer: Accelerometer = Accelerometer()
    private val gyroscope: Gyroscope = Gyroscope()
    private val rotation: Rotation = Rotation()

    private fun getAccelerometerData(): Array<Double> {
        return this.accelerometer.getAccelerometerData()
    }

    private fun getGyroscopeData(): Array<Double> {
        return this.gyroscope.getGyroscopeData()
    }

    private fun getRotationData(): Array<Double> {
        return this.rotation.getRotationData()
    }

    fun initializeSensors() {
        this.accelerometer.initializeSensor()
        this.gyroscope.initializeSensor()
        this.rotation.initializeSensor()
    }

    fun deInitializeSensors() {
        this.accelerometer.deInitializeSensor()
        this.gyroscope.deInitializeSensor()
        this.rotation.deInitializeSensor()
    }

    fun getCurrentSensorData(): Array<Array<Double>> {
        return arrayOf(this.getAccelerometerData(), this.getGyroscopeData(), this.getRotationData())
    }
}