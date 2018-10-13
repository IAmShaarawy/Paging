package elshaarawyx.pagging

import android.arch.paging.PageKeyedDataSource
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

/**
 * Created by elshaarawy on 10/14/18.
 */
class GithubUsersDataSource : PageKeyedDataSource<Long, UserEntity>() {

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Long, UserEntity>) {
        loadData(0) {
            callback.onResult(it, null, it.lastOrNull()?.id)
        }
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, UserEntity>) {
        params.key?.let {
            loadData(it) { result ->
                callback.onResult(result, result.lastOrNull()?.id)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, UserEntity>) {
        params.key?.let {
            loadData(it) { result ->
                callback.onResult(result, result.firstOrNull()?.id)
            }
        }
    }

    private inline fun loadData(since: Long, crossinline onSuccess: (List<UserEntity>) -> Unit) {
        GlobalScope.launch {

            val response = GithubAPIsFactory()
                    .create(UsersAPIs::class.java)
                    .retrieveUsers(since)
                    .await()

            GlobalScope.launch(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()
                            ?.also(onSuccess)
                }
            }
        }
    }
}