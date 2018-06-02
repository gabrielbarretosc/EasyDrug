package br.ucsal.semoc.easydrug;

import android.provider.BaseColumns;


public class AlarmeContract {

    public static final String DB_NOME = "alarme.db";
    public static final int DB_VERSAO = 1;
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            AlarmeEntry.TABELA_NOME + " (" +
            AlarmeEntry._ID + " INTEGER PRIMARY KEY," +
            AlarmeEntry.COLUNA_NOME_NOME + " TEXT," +
            AlarmeEntry.COLUNA_NOME_DOSAGEM + " TEXT," +
            AlarmeEntry.COLUNA_NOME_DATA + " TEXT," +
            AlarmeEntry.COLUNA_NOME_HORARIO + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AlarmeEntry.TABELA_NOME;

    public static class AlarmeEntry implements BaseColumns {

        public static final String TABELA_NOME = "alarme";
        public static final String COLUNA_NOME_NOME = "nome";
        public static final String COLUNA_NOME_DOSAGEM = "dosagem";
        public static final String COLUNA_NOME_DATA = "data";
        public static final String COLUNA_NOME_HORARIO = "horario";


    }
}
