package com.example.power_up_lvl4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLMXM extends SQLiteOpenHelper {


    /// assest
    SQLiteDatabase SQLLLL;
    ContentValues ahmad;

    //DB
    private static final String DB_NAME = "MXM_DD";
    private static final int DB_V = 1;
    /// table
    public static final String TABLE_PHONE = "TABLE_PHONE";
    public static final String CUL_ID_PHONE = "ID_PHONE";
    public static final String CUL_NAME_PHONE = "NAME";
    public static final String CUL_NUMBER = "NUMBER";

    public SQLMXM(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_V);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CreateTalbe = "CREATE TABLE " + TABLE_PHONE + " ( " +
                CUL_ID_PHONE + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                CUL_NAME_PHONE + " TEXT, " +
                CUL_NUMBER + " TEXT ) ";

        sqLiteDatabase.execSQL(CreateTalbe);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PHONE);
        onCreate(sqLiteDatabase);
    }

    public Boolean ADD_Value(String Name, String Number) {
        try {
            SQLLLL = this.getWritableDatabase();
            ahmad = new ContentValues();
            ahmad.put(CUL_NAME_PHONE, Name);
            ahmad.put(CUL_NUMBER, Number);
            SQLLLL.insert(TABLE_PHONE, null, ahmad);
            return true;
        } catch (Exception a) {
            return false;
        } finally {
            SQLLLL.close();
        }
    }

    public void Delet(String Name) {
        SQLLLL = this.getWritableDatabase();
        ahmad = new ContentValues();
        SQLLLL.delete(TABLE_PHONE, CUL_NAME_PHONE + " = ? ", new String[]{String.valueOf(Name)});
    }

    public void Update(String OldName, String NewName, String NewNumber) {
        SQLLLL = this.getWritableDatabase();
        ahmad = new ContentValues();
        ahmad.put(CUL_NAME_PHONE, NewName);
        ahmad.put(CUL_NUMBER, NewNumber);
        SQLLLL.update(TABLE_PHONE, ahmad, CUL_NAME_PHONE + " = ?", new String[]{OldName});
    }

    public  List<String> Show_all( ) {

        List<String> go = new ArrayList<>();
        SQLLLL = this.getWritableDatabase();
        ahmad = new ContentValues();
        Cursor x = SQLLLL.query(TABLE_PHONE, null, null, null, null, null, null);

        if (x != null && x.moveToFirst()) {
            int CulName = x.getColumnIndexOrThrow(CUL_NAME_PHONE);
            int Culphone = x.getColumnIndexOrThrow(CUL_NUMBER);
            do {
                String name_get = x.getString(CulName);
                String nmuber_get = x.getString(Culphone);
                go.add(name_get + " " + nmuber_get);
            } while (x.moveToNext());
        }
    return  go;
    }

    public String Found(String Name) {

        String a = "";
        SQLLLL = this.getWritableDatabase();
        ahmad = new ContentValues();
        Cursor x = SQLLLL.query(TABLE_PHONE, new String[]{CUL_NAME_PHONE, CUL_NUMBER}, CUL_NAME_PHONE + "=?", new String[]{Name}, null, null, null);

        if (x != null)
        {
            if (x.moveToFirst())
            {
                int CulName = x.getColumnIndexOrThrow(CUL_NAME_PHONE);
                int Culphone = x.getColumnIndexOrThrow(CUL_NUMBER);

                    String name_get = x.getString(CulName);
                    String nmuber_get = x.getString(Culphone);
                a = name_get + nmuber_get;
            }
        }

        return  a;
    }

}
