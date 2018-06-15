package br.ucsal.semoc.easydrug;


import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class CriarAlarmeActivity extends AppCompatActivity {

    private AlarmCursorAdapter adapter;
    private AlarmDbHelper alarmDbHelper = new AlarmDbHelper(this);

    ArrayList<Medicamento> medicamentos = new ArrayList<>();

    private EditText editNome;
    private EditText editDosagem;
    private TimePicker editHora;
    private CalendarView editData;

    private String nome;
    private String dosagem;
    private String hora;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_alarme);

        editNome = (EditText) findViewById(R.id.editText);
        editDosagem = (EditText) findViewById(R.id.editText2);
        editHora = (TimePicker) findViewById(R.id.timePicker);
        editData = (CalendarView) findViewById(R.id.calendarView);

        editNome.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    editNome.setText(null);
                }
                return false;
            }
        });

        editDosagem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    editDosagem.setText(null);
                }
                return false;
            }
        });

        SQLiteDatabase db = alarmDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM alarme", null);
        adapter = new AlarmCursorAdapter(this, cursor);


        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 1);
        PendingIntent intent = PendingIntent.getActivity(this, 999, new Intent(this, ListaActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void criarAlarme(View v){

            nome = editNome.getText().toString();
            dosagem = editDosagem.getText().toString();
            hora = String.valueOf(editHora.getHour()+ ":" +editHora.getMinute());
            data = String.valueOf(editData.getDateTextAppearance());

            Medicamento medicamento = new Medicamento(nome,dosagem,hora,data);

              Intent intent = new Intent(this,ListaActivity.class);

            intent.putExtra("NOME",nome);
            intent.putExtra("DOSAGEM",dosagem);
            intent.putExtra("HORA",hora);
            intent.putExtra("DATA",data);

            medicamentos.add(medicamento);
            addMedicamentoToDB(medicamentos);

            startActivity(intent);

    }

    private void addMedicamentoToDB(ArrayList<Medicamento> medicamentos) {
        SQLiteDatabase db = alarmDbHelper.getWritableDatabase();

        for(Medicamento m : medicamentos){

            //Consulto se já existe produto com este nome poderia ser outro criterio
            Cursor c = db.rawQuery("SELECT * FROM alarme where nome=?", new String[]{m.getNome()});
            //se não existe grava

            if(!c.moveToFirst()) {
                ContentValues values = new ContentValues();
                values.put(AlarmeContract.AlarmeEntry.COLUNA_NOME_NOME, m.getNome());
                values.put(AlarmeContract.AlarmeEntry.COLUNA_NOME_DOSAGEM, m.getDosagem());
                values.put(AlarmeContract.AlarmeEntry.COLUNA_NOME_HORARIO, m.getHora());
                values.put(AlarmeContract.AlarmeEntry.COLUNA_NOME_DATA, m.getData());

                db.insert(AlarmeContract.AlarmeEntry.TABELA_NOME, null, values);
            }
        }
    }


}