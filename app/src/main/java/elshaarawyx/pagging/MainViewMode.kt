package elshaarawyx.pagging

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by elshaarawy on 10/13/18.
 */
class MainViewMode : ViewModel() {
    val usersLiveData: MutableLiveData<User> by lazy { MutableLiveData<User>() }

    fun loadUsers(){

    }

}