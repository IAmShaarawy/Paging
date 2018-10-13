package elshaarawyx.pagging

import com.google.gson.annotations.SerializedName

/**
 * Created by elshaarawy on 10/13/18.
 */
data class UserEntity(val login: String,
                      val id: Long,
                      @SerializedName("avatar_url") val avatar: String,
                      @SerializedName("html_url") val profileUrl: String)