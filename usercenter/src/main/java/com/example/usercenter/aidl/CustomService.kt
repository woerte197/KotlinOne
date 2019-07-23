package com.example.usercenter.aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException

class CustomService : Service() {
    var mBookList: MutableList<Book> = ArrayList()
    override fun onBind(intent: Intent): IBinder {
        return BookManagerImpl()
    }


    private inner class BookManagerImpl : IBookManager.Stub() {
        @Throws(RemoteException::class)
        @Synchronized
        override fun getBookList(): List<Book> {
                return mBookList!!
        }

        @Throws(RemoteException::class)
        @Synchronized
        override fun addBook(book: Book) {
                if (!mBookList!!.contains(book)) {
                    mBookList!!.add(book)
                }
        }

        override fun linkToDeath(recipient: IBinder.DeathRecipient, flags: Int) {
            super.linkToDeath(recipient, flags)
        }

        override fun unlinkToDeath(recipient: IBinder.DeathRecipient, flags: Int): Boolean {
            return super.unlinkToDeath(recipient, flags)
        }
    }

}
