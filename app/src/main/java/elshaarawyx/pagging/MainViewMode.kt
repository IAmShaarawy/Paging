package elshaarawyx.pagging

import android.arch.lifecycle.*
import android.arch.paging.PagedList

/**
 * Created by elshaarawy on 10/13/18.
 */
class MainViewMode : ViewModel() {
    private val userModel: UserModel by lazy { MainModel() }

    fun loadUsers(): LiveData<PagedList<UserEntity>> = userModel.loadUsers()

}