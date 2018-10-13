package elshaarawyx.pagging

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by elshaarawy on 10/13/18.
 */
class UsersAdapter : ListAdapter<UserEntity, UserViewHolder>(USER_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
            UserViewHolder.create(parent)


    override fun onBindViewHolder(userViewHolder: UserViewHolder, position: Int) =
            getItem(position)?.run(userViewHolder::bind) ?: Unit


    companion object {
        val USER_COMPARATOR = object : DiffUtil.ItemCallback<UserEntity>() {
            override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean =
                    oldItem == newItem

        }
    }
}