package elshaarawyx.pagging.model

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList


/**
 * Created by elshaarawy on 10/13/18.
 */
class MainModel : UserModel {
    private val dataSourceFactory by lazy { GithubUsersDataSourceFactory() }

    override fun loadUsers(): LiveData<PagedList<UserEntity>> {
        val config = PagedList.Config
                .Builder()
                .setPageSize(46)
                .setPrefetchDistance(23)
                .setEnablePlaceholders(false)
                .build()
        return LivePagedListBuilder(dataSourceFactory, config).build()
    }


}