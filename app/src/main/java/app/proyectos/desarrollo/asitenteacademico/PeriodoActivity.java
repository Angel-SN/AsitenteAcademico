package app.proyectos.desarrollo.asitenteacademico;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import app.proyectos.desarrollo.asitenteacademico.Adapter.AdapterFechas;

public class PeriodoActivity extends AppCompatActivity {

    private ListView lvFechas;
    private List<String> fechas;

    private Button btnGuardar,btnNuevoPeriodo;

    int dia,mes,anio;

    AdapterFechas adapterFechas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodo);

        lvFechas = findViewById(R.id.lvFechas);

        btnGuardar = findViewById(R.id.btnGuardarPeriodo);
        btnNuevoPeriodo = findViewById(R.id.btnAgregar);

        fechas = new ArrayList<>();
        final Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) +1 ;
        anio = c.get(Calendar.YEAR);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fechas);

        lvFechas.setAdapter(adapter);

        lvFechas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


            }
        });

        adapterFechas = new AdapterFechas(this, R.layout.layout_fecha, fechas);
        lvFechas.setAdapter(adapterFechas);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });

        btnNuevoPeriodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        addFecha(dayOfMonth,month,year);
                    }
                },anio,mes,dia);
                datePickerDialog.show();
            }
        });
    }

    private void goToMain(){
        Intent intent = new Intent(PeriodoActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void addFecha(int day, int month, int year){
        this.fechas.add(day+"-"+month+"-"+year);
        this.adapterFechas.notifyDataSetChanged();
    }
}

