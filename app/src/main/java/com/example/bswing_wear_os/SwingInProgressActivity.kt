package com.example.bswing_wear_os

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.swing_in_progress.*
import kotlinx.android.synthetic.main.swing_in_progress.SELECTED_CLUB

class SwingInProgressActivity : WearableActivity() {

    var doesSwingNeedToEnd: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.swing_in_progress)

        Helper.setCurrentContextInstance(this)

        END_SWING_BUTTON.setOnClickListener {
            this.endSwing()
        }

        this.doesSwingNeedToEnd = true
        this.endSwingIfTooLong()

        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE))

        SELECTED_CLUB.text = Helper.swingController.globalClubInstance.getSelectedClubName()

        // Enables Always-on
        setAmbientEnabled()
    }

    fun endSwing() {
        this.doesSwingNeedToEnd = false
        Helper.swingController.endSwing()
        val intent = Intent(this, SaveOrDiscardSwingActivity::class.java)
        startActivity(intent)
    }

    private fun endSwingIfTooLong() {
        Handler().postDelayed(
            {
                if(this.doesSwingNeedToEnd){ this.endSwing() }
            },
            12000
        )
    }
}
