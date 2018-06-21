package com.yanes.album;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by LidiayClaudia on 28/04/2018.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "hola.db";

    public static  final String DB_VERSION_KEY = "db_ver";
    public  static final int DB_VERSION = 1;

    public static final String FINAL_TABLE = "Album";

    public enum FinalColum {
        State, Type, Name, Description;

        public static String[] names(){
            FinalColum[] v= values();
            String [] names= new String[v.length];
            for(int i=0; i<v.length; i++){
                names[i] = v[i].toString();
            }

            return names;
        }

    }

    private Context context;


    public MySQLiteHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;

        checkDatabase();
    }

    private void checkDatabase() {
        if(databaseExists()){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            int dbVersion = preferences.getInt(DB_VERSION_KEY, 0 );
            if(DB_VERSION != dbVersion){
                File database = getDatabaseFile();
                database.delete();
            }
        }

        if(!databaseExists()){
            createDatabaseDir();
            createDatabase();
        }
    }

    private void createDatabaseDir(){
        File database = getDatabaseFile();
        File directory = database.getParentFile();
        if(!directory.exists()){
            directory.mkdirs();

        }
    }

    private void createDatabase(){
        try {
            InputStream inputStream = context.getAssets().open(DB_NAME);


            File database = getDatabaseFile();
            OutputStream outputStream = new FileOutputStream(database);

            byte[] buffer = new byte[1024];
            int byteRead;

            while ((byteRead = inputStream.read(buffer))>0){
                outputStream.write(buffer, 0, byteRead);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();

            SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt(DB_VERSION_KEY, DB_VERSION);
            editor.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean databaseExists(){
        File database = getDatabaseFile();
        return database.exists();
    }

    private File getDatabaseFile(){
        return context.getDatabasePath(DB_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
