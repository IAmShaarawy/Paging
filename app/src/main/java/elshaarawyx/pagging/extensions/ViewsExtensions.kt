package elshaarawyx.pagging.extensions

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