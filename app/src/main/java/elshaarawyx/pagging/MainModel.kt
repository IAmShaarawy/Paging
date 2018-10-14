package elshaarawyx.pagging

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.os.Build
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch


/**
 * Created by elshaarawy on 10/13/18.
 */
class MainModel : UserModel {
    private val dataSourceFactory by lazy { GithubUsersDataSourceFactory() }

    override fun loadUsers(): LiveData<PagedList<UserEntity>> {
        val config = PagedList.Config
                .Builder()
                .setPageSize(4)
                .setEnablePlaceholders(false)
                .build()
        return LivePagedListBuilder(dataSourceFactory, config).build()
    }


}