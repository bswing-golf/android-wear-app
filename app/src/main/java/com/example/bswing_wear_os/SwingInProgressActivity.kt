package com.example.bswing_wear_os

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.swing_in_progress.*

class SwingInProgressActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swing_in_progress)

        Helper.setCurrentContextInstance(this)

        END_SWING_BUTTON.setOnClickListener {
            this.endSwing()
        }

        // Enables Always-on
        setAmbientEnabled()
    }

    fun endSwing() {
        Helper.swingController.endSwing()
        val intent = Intent(this, SaveOrDiscardSwingActivity::class.java)
        startActivity(intent)
    }
}
