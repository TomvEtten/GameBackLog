package hva.nl.gamelog.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import hva.nl.gamelog.database.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val gameRepository = GameRepository(application.applicationContext)

    val games = gameRepository.getGames()

    fun deleteAllGames() {
        CoroutineScope(Dispatchers.IO).launch {
            gameRepository.deleteAllGames()
        }
    }

}