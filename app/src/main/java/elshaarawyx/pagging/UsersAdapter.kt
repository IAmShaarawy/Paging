package elshaarawyx.pagging

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by elshaarawy on 10/13/18.
 */
class UsersAdapter(private val usersList: MutableList<UserEntity>) : RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
            parent.run {
                LayoutInflater.from(context).inflate(R.layout.item_user, this, false)
            }.let { UserViewHolder(it) }


    override fun getItemCount(): Int = usersList.size


    override fun onBindViewHolder(userViewHolder: UserViewHolder, position: Int) =
            userViewHolder.bind(usersList[position])

    fun updateUsers(userEntity: UserEntity?): Unit {
        userEntity?.let {
            usersList.add(it)
            notifyItemInserted(usersList.size)
        }
    }
}