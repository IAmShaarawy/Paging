package elshaarawyx.pagging.view

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elshaarawyx.pagging.R
import elshaarawyx.pagging.model.UserEntity
import elshaarawyx.pagging.extensions.loadAsRounded
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by elshaarawy on 10/13/18.
 */
class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(userEntity: UserEntity) {
        itemView.apply {
            userAvatar loadAsRounded userEntity.avatar
            userLogin.text = "${userEntity.login}\n${userEntity.id}"
            setOnClickListener {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(userEntity.profileUrl)))
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): UserViewHolder =
                parent.run {
                    LayoutInflater.from(context).inflate(R.layout.item_user, this, false)
                }.let { UserViewHolder(it) }

    }
}