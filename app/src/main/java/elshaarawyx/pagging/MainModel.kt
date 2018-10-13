package elshaarawyx.pagging

import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch


/**
 * Created by elshaarawy on 10/13/18.
 */
class MainModel : UserModel {

    override inline fun loadUsers(crossinline onFailure: (Exception) -> Unit,
                                  crossinline onSuccess: (List<User>) -> Unit) {
        GlobalScope.launch {

            val users = GithubAPIsFactory()
                    .create(UsersAPIs::class.java)
                    .retrieveUsers(0)
                    .await()

            GlobalScope.launch(Dispatchers.Main) {
                onSuccess(users)
            }
        }
    }
}