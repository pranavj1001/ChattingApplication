package com.learning.pranavjain.chattingapplication.toolBox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pranav Jain on 11/1/2016.
 */

public class StorageManipulator extends SQLiteOpenHelper {

    public static final String DataBase_name = "ChatApp.db";
    public static final int DataBase_ver = 1;
    public static final String _Id = "_id";
    public static final String Table_name_message = "table_message";
    public static final String Message_Receiver = "receiver";
    public static final String Message_Sender = " Sender";
    public static final String Message_Message = "message";

    private static final String TABLE_MESSAGE_CREATE =
            "CREATE TABLE " + Table_name_message
            + " (" + _Id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Message_Receiver + " VARCHAR(25), "
            + Message_Sender + " VARCHAR(25))";

    public static final String Table_Message_Drop = "DROP TABLE IF EXISTS " + Table_name_message;

    public StorageManipulator(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_MESSAGE_CREATE);

    }

    public void insert(String Sender, String Receiver, String Message){
        long rowId;
        try{

            SQLiteDatabase db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Message_Receiver, Receiver);
            contentValues.put(Message_Sender, Sender);
            contentValues.put(Message_Message, Message);
            rowId = db.insert(Table_name_message, null, contentValues);

        }catch (Exception e){

        }
    }

    public Cursor get(String sender, String receiver){

        SQLiteDatabase db = getWritableDatabase();
        String selectQuery = "SELECT * FROM " + Table_name_message + " WHERE "
                + Message_Sender + " LIKE " + sender + " AND "
                + Message_Receiver + " LIKE " + receiver
                + " ORDER BY " + _Id + " ASC ";

        return null;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Table_Message_Drop);
    }
}
