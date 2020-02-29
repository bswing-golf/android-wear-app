package com.example.bswing_wear_os

class SwingDataController {

    private val linearAcceleration: LinearAcceleration = LinearAcceleration()
    private val gyroscope: Gyroscope = Gyroscope()
    private val rotation: Rotation = Rotation()

    private fun getLinearAccelerationData(): Array<Double> {
        return this.linearAcceleration.getLinearAccelerationData()
    }

    private fun getGyroscopeData(): Array<Double> {
        return this.gyroscope.getGyroscopeData()
    }

    private fun getRotationData(): Array<Double> {
        return this.rotation.getRotationData()
    }

    fun initializeSensors() {
        this.linearAcceleration.initializeSensor()
        this.gyroscope.initializeSensor()
        this.rotation.initializeSensor()
    }

    fun deInitializeSensors() {
        this.linearAcceleration.deInitializeSensor()
        this.gyroscope.deInitializeSensor()
        this.rotation.deInitializeSensor()
    }

    fun getCurrentSensorData(): Array<Array<Double>> {
        return arrayOf(this.getLinearAccelerationData(), this.getGyroscopeData(), this.getRotationData())
    }

}