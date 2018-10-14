package elshaarawyx.pagging.retrofit

import elshaarawyx.pagging.model.UserEntity
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by elshaarawy on 10/13/18.
 */
interface UsersAPIs {
    @GET("/users")
    fun retrieveUsers(@Query("since") since: Long): Deferred<Response<List<UserEntity>>>
}