package hva.nl.gamelog.database

import androidx.lifecycle.LiveData
import androidx.room.*
import hva.nl.gamelog.model.Game

@Dao
interface GameDao {

    @Insert
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM Game ORDER BY releaseDate ASC")
    fun getGames(): LiveData<List<Game?>?>

    @Delete
    suspend fun delete(game: Game)

    @Query("DELETE FROM Game")
    suspend fun deleteGames()

}
