package com.example.bswing_wear_os

class Swing : Thread() {

    private var run = false
    private var swingData: ArrayList<Array<Array<Double>>> = ArrayList()
    private val swingDataController: SwingDataController = SwingDataController()
    private lateinit var roomSwingData: ArrayList<Array<Array<Double>>>

    fun setupSwing() {
        if(Helper.swingController.globalClubInstance.hasSwingData) {
            this.roomSwingData = RoomConverters().fromString(Helper.swingController.globalClubInstance.clubData.swingData)
        }
    }

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

    fun getSwingData(): ArrayList<Array<Array<Double>>> {
        return this.swingData
    }

}

