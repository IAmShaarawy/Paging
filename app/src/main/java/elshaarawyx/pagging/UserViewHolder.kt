package elshaarawyx.pagging

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by elshaarawy on 10/13/18.
 */
class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(user: User) {
        itemView.apply {
            userAvatar loadAsRounded user.avatar
            userLogin.text = user.login
        }
    }
}