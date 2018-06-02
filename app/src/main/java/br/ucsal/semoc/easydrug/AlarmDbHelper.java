package br.ucsal.semoc.easydrug;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlarmDbHelper extends SQLiteOpenHelper {

    public AlarmDbHelper(Context context){
        super(context,AlarmeContract.DB_NOME,null,AlarmeContract.DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(AlarmeContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(AlarmeContract.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }


    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(AlarmeContract.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);    }
}
