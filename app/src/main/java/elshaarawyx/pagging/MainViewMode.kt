package elshaarawyx.pagging

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import kotlinx.coroutines.experimental.delay

/**
 * Created by elshaarawy on 10/13/18.
 */
class MainViewMode : ViewModel() {
    val usersLiveData: MutableLiveData<User> by lazy { MutableLiveData<User>() }
    private val userModel: UserModel by lazy { MainModel() }

    fun loadUsers() {
        userModel.loadUsers({ it log "SERVER_ERROR" }, usersLiveData::postValue)
    }

}