package com.example.alex.groupprojectcomplete;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.*;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Button register_button = (Button)this.findViewById(R.id.button9);

        register_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final EditText etName = (EditText)this.findViewById(R.id.etName);
        final EditText etPassword= (EditText)this.findViewById(R.id.etPassword);
        final EditText etUsername = (EditText)this.findViewById(R.id.etUsername);


        final String name = etName.getText().toString();
        final String username = etUsername.getText().toString();
        final String password = etPassword.getText().toString();


        if (v.getId() == R.id.button9){
         /*   Intent meme;
            meme = new Intent(RegisterActivity.this, HomeActivity.class);
            startActivity(meme);*/

        Response.Listener<String> responseListener = new Response.Listener<String>(){


                    public void onResponse(String Response){
                        try {

                            //response = "{\"response\":}";
                            JSONObject jsonResponse = new JSONObject(Response);


                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                RegisterActivity.this.startActivity(intent);

                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed").setNegativeButton("Retry",null).create().show();



                            }


                        }catch (JSONException e){


                            e.printStackTrace();
                        }


                    }


                };


                RegisterRequest registerRequest = new RegisterRequest(name, username, password, responseListener);

        RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);


        queue.add(registerRequest);



    }
}
}
