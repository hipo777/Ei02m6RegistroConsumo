package org.demre.ei02m6registroconsumo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Contiene la base de datos y sirve como punto de acceso a los datos persistentes de la app
@Database (entities = [Item::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun getItemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}