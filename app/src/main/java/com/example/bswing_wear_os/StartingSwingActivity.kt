package com.example.bswing_wear_os

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.starting_swing.*

class StartingSwingActivity : WearableActivity() {

    private val vibration: Vibrator = Helper.currentContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.starting_swing)

        Helper.setCurrentContextInstance(this)

        this.beginCountdown()

        // Enables Always-on
        setAmbientEnabled()
    }

    private fun beginCountdown() {
        COUNTDOWN_TEXT.text = "3"
        Handler().postDelayed(
            {
                COUNTDOWN_TEXT.text = "2"
            },
            1000
        )
        Handler().postDelayed(
            {
                COUNTDOWN_TEXT.text = "1"
            },
            2000
        )
        Handler().postDelayed(
            {
                Helper.swingController.createNewSwing()
                vibration.vibrate(VibrationEffect.createOneShot(500, 1))
                val intent = Intent(this, SwingInProgressActivity::class.java)
                startActivity(intent)
            },
            3000
        )
    }
}
