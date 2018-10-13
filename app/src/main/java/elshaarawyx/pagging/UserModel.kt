package elshaarawyx.pagging

/**
 * Created by elshaarawy on 10/13/18.
 */
interface UserModel {
    fun loadUsers(onFailure: (Exception) -> Unit , onSuccess: (List<User>) -> Unit)
}