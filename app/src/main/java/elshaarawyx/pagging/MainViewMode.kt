package elshaarawyx.pagging

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList

/**
 * Created by elshaarawy on 10/13/18.
 */
class MainViewMode : ViewModel() {
    val usersLiveData by lazy { MediatorLiveData<PagedList<UserEntity>>() }
    private val userModel: UserModel by lazy { MainModel() }

    fun loadUsers() {
        val pagedUsersList = userModel.loadUsers()
        usersLiveData.addSource(pagedUsersList){}
    }

}