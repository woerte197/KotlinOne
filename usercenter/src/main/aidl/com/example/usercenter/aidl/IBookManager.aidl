// IBookManager.aidl
package com.example.usercenter.aidl;

// Declare any non-default types here with import statements
import com.example.usercenter.aidl.Book;
interface IBookManager{
            List<Book> getBookList();
            void addBook(in Book book);
}
