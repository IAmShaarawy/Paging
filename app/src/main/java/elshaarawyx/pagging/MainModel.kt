package elshaarawyx.pagging

import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch


/**
 * Created by elshaarawy on 10/13/18.
 */
class MainModel : UserModel {

    override inline fun loadUsers(crossinline onFailure: (String) -> Unit,
                                  noinline onSuccess: (UserEntity) -> Unit) {
        GlobalScope.launch {

            val response = GithubAPIsFactory()
                    .create(UsersAPIs::class.java)
                    .retrieveUsers(45)
                    .await()

            GlobalScope.launch(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()?.forEach {
                        delay(1000)
                        onSuccess(it)
                    } ?: onFailure("No users found")
                } else {
                    onFailure("Failed to load users error: ${response.code()}, ${response.errorBody()}")
                }
            }
        }
    }
}