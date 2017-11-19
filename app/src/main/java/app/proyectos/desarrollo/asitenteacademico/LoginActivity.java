package app.proyectos.desarrollo.asitenteacademico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView vtErrorUsr;
    private TextView vtErrorpass;
    private TextView vtRegistro;
    private EditText etUsr;
    private EditText etPass;
    private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        vtErrorUsr = (TextView) findViewById(R.id.tvErrorusr);
        vtErrorpass = (TextView) findViewById(R.id.tvErrorPass);
        vtRegistro = (TextView) findViewById(R.id.tvReg);
        etUsr = (EditText) findViewById(R.id.etUsr);
        etPass = (EditText) findViewById(R.id.etPass);
        btnlogin = (Button) findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        vtRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
