package br.ucsal.semoc.easydrug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    ListView listView;
    List<Medicamento> alarmes = new ArrayList<Medicamento>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        String nome = intent.getStringExtra("NOME");
        String dosagem = intent.getStringExtra("DOSAGEM");
        String hora =  intent.getStringExtra("HORA");
        String data =  intent.getStringExtra("DATA");

        Medicamento medicamento = new Medicamento(nome,dosagem,hora,data);
        alarmes.add(medicamento);

        ArrayAdapter <Medicamento> adapter = new ArrayAdapter<>(
                ListaActivity.this, android.R.layout.simple_list_item_1,alarmes
        );

       listView=(ListView)findViewById(R.id.listView);
       listView.setAdapter(adapter);

//
//      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//          @Override
//          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//          }
//      });

       // }

    }
}
