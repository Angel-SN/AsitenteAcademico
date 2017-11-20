package app.proyectos.desarrollo.asitenteacademico;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RegistroActivity extends AppCompatActivity {

    private TextView vtErrorUsr;
    private TextView vtErrorpass;
    private EditText etUsr;
    private EditText etPass;
    private EditText etPassConfirm;
    private Button btnRegistro;

    private boolean flag;
    private String msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        bindUI();
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = etUsr.getText().toString();
                String pass = etPass.getText().toString();
                String passC = etPassConfirm.getText().toString();
                registro(user_name, pass, passC);
                if (flag == true){
                    Toast.makeText(RegistroActivity.this, msj , Toast.LENGTH_SHORT).show();
                    Intent periodos = new Intent(RegistroActivity.this, PeriodoActivity.class);
                    periodos.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(periodos);
                }
            }
        });

    }

    private void bindUI(){
        vtErrorUsr = (TextView) findViewById(R.id.tvErrorusr);
        vtErrorpass = (TextView) findViewById(R.id.tvErrorPass);
        etUsr = (EditText) findViewById(R.id.etUsr);
        etPass = (EditText)findViewById(R.id.etPass);
        etPassConfirm = (EditText) findViewById(R.id.etPassC);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
    }

    private void registro(String usr_name, String pass, String passConfirm){
        if(TextUtils.isEmpty(usr_name)){
            vtErrorpass.setText("Usuario no valido");
        } else if(!pass.equals(passConfirm)){
            vtErrorpass.setText("contraseñas no coinciden");
        } else {
            TareaRegistro tarea = new TareaRegistro();
            flag = true;
            msj = "inicio de sesion correcto";
            //tarea.execute(
            //        usr_name,
            //        pass
            //);
        }
    }


    private class TareaRegistro extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            String user = strings[0];
            String pass = strings[1];

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost("https://proyectoultimo.000webhostapp.com/ClienteAndroid/usuario/");
            post.setHeader("content-type", "application/json");
            post.setHeader("Accept", "application/json");
            try {
                JSONObject dato = new JSONObject();
                dato.put("NombreUsuario",user);
                dato.put("Contraseña", pass);
                StringEntity entity = new StringEntity(dato.toString());
                post.setEntity(entity);
                HttpResponse resp = httpClient.execute(post);
                String respStr = EntityUtils.toString(resp.getEntity());

                JSONObject respJSON = new JSONObject(respStr);
                flag = respJSON.getBoolean("flag");
                if(flag == true){
                    msj = respJSON.getString("mensaje");
                    return true;
                }else{
                    return false;
                }
            }catch (Exception e){
                Log.e("ServicioRest","Error!", e);
                return false;
            }
        }
    }

}
