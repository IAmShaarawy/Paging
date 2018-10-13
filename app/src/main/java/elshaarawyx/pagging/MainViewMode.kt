package elshaarawyx.pagging

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by elshaarawy on 10/13/18.
 */
class MainViewMode : ViewModel() {
    val usersLiveData: MutableLiveData<UserEntity> by lazy { MutableLiveData<UserEntity>() }
    private val userModel: UserModel by lazy { MainModel() }

    fun loadUsers() {
        userModel.loadUsers({ it log "SERVER_ERROR" }, usersLiveData::postValue)
    }

}