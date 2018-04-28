package com.yanes.album;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LidiayClaudia on 28/04/2018.
 */

public class DBDataSource {
    private SQLiteDatabase database;
    private MySQLiteHelper databaseHelper;
    String state= null;
    String t = null;

    public DBDataSource(Context context){
        databaseHelper = new MySQLiteHelper(context);
    }

    public void open(){
        database = databaseHelper.getReadableDatabase();
    }

    public void close(){
        database.close();
    }

    public List<Album> getAll(){
        List<Album> people = new ArrayList<>();

        String[] columnNames = MySQLiteHelper.FinalColum.names();

        // select person_id, last_name, first_name, age
        //from Person
        //order by last_name

        Cursor cursor = database.query(
                MySQLiteHelper.FINAL_TABLE,
                columnNames,
                null,null,null,null,
                MySQLiteHelper.FinalColum.Name.toString() //ordena por name
        );
        cursor.moveToFirst();

        while (! cursor.isAfterLast()) {

            Album album = cursorToPerson(cursor);
            if(state.equals( States.State )&& t.equals( type.Type)) {
                people.add(album);
            }
            cursor.moveToNext();

        }
        cursor.close();

        return people;
    }

    private Album cursorToPerson(Cursor cursor){
        Album info = new Album();

        state = cursor.getString(MySQLiteHelper.FinalColum.State.ordinal());
        info.setState(state);

        t = cursor.getString(MySQLiteHelper.FinalColum.Type.ordinal());
        info.setType(t);
        String name = cursor.getString(MySQLiteHelper.FinalColum.Name.ordinal());
        info.setName(name);
        String des = cursor.getString(MySQLiteHelper.FinalColum.Description.ordinal());
        info.setDescription(des);

        return info;
    }
}