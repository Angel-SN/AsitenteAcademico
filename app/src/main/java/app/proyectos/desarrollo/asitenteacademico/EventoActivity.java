package app.proyectos.desarrollo.asitenteacademico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EventoActivity extends AppCompatActivity {

    private EditText Even;
    private EditText mate;
    private EditText Descr;
    private Button btnEven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        bindUI();
    }

    private void bindUI(){
        Even = (EditText) findViewById(R.id.Even);
        mate = (EditText)findViewById(R.id.mate);
        Descr = (EditText)findViewById(R.id.Descr);
        btnEven = (Button) findViewById(R.id.btnEven);
    }
}