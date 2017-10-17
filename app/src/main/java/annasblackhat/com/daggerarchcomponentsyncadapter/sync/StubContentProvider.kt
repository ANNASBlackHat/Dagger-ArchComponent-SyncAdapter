package annasblackhat.com.daggerarchcomponentsyncadapter.sync

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

/**
 * Created by Git Solution on 17/10/2017.
 */
class StubContentProvider : ContentProvider() {
    override fun insert(p0: Uri?, p1: ContentValues?): Uri? {
        return null
    }

    override fun query(p0: Uri?, p1: Array<out String>?, p2: String?, p3: Array<out String>?, p4: String?): Cursor? {
        return null
    }

    override fun onCreate() = true

    override fun update(p0: Uri?, p1: ContentValues?, p2: String?, p3: Array<out String>?)= 0

    override fun delete(p0: Uri?, p1: String?, p2: Array<out String>?) = 0

    override fun getType(p0: Uri?): String?  = null
}