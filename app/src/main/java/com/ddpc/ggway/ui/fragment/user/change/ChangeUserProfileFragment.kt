package com.ddpc.ggway.ui.fragment.user.change

import android.app.Fragment
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_change_user_profile.*
import com.bumptech.glide.Glide
import com.ddpc.ggway.R
import com.ddpc.ggway.data.steam.UserData
import com.ddpc.ggway.ui.adapter.GameProfileAdapter
import com.ddpc.ggway.utils.Constants
import de.hdodenhof.circleimageview.CircleImageView
import java.io.Serializable

/**
 * Created by diha- on 02.03.2018.
 */
class ChangeUserProfileFragment: androidx.fragment.app.Fragment(),ChangeUserProfileView,Serializable {
//    @BindView(R.id.recycleView)
//    lateinit var recycleView: RecyclerView
//    @BindView(R.id.userPhoto)
//    lateinit var userPhoto: CircleImageView
//    @BindView(R.id.userNickname)
//    lateinit var userNickname: EditText

    lateinit var steamUser:UserData
    lateinit var presenter: ChangeUserProfilePresenterImpl

    companion object {
        fun newInstance(o: UserData):ChangeUserProfileFragment{
            val args = Bundle()
            val fragment = ChangeUserProfileFragment()
            args.putSerializable(Constants.STEAM_USER_PROFILE,o as Serializable)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_change_user_profile,container,false)
        presenter = ChangeUserProfilePresenterImpl(this,context!!)
        return root
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
      Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    override fun getFragmentArguments() {
        steamUser = arguments!!.get(Constants.STEAM_USER_PROFILE) as UserData
    }

    override fun initViews() {
     Glide.with(context!!)
             .load(steamUser.steamUser?.avatarFull)
             .into(userPhoto)

       userNickname.setText(steamUser.steamUser?.steamID)
    }


    override fun initRecycleView() {
       val gameProfileAdapter = GameProfileAdapter(steamUser.gameData?.games){

       }
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = gameProfileAdapter

    }

}