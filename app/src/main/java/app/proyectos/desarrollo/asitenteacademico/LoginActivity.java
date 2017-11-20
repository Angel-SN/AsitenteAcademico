package app.proyectos.desarrollo.asitenteacademico;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;

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

        bindUI();

        preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        setCredentialsIfExist();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usr_name = etUsr.getText().toString();
                String pass = etPass.getText().toString();
                if(login(usr_name, pass)){
                    saveOnPreferences(usr_name, pass);
                    goToMain();
                }
            }
        });

        vtRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToReg();
            }
        });
    }

    private void setCredentialsIfExist() {
        String usr_name = getUserpreferences();
        String pass = getPasswordpreferences();
        if(!TextUtils.isEmpty(usr_name) && !TextUtils.isEmpty(pass)) {
            etUsr.setText(usr_name);
            etPass.setText(pass);
        }
    }

    private boolean login(String usr_name, String pass){
        if (!isValidUsr(usr_name)){
            vtErrorUsr.setText("verifica tu informacion");
        } else if (!isValidPass(pass)){
            vtErrorpass.setText("Contraseña invalida");
        } else{
            return true;
        }
        return false;
    }

    private void  bindUI(){
        vtErrorUsr = (TextView) findViewById(R.id.tvErrorusr);
        vtErrorpass = (TextView) findViewById(R.id.tvErrorPass);
        vtRegistro = (TextView) findViewById(R.id.tvReg);
        etUsr = (EditText) findViewById(R.id.etUsr);
        etPass = (EditText) findViewById(R.id.etPass);
        btnlogin = (Button) findViewById(R.id.btnLogin);
    }

    private void saveOnPreferences(String usr_name, String pass){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", usr_name);
        editor.putString("password", pass);
        editor.apply();
    }

    private String getUserpreferences(){
        return preferences.getString("user","");
    }

    private String getPasswordpreferences(){
        return preferences.getString("password","");
    }

    private boolean isValidUsr(String user_name){
        return !TextUtils.isEmpty(user_name);
    }

    private boolean isValidPass(String pass){
        return pass.length() > 6;
    }

    private void goToReg(){
        Intent reg = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivity(reg);
    }
    private void goToMain(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }



}
