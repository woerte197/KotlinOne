import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySql constructor(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    val VERSION = 1

    override fun onCreate(db: SQLiteDatabase) {
       val sqlString = "create table name(id int, uName varchar(20),uAge int,uSex varchar(10))"
        db.execSQL(sqlString)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {


    }
}
