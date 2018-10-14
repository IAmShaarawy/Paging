package elshaarawyx.pagging.extensions

import android.util.Log

/**
 * Created by elshaarawy on 10/14/18.
 */
infix fun <T> T.logError(tag: String) {
    Log.e(tag, this.toString())
}

infix fun <T> T.log(tag: String) {
    Log.d(tag, this.toString())
}