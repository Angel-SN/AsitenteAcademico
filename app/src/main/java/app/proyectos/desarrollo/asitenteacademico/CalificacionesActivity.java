package app.proyectos.desarrollo.asitenteacademico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CalificacionesActivity extends AppCompatActivity {

    private EditText Cal;
    private EditText porc;
    private Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificacion);
        bindUI();


    }

    private void bindUI(){
        Cal = (EditText) findViewById(R.id.Cal);
        porc = (EditText)findViewById(R.id.porc);
        btnCal = (Button) findViewById(R.id.btnCal);
    }
}