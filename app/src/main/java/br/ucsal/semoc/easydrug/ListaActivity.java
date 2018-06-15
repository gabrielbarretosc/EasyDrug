package br.ucsal.semoc.easydrug;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class ListaActivity extends AppCompatActivity {

    ListView listView;
    private AlarmCursorAdapter adapter;
    private AlarmDbHelper alarmDbHelper = new AlarmDbHelper(this);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = ListaActivity.this.getIntent();

        AlarmDbHelper AlarmDbHelper = new AlarmDbHelper(this);
        SQLiteDatabase db = AlarmDbHelper.getWritableDatabase();

        int posicao = intent.getIntExtra("posicao",0);

        Cursor cursor = db.rawQuery("SELECT nome FROM alarme", null);
        cursor.moveToFirst();

        String[] listaAlarme = new String[]{AlarmeContract.DB_NOME,};
        int[] idViews = new int[]{R.id.editText};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_lista,cursor,listaAlarme,idViews, 0);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adaptador);
}
}
