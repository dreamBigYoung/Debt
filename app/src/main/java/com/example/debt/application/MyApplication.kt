package com.example.debt.application

import android.app.Application
import com.example.debt.entity.DaoMaster
import com.example.debt.entity.DaoSession
import org.greenrobot.greendao.database.Database

class MyApplication: Application() {

    private lateinit var daoSession: DaoSession

    override fun onCreate() {
        super.onCreate()

        // regular SQLite database
        val helper = DaoMaster.DevOpenHelper(this, "notes-db")
        val db: Database = helper.getWritableDb()


        // encrypted SQLCipher database
        // note: you need to add SQLCipher to your dependencies, check the build.gradle file
        // DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db-encrypted");
        // Database db = helper.getEncryptedWritableDb("encryption-key");
        daoSession = DaoMaster(db).newSession()

    }

    fun getDaoSession(): DaoSession {
        return daoSession
    }
}