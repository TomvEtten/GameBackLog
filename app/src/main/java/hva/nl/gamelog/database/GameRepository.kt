package hva.nl.gamelog.database

import android.content.Context
import androidx.lifecycle.LiveData
import hva.nl.gamelog.model.Game

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.noteDao()
    }

    fun getGames(): LiveData<List<Game?>?> {
        return gameDao.getGames()
    }

    suspend fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }


    suspend fun deleteGame(game: Game) {
        gameDao.delete(game)
    }

    suspend fun deleteAllGames() {
        gameDao.deleteGames()
    }

}
