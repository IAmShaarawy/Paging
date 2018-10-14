package elshaarawyx.pagging.viewmodel

import android.arch.lifecycle.*
import android.arch.paging.PagedList
import elshaarawyx.pagging.model.MainModel
import elshaarawyx.pagging.model.UserEntity
import elshaarawyx.pagging.model.UserModel

/**
 * Created by elshaarawy on 10/13/18.
 */
class MainViewMode : ViewModel() {
    private val userModel: UserModel by lazy { MainModel() }

    fun loadUsers(): LiveData<PagedList<UserEntity>> = userModel.loadUsers()

}