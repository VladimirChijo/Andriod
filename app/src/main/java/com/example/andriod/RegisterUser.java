package com.example.andriod;

import android.app.Activity;
import android.content.Context;
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

public class RegisterUser extends AppCompatActivity {
    private Button register;
    private static Context RC=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        register=findViewById(R.id.btn_registerCl);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataClient();

            }
        });
    }
    private void sendDataClient(){
        TextView firstName=findViewById(R.id.firstNameCl);
        TextView lastName=findViewById(R.id.lastNameCl);
        TextView ci=findViewById(R.id.ciCl);
        TextView email=findViewById(R.id.emailCl);
        TextView phone=findViewById(R.id.phoneCl);
        TextView password=findViewById(R.id.passwordCl);
        /*   if(!password.getText().toString().equals(confPassword.getText().toString())){
            AlertDialog alertDialog = new AlertDialog.Builder(RegisterClient.this).create();
            alertDialog.setTitle("ERROR CONTRASEÑA");
            alertDialog.setMessage("las contraseñas no son identicas");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        }
        else{
            AsyncHttpClient client=new AsyncHttpClient();
            RequestParams params=new RequestParams();
            params.add("firstname",firstName.getText().toString());
            params.add("surname",lastName.getText().toString());
            params.add("ci",ci.getText().toString());
            params.add("email",email.getText().toString());
            params.add("phone",phone.getText().toString());
            params.add("password",password.getText().toString());
            final String emailuser=email.getText().toString();
            final String passworduser=password.getText().toString();
            RC=getApplicationContext();
            client.post(Data.HOST + Data.REGISTER_CLIENT, params, new JsonHttpResponseHandler(){

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                    if(response.has("_id")){
                        AsyncHttpClient client= new AsyncHttpClient();
                        RequestParams params=new RequestParams();
                        params.add("email",emailuser);
                        params.add("password",passworduser);

                        client.post(Data.HOST+Data.LOGIN,params,new JsonHttpResponseHandler(){
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                                try{
                                    String token=response.getString("token");
                                    Data.TOKEN="data "+token;
                                    AlertDialog alertDialog = new AlertDialog.Builder(RegisterClient.this).create();
                                    alertDialog.setTitle("SERVER RESPONSE");
                                    alertDialog.setMessage("Registro Exitoso!!!");
                                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",new DialogInterface.OnClickListener(){

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"¡DESEA REGISTRAR UN RESTAURANTE?",new DialogInterface.OnClickListener(){

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent rrestaurant=new Intent(RC,RegisterRestaurant.class);
                                            startActivity(rrestaurant);
                                            dialog.dismiss();
                                        }
                                    });
                                    alertDialog.show();
                                }catch(Exception e){
                                    e.printStackTrace();
                                }

                            }
                        });

                    }
                    else{

                    }
                }
            });
        }*/
    }
}
