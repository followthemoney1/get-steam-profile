package com.ddpc.ggway.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.ddpc.ggway.R
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged

//import com.jakewharton.rxbinding2.widget.RxTextView
//import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent
//import io.reactivex.Observer
//import io.reactivex.disposables.Disposable


/**
 * Created by diha- on 10.03.2018.
 */
class RankAlertDialog(val appId: Int, private val rankPicked: RankPicked) : View.OnClickListener {
    interface RankPicked {
        fun picked(picked: String?, rank: Drawable?)
    }

    val DOTA = 570

    var rank: String? = null
    var resource: Drawable? = null

    fun getContentIdFromAppId(): Int {
        when (appId) {
            DOTA -> return R.layout.view_rank_dota
            else -> return R.layout.view_rank_notfound
        }
    }

    fun setClicableContentFromAppId(root: View) {
        when (appId) {
            DOTA -> {
                ///TODO : FUCKING UGLY
                val dotaRank1 = root.findViewById<ImageView>(R.id.dotaRank1) as ImageView
                val dotaRank2 = root.findViewById<ImageView>(R.id.dotaRank2) as ImageView
                val dotaRank3 = root.findViewById<ImageView>(R.id.dotaRank3) as ImageView
                val dotaRank4 = root.findViewById<ImageView>(R.id.dotaRank4) as ImageView
                val dotaRank5 = root.findViewById<ImageView>(R.id.dotaRank5) as ImageView
                val dotaRank6 = root.findViewById<ImageView>(R.id.dotaRank6) as ImageView
                val dotaRank7 = root.findViewById<ImageView>(R.id.dotaRank7) as ImageView
                val dotaRank8 = root.findViewById<ImageView>(R.id.dotaRank8) as ImageView
                val dotaRank9 = root.findViewById<ImageView>(R.id.dotaRank9) as ImageView
                val dotaRank10 = root.findViewById<ImageView>(R.id.dotaRank10) as ImageView
                dotaRank1.setOnClickListener(this)
                dotaRank2.setOnClickListener(this)
                dotaRank3.setOnClickListener(this)
                dotaRank4.setOnClickListener(this)
                dotaRank5.setOnClickListener(this)
                dotaRank6.setOnClickListener(this)
                dotaRank7.setOnClickListener(this)
                dotaRank8.setOnClickListener(this)
                dotaRank9.setOnClickListener(this)
                dotaRank10.setOnClickListener(this)
            }
            else -> {
                val rankEditText =  root.findViewById<EditText>(R.id.rankEditText) as EditText
                rankEditText.doAfterTextChanged {
                    if (rankEditText.length() > 0 && !rankEditText.text.toString().contains(" ")) {
                        rank = rankEditText.text.toString()
                    } else {
                        rank = null
                    }
                }

            }
        }
    }

    var previousViewClicked: View? = null
    override fun onClick(v: View?) {
        previousViewClicked?.setBackgroundColor(0)
        v?.setBackgroundColor(ContextCompat.getColor(v.context, R.color.background_color))
        rank = v?.transitionName
        resource = (v as ImageView).getDrawable()
        previousViewClicked = v
    }

    fun openAlertDialog(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val root = inflater.inflate(getContentIdFromAppId(), null)
        setClicableContentFromAppId(root)
        val b = AlertDialog.Builder(context, R.style.AlertDialogDark)
        b.setCancelable(false)
                .setTitle("")
                .setView(root)
                .setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                        rankPicked.picked(rank,resource)
                })
                .create()
                .show()
    }
}