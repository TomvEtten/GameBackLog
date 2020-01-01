package hva.nl.gamelog.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hva.nl.gamelog.R
import kotlinx.android.synthetic.main.game_content.view.*

class GameAdapter(private val tasks: List<Game>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private lateinit var context: Context

    //Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.game_content,
                parent,
                false
            )
        )
    }

    //Returns the size of the list
    override fun getItemCount(): Int {
        return tasks.size
    }

    //Called by RecyclerView to display the data at the specified position.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
           itemView.tvTitle.text = game.gameTitle
           itemView.tvConsole.text = game.consoles
           itemView.tvRelease.text = context.getString(R.string.release_date, game.releaseDate.toString())
        }
    }
}
