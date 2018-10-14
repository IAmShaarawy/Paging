package elshaarawyx.pagging.model

import android.arch.paging.DataSource

/**
 * Created by elshaarawy on 10/14/18.
 */
class GithubUsersDataSourceFactory : DataSource.Factory<Long, UserEntity>() {
    override fun create(): DataSource<Long, UserEntity> = GithubUsersDataSource()
}