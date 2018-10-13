package elshaarawyx.pagging

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by elshaarawy on 10/13/18.
 */
class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(userEntity: UserEntity) {
        itemView.apply {
            userAvatar loadAsRounded userEntity.avatar
            userLogin.text = userEntity.login
            setOnClickListener {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(userEntity.profileUrl)))
            }
        }
    }
}