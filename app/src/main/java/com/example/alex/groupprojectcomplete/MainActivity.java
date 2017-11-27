package com.example.alex.groupprojectcomplete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseUtility databaseStuff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseStuff = new DatabaseUtility(this);


        Button b10 = (Button)this.findViewById(R.id.button10);
        b10.setOnClickListener(this);




        final EditText etName = (EditText)this.findViewById(R.id.etUsername);
        final EditText etPassword= (EditText)this.findViewById(R.id.etPassword);

        final Button login_button = (Button)this.findViewById(R.id.button7);
        final Button register_button = (Button)this.findViewById(R.id.button8);

                register_button.setOnClickListener(this);



       //

    }

    @Override
    public void onClick(View v) {



        if(v.getId() == R.id.button10){

            Intent inn = new Intent(MainActivity.this, HomeActivity.class);

            startActivity(inn);


        }else if (v.getId() == R.id.button8){

            Intent in = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(in);
        }




    }
}
