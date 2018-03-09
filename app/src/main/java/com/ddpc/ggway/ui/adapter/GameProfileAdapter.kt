package com.ddpc.ggway.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ddpc.ggway.R
import com.ddpc.ggway.data.steam.models.Game
import kotlinx.android.synthetic.main.view_one_game.view.*

/**
 * Created by diha- on 08.03.2018.
 */
class GameProfileAdapter(val games: List<Game>, val itemClick: (Game) -> Unit) : RecyclerView.Adapter<GameProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_one_game, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindGameData(games[position])
    }

    override fun getItemCount() = games.size


    class ViewHolder(view: View, private val itemClick: (Game) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindGameData(game: Game) {
            with(game) {
                Glide.with(itemView)
                        .load("http://media.steampowered.com/steamcommunity/public/images/apps/${game.appid}/${game.imgLogoUrl}.jpg")
                        .into(itemView.gameImage)
                itemView.gameName.text = game.name
                itemView.gameTime2Weeks.text = getGameTimeline(game.playtime2weeks)
                itemView.gameTimeForAllTime.text = getGameTimeline(game.playtimeForever)
            }
        }
    }

    companion object {
        fun getGameTimeline(hours: Int): String = if ((hours / 60) > 0) {
           (hours / 60).toString() + " h."
       }else {
           (hours).toString() + " m."
       }
    }
}