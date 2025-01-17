package com.example.bswing_wear_os

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.view.View
import kotlinx.android.synthetic.main.swing_not_started.*

class SwingNotStartedActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swing_not_started)

        Helper.setCurrentContextInstance(this)

        this.checkInterruptionFilter()

        REFRESH_BUTTON.setOnClickListener {
            this.checkInterruptionFilter()
        }

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

    override fun onResume() {
        super.onResume()
        this.checkInterruptionFilter()
    }

    private fun startSwing() {
        val intent = Intent(this, StartingSwingActivity::class.java)
        startActivity(intent)
    }

    private fun goToSelectClubView() {
        val intent = Intent(this, SelectClubActivity::class.java)
        startActivity(intent)
    }

    private fun checkInterruptionFilter() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (notificationManager.currentInterruptionFilter == 2) {
            DO_NOT_DISTURB_TEXT.visibility = View.VISIBLE
            REFRESH_BUTTON.visibility = View.VISIBLE
            START_SWING_BUTTON.visibility = View.GONE
        } else {
            DO_NOT_DISTURB_TEXT.visibility = View.GONE
            REFRESH_BUTTON.visibility = View.GONE
            START_SWING_BUTTON.visibility = View.VISIBLE
        }
    }

}
