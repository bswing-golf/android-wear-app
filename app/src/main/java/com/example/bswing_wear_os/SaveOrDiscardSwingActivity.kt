package com.example.bswing_wear_os

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.save_or_discard_swing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

class SaveOrDiscardSwingActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.save_or_discard_swing)

        Helper.setCurrentContextInstance(this)

        DISCARD_SWING_BUTTON.setOnClickListener {
            this.discardSwing()
        }

        SAVE_SWING_BUTTON.setOnClickListener {
            this.saveSwing()
        }

        // Enables Always-on
        setAmbientEnabled()
    }

    fun saveSwing() {
        // Run blocking is not okay for remote persistence but is fine for local persistence
        runBlocking {
            Helper.swingController.saveSwing()
        }
        val intent = Intent(this, SwingNotStartedActivity::class.java)
        startActivity(intent)
    }

    fun discardSwing() {
        Helper.swingController.destroySwing()
        val intent = Intent(this, SwingNotStartedActivity::class.java)
        startActivity(intent)
    }
}
