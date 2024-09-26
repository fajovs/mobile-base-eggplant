package com.ensias.mobilemangrove.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ensias.mobile_basedeggplantcarediseasediagnosis.data.ImageResult
import com.ensias.mobile_basedeggplantcarediseasediagnosis.data.ImageResultDao

import kotlinx.coroutines.CoroutineScope

@Database(entities = [ImageResult::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imageResultDao(): ImageResultDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )

                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
