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

        // Enables Always-on
        setAmbientEnabled()
    }

    private fun startSwing() {
        Helper.swingController.createNewSwing()
        val intent = Intent(this, SwingInProgressActivity::class.java)
        startActivity(intent)
    }

}
