package com.ddpc.ggway.ui.adapter

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ddpc.ggway.R
import com.ddpc.ggway.data.steam.models.Game
import com.ddpc.ggway.utils.RankAlertDialog
import com.ddpc.ggway.utils.SteamGamesImageManager.getResIdByGameId
import kotlinx.android.synthetic.main.view_one_game.view.*

/**
 * Created by diha- on 08.03.2018.
 */
class GameProfileAdapter(val games: List<Game>?, val itemClick: (Game) -> Unit) : RecyclerView.Adapter<GameProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_one_game, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        games?.get(position)?.let { holder.bindGameData(it) }
    }

    override fun getItemCount(): Int {
        return if (games?.size != null) games.size else 0
    }


    class ViewHolder(view: View, private val itemClick: (Game) -> Unit)
        : RecyclerView.ViewHolder(view), RankAlertDialog.RankPicked {

        private var gameData: Game? = null

        fun bindGameData(game: Game) {
            with(game) {
                if (getResIdByGameId(game.appid) != null) loadLocalDrawable(getResIdByGameId(game.appid));
                else {
                    print("http://media.steampowered.com/steamcommunity/public/images/apps/${game.appid}/${game.imgLogoUrl}.jpg")

                    Glide.with(itemView)
                            .load("http://media.steampowered.com/steamcommunity/public/images/apps/${game.appid}/${game.imgLogoUrl}.jpg")
                            .into(itemView.gameImage)
                }

                Glide.with(itemView)
                        .load("http://media.steampowered.com/steamcommunity/public/images/apps/${game.appid}/${game.imgIconUrl}.jpg")
                        .into(itemView.gameIcon)

                itemView.gameName.text = game.name
                itemView.gameTime2Weeks.text = getGameTimeline(game.playtime2weeks)
                itemView.gameTimeForAllTime.text = getGameTimeline(game.playtimeForever)

                itemView.rankName.setOnClickListener {
                    gameData = game
                    RankAlertDialog(game.appid, this@ViewHolder).openAlertDialog(itemView.context)
                }
                itemView.gameRank.setOnClickListener {
                    gameData = game
                    RankAlertDialog(game.appid, this@ViewHolder).openAlertDialog(itemView.context)
                }

            }
        }

        fun loadLocalDrawable(resId: Int) {
            itemView.gameImage.setImageResource(resId)
        }

        override fun picked(picked: String?, resource: Drawable?) {
            if (picked == null) return
            gameData?.gameRank = picked

            if (resource != null)
                itemView.gameRank.setImageDrawable(resource)
            else {
                itemView.gameRank.visibility = View.GONE
                itemView.rankName.visibility = View.VISIBLE
                itemView.rankName.text = picked
            }
        }

    }


    companion object {
        fun getGameTimeline(hours: Int): String = if ((hours / 60) > 0) {
            (hours / 60).toString() + " h."
        } else {
            (hours).toString() + " m."
        }
    }
}