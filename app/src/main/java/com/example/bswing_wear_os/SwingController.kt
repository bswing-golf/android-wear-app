package com.example.bswing_wear_os

class SwingController {

    val globalClubInstance: Club = Club()
    var globalSwingInstance: Swing? = null

    fun createNewSwing() {
        if (this.globalSwingInstance == null) { this.globalSwingInstance = Swing() }

        try {
            var currentSwing = this.globalSwingInstance

            if(currentSwing == null) { throw Exception("Swing instance is null") }
            else {
                println("Starting Swing...")
                currentSwing.startSwing()
                currentSwing.start()
            }
        } catch(e: Exception) {
            println(e)
        }
    }

    fun endSwing() {
        try {
            var currentSwing = this.globalSwingInstance

            if(currentSwing == null) { throw Exception("Swing instance is null") }
            else {
                println("Ending Swing...")
                currentSwing.endSwing()
            }
        } catch(e: Exception) {
            println(e)
        }
    }

    suspend fun saveSwing() {
        println("Saving Swing...")
        val swingData = this.globalSwingInstance?.getSwingData()
        // Convert selected club enum value to integer as index of enum and save for db index
        RepositorySwing(Helper.dbInstance.roomDaoSwing()).updateLocalSwing(0, RoomConverters().fromArrayList(swingData))
        this.destroySwing()
    }

    fun destroySwing() {
        println("Destroying Swing...")
        this.globalSwingInstance = null
    }
}