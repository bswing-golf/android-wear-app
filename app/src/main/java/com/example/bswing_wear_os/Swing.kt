package com.example.bswing_wear_os

import android.content.Intent
import java.time.LocalTime

class Swing : Thread() {

    private var run = false
    private var swingData: ArrayList<Array<FloatArray>> = ArrayList()
    private val swingDataController: SwingDataController = SwingDataController()
    private lateinit var roomSwingData: ArrayList<Array<FloatArray>>

    fun setupSwing() {
        @Suppress("SENSELESS_COMPARISON")
        if(Helper.swingController.globalClubInstance.clubData != null) {
            val localClubData = Helper.swingController.globalClubInstance.clubData
            this.roomSwingData = Helper.roomConvertersInstance.fromString(localClubData!!.swingData)
        }
    }

    fun startSwing() {
        this.setRunning(true)
    }

    fun endSwing() {
        this.setRunning(false)
        Helper.swingController.currentSwingDataInMemory = this.swingData
        this.swingDataController.deInitializeSensors()
    }

    private fun setRunning(run: Boolean) {
        this.run = run
    }

    override fun run() {
        this.swingDataController.initializeSensors()
        while(run) {
            // Generate swing data 200 times per second
            sleep(5)
            this.generateSwingData()
        }
    }

    private fun generateSwingData() {
        this.swingData.add(this.swingDataController.getCurrentSensorData())
    }

    fun getSwingData(): ArrayList<Array<FloatArray>> {
        return this.swingData
    }

}

