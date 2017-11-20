package app.proyectos.desarrollo.asitenteacademico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    private EditText etUsr;
    private EditText etPass;
    private EditText etPassConfirm;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


    }

    private void bindUI(){
        etUsr = (EditText) findViewById(R.id.etUsr);
        etPass = (EditText)findViewById(R.id.etPass);
        etPassConfirm = (EditText) findViewById(R.id.etPassC);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
    }
}
