package elshaarawyx.pagging

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList

/**
 * Created by elshaarawy on 10/13/18.
 */
interface UserModel {
    fun loadUsers():LiveData<PagedList<UserEntity>>
}