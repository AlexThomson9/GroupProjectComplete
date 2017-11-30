package com.example.alex.groupprojectcomplete;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static EditText etName;
    static EditText etPassword;
    DatabaseUtility databaseStuff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseStuff = new DatabaseUtility(this);


        Button b10 = (Button)this.findViewById(R.id.button10);
        b10.setOnClickListener(this);






        etName = (EditText)this.findViewById(R.id.etPassword);
        etPassword = (EditText)this.findViewById(R.id.etPassword);

        final Button login_button = (Button)this.findViewById(R.id.button7);
        final Button register_button = (Button)this.findViewById(R.id.button8);

                register_button.setOnClickListener(this);
                login_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final String username = etName.getText().toString();
        final String password = etPassword.getText().toString();



        if(v.getId() == R.id.button7){

            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String Response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(Response);
                        boolean success = jsonResponse.getBoolean("success");
                       // jsonResponse.getJSONArray();
                        if(success){
                            int user_id = jsonResponse.getInt("user_id");
                            Intent in = new Intent(MainActivity.this, HomeActivity.class);
                            in.putExtra("user_id", user_id);
                         //   in.putExtra("username", username);
                            startActivity(in);
                        }
                        else
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("LoginFailed").setNegativeButton("Retry", null).create().show();
                        }
                    }catch (JSONException e){
                        e.printStackTrace();
                    }




                }
            };
            LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            queue.add(loginRequest);


        }else if (v.getId() == R.id.button8){

            Intent in = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(in);
        }else if (v.getId() == R.id.button10){

            Intent go = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(go);

        }
    }
}
