package com.example.andriod;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Login extends AppCompatActivity {
    private Button login;
    private Button registerNewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClient();
            }
        });
        registerNewClient=(Button) findViewById(R.id.btn_registerNewClient);
        registerNewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rclient=new Intent(getApplicationContext(),RegisterUser.class);
                startActivity(rclient);
            }
        });
        loginClient();
    }

    public void loginClient(){
        TextView email=findViewById(R.id.emailCl);
        TextView password= findViewById(R.id.passwordCl);
        AsyncHttpClient client= new AsyncHttpClient();
        RequestParams params=new RequestParams();
        params.add("email",email.getText().toString());
        params.add("password",password.getText().toString());

     /*   client.post(Data.HOST+Data.LOGIN,params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                try{
                    String token=response.getString("token");
                    alertDialog.setTitle("RESPONSE SERVER");
                    alertDialog.setMessage("Sesion Iniciada");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                    Data.TOKEN="data "+token;
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });*/
        //email.setText(Data.TOKEN);
    }
    public void princi(View view){
        Intent main= new Intent(this, principal.class);
        startActivity(main);
    }
}
