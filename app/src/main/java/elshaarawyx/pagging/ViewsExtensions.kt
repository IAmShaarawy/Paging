package elshaarawyx.pagging

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by elshaarawy on 10/13/18.
 */
infix fun ImageView.loadAsRounded(url: String) {
    Glide.with(this)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
}

infix fun <T> T.logError(tag: String) {
    Log.e(tag, this.toString())
}

infix fun <T> T.log(tag: String) {
    Log.d(tag, this.toString())
}