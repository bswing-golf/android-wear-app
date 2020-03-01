package com.example.bswing_wear_os

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.wearable.activity.WearableActivity
import android.view.WindowManager
import kotlinx.android.synthetic.main.starting_swing.*


class StartingSwingActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.starting_swing)

        Helper.setCurrentContextInstance(this)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        this.beginCountdown()

        // Enables Always-on
        setAmbientEnabled()
    }

    private fun beginCountdown() {
        COUNTDOWN_TEXT.text = "5"
        Handler().postDelayed(
            {
                COUNTDOWN_TEXT.text = "4"
            },
            1000
        )
        Handler().postDelayed(
            {
                COUNTDOWN_TEXT.text = "3"
            },
            2000
        )
        Handler().postDelayed(
            {
                COUNTDOWN_TEXT.text = "2"
            },
            3000
        )
        Handler().postDelayed(
            {
                COUNTDOWN_TEXT.text = "1"
            },
            4000
        )
        Handler().postDelayed(
            {
                val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE))
                Helper.swingController.createNewSwing()
                val intent = Intent(this, SwingInProgressActivity::class.java)
                startActivity(intent)
            },
            5000
        )
    }
}
