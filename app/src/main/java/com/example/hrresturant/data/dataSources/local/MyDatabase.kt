package com.example.hrresturant.data.dataSources.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bumptech.glide.load.model.DataUrlLoader.DataDecoder

@Database(entities = [Meal::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun dao():Dao

//        companion object {
//        @Volatile
//        var databaseInstance: MyDatabase? = null
//
//        fun getDatabaseInstance(context: Context): MyDatabase {
//            return databaseInstance ?: synchronized(this) {
//                databaseInstance = Room.databaseBuilder(
//                    context.applicationContext,
//                    MyDatabase::class.java,
//                    "my_database"
//                ).fallbackToDestructiveMigration().build()
//                return databaseInstance!!
//            }
//        }
//
//    }
}