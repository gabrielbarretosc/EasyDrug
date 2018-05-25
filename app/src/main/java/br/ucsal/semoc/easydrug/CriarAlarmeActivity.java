package br.ucsal.semoc.easydrug;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;

public class CriarAlarmeActivity extends Activity {


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

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void criarAlarme(View v){

        nome = editNome.getText().toString();
        dosagem = editDosagem.getText().toString();
        hora = String.valueOf(editHora.getHour()+ ":" +editHora.getMinute());
        data = String.valueOf(editData.getDateTextAppearance());

        Intent intent = new Intent(this,ListaActivity.class);

        intent.putExtra("NOME",nome);
        intent.putExtra("DOSAGEM",dosagem);
        intent.putExtra("HORA",hora);
        intent.putExtra("DATA",data);

        startActivity(intent);
    }

}
