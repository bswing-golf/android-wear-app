package com.example.bswing_wear_os

import android.content.Context

object Helper {

    lateinit var dbInstance: AppDatabase
    lateinit var currentContext: Context
    val swingController: SwingController = SwingController()

    fun setDatabaseInstance(db: AppDatabase) {
        this.dbInstance = db
    }

    fun setCurrentContextInstance(context: Context) {
        this.currentContext = context
    }

}