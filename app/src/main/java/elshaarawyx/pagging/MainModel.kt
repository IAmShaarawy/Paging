package elshaarawyx.pagging

import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch


/**
 * Created by elshaarawy on 10/13/18.
 */
class MainModel : UserModel {

    override inline fun loadUsers(crossinline onFailure: (String) -> Unit,
                                  noinline onSuccess: (List<UserEntity>) -> Unit) {
        GlobalScope.launch {

            val response = GithubAPIsFactory()
                    .create(UsersAPIs::class.java)
                    .retrieveUsers(45)
                    .await()

            GlobalScope.launch(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()
                            ?.also(onSuccess)
                            ?: onFailure("No users found")
                } else {
                    onFailure("Failed to load users error: ${response.code()}, ${response.errorBody()}")
                }
            }
        }
    }
}