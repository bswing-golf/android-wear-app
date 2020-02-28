package com.example.bswing_wear_os

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.swing_not_started.*

class SwingNotStartedActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swing_not_started)

        Helper.setCurrentContextInstance(this)

        START_SWING_BUTTON.setOnClickListener {
            this.startSwing()
        }

        SELECTED_CLUB.setOnClickListener {
            this.goToSelectClubView()
        }

        SELECTED_CLUB.text = Helper.swingController.globalClubInstance.getSelectedClubName()

        // Enables Always-on
        setAmbientEnabled()
    }

    private fun startSwing() {
        val intent = Intent(this, StartingSwingActivity::class.java)
        startActivity(intent)
    }

    private fun goToSelectClubView() {
        val intent = Intent(this, SelectClubActivity::class.java)
        startActivity(intent)
    }

}
