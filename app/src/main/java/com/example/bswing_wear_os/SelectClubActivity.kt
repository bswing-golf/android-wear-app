package com.example.bswing_wear_os

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.wear.widget.WearableLinearLayoutManager
import androidx.wear.widget.WearableRecyclerView
import kotlinx.android.synthetic.main.select_club.*

class SelectClubActivity : WearableActivity() {

    private lateinit var linearLayoutManager: WearableLinearLayoutManager
    private lateinit var adapter: SelectClubAdapter
    private val clubList: Array<String> = Helper.clubList.clubList.values.toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_club)

        Helper.setCurrentContextInstance(this)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        this.linearLayoutManager = WearableLinearLayoutManager(this)
        this.adapter = SelectClubAdapter(this.clubList)

        RECYCLER_LAUNCHER_VIEW.layoutManager = linearLayoutManager
        RECYCLER_LAUNCHER_VIEW.adapter = adapter
        RECYCLER_LAUNCHER_VIEW.apply {
            isEdgeItemsCenteringEnabled = true
        }

        // Enables Always-on
        setAmbientEnabled()
    }
}
