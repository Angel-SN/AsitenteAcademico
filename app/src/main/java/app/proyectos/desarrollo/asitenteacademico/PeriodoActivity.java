package app.proyectos.desarrollo.asitenteacademico;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PeriodoActivity extends AppCompatActivity {

    private ListView lvFechas;
    private List<String> fechas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodo);

        lvFechas = findViewById(R.id.lvFechas);
        fechas = new ArrayList<>();
        fechas.add("20-11-2017");
        fechas.add("20-11-2017");
        fechas.add("20-11-2017");
        fechas.add("20-11-2017");
        fechas.add("20-11-2017");
        fechas.add("20-11-2017");

        AdpterFechas adpterFechas = new AdpterFechas(this, R.layout.layout_fecha, fechas);
        lvFechas.setAdapter(adpterFechas);
    }
}

