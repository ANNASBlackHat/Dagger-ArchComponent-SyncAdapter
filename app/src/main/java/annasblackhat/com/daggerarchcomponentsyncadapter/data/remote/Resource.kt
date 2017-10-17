package id.uniq.uniqpos.data.remote

import id.uniq.uniqpos.data.remote.Status.ERROR
import id.uniq.uniqpos.data.remote.Status.LOADING
import id.uniq.uniqpos.data.remote.Status.SUCCESS


class Resource<T> private constructor(val status: Status, val data: T?, val message: String?) {
    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String?, data: T?): Resource<T> {
            return Resource(ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, data, null)
        }
    }
}
