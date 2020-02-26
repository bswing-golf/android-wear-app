package com.example.bswing_wear_os

import android.content.Context
import android.os.Vibrator
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking


class Swing : Thread() {

    private var run = false
    private var swingData: ArrayList<Array<Array<Double>>> = ArrayList()
    private val vibration: Vibrator = Helper.currentContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    private val swingDataController: SwingDataController = SwingDataController()

    fun startSwing() {
        this.setRunning(true)
    }

    fun endSwing() {
        this.setRunning(false)
        this.swingDataController.deInitializeSensors()
    }

    private fun setRunning(run: Boolean) {
        this.run = run
    }

    override fun run() {
        // Wait 3 seconds before starting swing - add countdown for UX
        println("Starting in 3...")
        sleep(1000)
        println("2...")
        sleep(1000)
        println("1...")
        sleep(1000)
        this.swingDataController.initializeSensors()
        vibration.vibrate(1000)
        while(run) {
            // Generate swing data 5 times per second
            sleep(200)
            this.generateSwingData()
        }
    }

    private fun generateSwingData() {
        this.swingData.add(this.swingDataController.getCurrentSensorData())
    }

    fun getSwingData(): ArrayList<Array<Array<Double>>> {
        return this.swingData
    }

}

