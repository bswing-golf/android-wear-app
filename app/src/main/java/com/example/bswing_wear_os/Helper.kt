package com.example.bswing_wear_os

import android.content.Context

object Helper {

    lateinit var dbInstance: AppDatabase
    lateinit var currentContext: Context
    lateinit var swingRepo: RepositorySwing
    val swingController: SwingController = SwingController()
    val clubList: ClubList = ClubList()
    val roomConvertersInstance: RoomConverters = RoomConverters()

    fun setDatabaseInstance(db: AppDatabase) {
        this.dbInstance = db
        this.setRepositoryInstance(RepositorySwing(db.roomDaoSwing()))
    }

    fun setCurrentContextInstance(context: Context) {
        this.currentContext = context
    }

    fun setRepositoryInstance(repo: RepositorySwing) {
        this.swingRepo = repo
    }

}