package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Livro::class], version = 1, exportSchema = false)
abstract class LivroDataBase: RoomDatabase() {

    abstract fun livroDao(): LivroDao

    companion object{


        @Volatile
        private var INSTANCE: LivroDataBase? = null

        fun getDatabase(context: Context): LivroDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){

                val instance = Room.databaseBuilder(context.applicationContext,
                    LivroDataBase::class.java,
                    "livro_table").build()


                INSTANCE = instance
                return instance

            }


            }



    }





}