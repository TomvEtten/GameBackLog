package hva.nl.gamelog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hva.nl.gamelog.model.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class GameRoomDatabase : RoomDatabase() {

    abstract fun noteDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var INSTANCE: GameRoomDatabase? = null

        fun getDatabase(context: Context): GameRoomDatabase? {
            if (INSTANCE != null) {
                return INSTANCE
            }
            synchronized(GameRoomDatabase::class.java) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    GameRoomDatabase::class.java, DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }
    }

}
