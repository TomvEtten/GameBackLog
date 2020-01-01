package hva.nl.gamelog.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import hva.nl.gamelog.R
import hva.nl.gamelog.model.Game
import kotlinx.android.synthetic.main.activity_add_game.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class AddGameActivity : AppCompatActivity() {
    private lateinit var gameViewModel: AddGameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)
        initViews()
        initViewModel()
    }

    private fun initViewModel() {
        gameViewModel = ViewModelProviders.of(this).get(AddGameViewModel::class.java)
    }

    private fun initViews() {
        fabSave.setOnClickListener {
            saveItem()
        }
    }

    private fun saveItem() {
        val success = validateItem()
        if (!success) {
            return
        }
        val toSave =
            Game(
                etGameTitle.text.toString(),
                etGameConsoles.text.toString(),
                LocalDate.parse( etYear.text.toString() + "-" + etMonth.text.toString() + "-" + etDay.text.toString(), DateTimeFormatter.ISO_DATE),
                null
            )
        gameViewModel.insertGame(toSave)
        finish()
    }


    private fun validateItem(): Boolean {
        if (etGameTitle.text.toString() == "") {
            Toast.makeText(this, getString(R.string.title_empty), Toast.LENGTH_LONG).show()
            return false
        }
        if (etGameConsoles.text.toString() == "") {
            Toast.makeText(this, getString(R.string.empty_console), Toast.LENGTH_LONG).show()
            return false
        }
        try {
            LocalDate.parse(
                etYear.text.toString() + "-" + etMonth.text.toString() + "-" + etDay.text.toString(),
                DateTimeFormatter.ISO_DATE
            )
        }catch(e: DateTimeParseException) {
            Toast.makeText(this, getString(R.string.dateinvalid), Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }

}
