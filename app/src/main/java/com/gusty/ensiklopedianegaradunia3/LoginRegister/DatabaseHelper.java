package com.gusty.ensiklopedianegaradunia3.LoginRegister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gusty on 31/05/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserManager.db";
    private static final String TABLE_USER = "User";

    private static final String COLOM_USER_ID = "user_id";
    private static final String COLOM_USER_NAME = "user_name";
    private static final String COLOM_USER_EMAIL = "user_email";
    private static final String COLOM_USER_PASSWORD = "user_password";

    private String CREATE_USER_TABLE = "CREATE TABLE "+ TABLE_USER +
            "("+COLOM_USER_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+COLOM_USER_NAME+"TEXT,"+
            COLOM_USER_EMAIL+"TEXT,"+COLOM_USER_PASSWORD+"TEXT"+")";
    private String DROP_USER_TABLE ="DROP TABLE IF EXISTS"+TABLE_USER;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);

    }
    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLOM_USER_NAME,user.getName());
        values.put(COLOM_USER_EMAIL,user.getEmail());
        values.put(COLOM_USER_PASSWORD,user.getPassword());

        db.insert(TABLE_USER,null,values);
        db.close();

    }
    public List<User> getAllUser(){
        String[]coloms={
                COLOM_USER_ID,COLOM_USER_NAME,COLOM_USER_EMAIL,COLOM_USER_PASSWORD
        };
        String sortOrder =
                COLOM_USER_NAME+"ASC";
        List<User> userList = new ArrayList<User>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER,coloms,null,null,null,null,sortOrder);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLOM_USER_NAME))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLOM_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLOM_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLOM_USER_PASSWORD)));

                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
        }
        public void updateUser(User user){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLOM_USER_NAME,user.getName());
            values.put(COLOM_USER_EMAIL,user.getEmail());
            values.put(COLOM_USER_PASSWORD,user.getPassword());

            db.update(TABLE_USER,values,COLOM_USER_ID+"=?",new String[]{String.valueOf(user.getId())});
            db.close();
        }
        public boolean checkUser(String email) {
            String[] coloms = {
                    COLOM_USER_ID
            };
            SQLiteDatabase db = this.getReadableDatabase();
            String selection = COLOM_USER_EMAIL + "=?";
            String[] selectionArgs = {email};
            Cursor cursor = db.query(TABLE_USER, coloms, selection, selectionArgs, null, null, null);
            int cursorCount = cursor.getCount();
            cursor.close();

            if (cursorCount > 0) {
                return true;
            }
            return false;
        }
        public boolean checkUser(String email, String password){
            String[] coloms={
                    COLOM_USER_ID
            };
            SQLiteDatabase db = this.getReadableDatabase();
            String selection = COLOM_USER_EMAIL+"=?"+"AND"+COLOM_USER_PASSWORD+"=?";
            String[] selectionArgs = {email,password};
            Cursor cursor = db.query(TABLE_USER,coloms,selection,selectionArgs,null,null,null);
            int cursorCount = cursor.getCount();
            cursor.close();
            db.close();
            if (cursorCount>0){
                return true;
            }
            return false;
        }

    }


