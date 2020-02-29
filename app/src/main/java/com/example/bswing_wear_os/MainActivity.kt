package com.example.bswing_wear_os

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Helper.setCurrentContextInstance(this)

        // Where should db be instantiated?
        val db: AppDatabase = AppDatabase.getInstance(this)
        Helper.setDatabaseInstance(db)
        Helper.swingController.globalClubInstance.selectClub(ClubNames.MID_IRON)

        val intent = Intent(this, SwingNotStartedActivity::class.java)
        startActivity(intent)

        // Enables Always-on
        setAmbientEnabled()
    }
}
