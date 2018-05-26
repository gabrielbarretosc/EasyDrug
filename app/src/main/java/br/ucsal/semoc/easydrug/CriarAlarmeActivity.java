package br.ucsal.semoc.easydrug;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

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

        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 1);
        PendingIntent intent = PendingIntent.getActivity(this, 999, new Intent(this, ListaActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        alarm.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), intent);
    }

    public boolean verificaNome(){
        if(editNome.getText() == null){
            return false;
        }
        return true;
    }

    public boolean verificaDosagem(){
        if(editDosagem == null){
            return false;
        }
        return true;
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