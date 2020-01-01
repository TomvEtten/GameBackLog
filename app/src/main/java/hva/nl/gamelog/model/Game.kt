package hva.nl.gamelog.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Game(

    val gameTitle: String,
    val consoles: String,
    val releaseDate: LocalDate,
    @PrimaryKey(autoGenerate = true)
    val id: Int?
)