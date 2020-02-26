package com.example.bswing_wear_os

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class SelectClubActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_club)

        Helper.setCurrentContextInstance(this)

        // Enables Always-on
        setAmbientEnabled()
    }
}
