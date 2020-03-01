package com.example.bswing_wear_os

import android.hardware.SensorManager

class SwingDataController {

    private val linearAcceleration: LinearAcceleration = LinearAcceleration()
    private val accelerometer: Accelerometer = Accelerometer()
    private val gyroscope: Gyroscope = Gyroscope()
    private val rotation: Rotation = Rotation()
    private val magnetometer: Magnetometer = Magnetometer()

    private fun getLinearAccelerationData(): FloatArray {
        return this.linearAcceleration.getLinearAccelerationData()
    }

    private fun getGyroscopeData(): FloatArray {
        return this.gyroscope.getGyroscopeData()
    }

    private fun getRotationData(): FloatArray {
        return this.rotation.getRotationData()
    }

    private fun getMagnetometerData(): FloatArray {
        return this.magnetometer.getMagnetometerData()
    }

    private fun getAccelerometerData(): FloatArray {
        return this.accelerometer.getAccelerometerData()
    }

    private fun getOrientationData(accelerometerData: FloatArray, magnetometerData: FloatArray): FloatArray {
        val rotationMatrix = FloatArray(9)
        SensorManager.getRotationMatrix(rotationMatrix, null, accelerometerData, magnetometerData)

        val orientationAngles = FloatArray(3)
        SensorManager.getOrientation(rotationMatrix, orientationAngles)

        return orientationAngles
    }

    fun initializeSensors() {
        this.linearAcceleration.initializeSensor()
        this.accelerometer.initializeSensor()
        this.gyroscope.initializeSensor()
        this.rotation.initializeSensor()
        this.magnetometer.initializeSensor()
    }

    fun deInitializeSensors() {
        this.linearAcceleration.deInitializeSensor()
        this.accelerometer.deInitializeSensor()
        this.gyroscope.deInitializeSensor()
        this.rotation.deInitializeSensor()
        this.magnetometer.deInitializeSensor()
    }

    fun getCurrentSensorData(): Array<FloatArray> {
        val linearAccelerationData: FloatArray = this.getLinearAccelerationData()
        val accelerometerData: FloatArray = this.getAccelerometerData()
        val gyroscopeData: FloatArray = this.getGyroscopeData()
        val rotationData: FloatArray = this.getRotationData()
        val magnetometerData: FloatArray = this.getMagnetometerData()
        val orientationData: FloatArray = this.getOrientationData(accelerometerData, magnetometerData)

        return arrayOf(linearAccelerationData, accelerometerData, gyroscopeData, rotationData, magnetometerData, orientationData)
    }

}