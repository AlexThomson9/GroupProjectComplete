package com.example.alex.groupprojectcomplete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseUtility databaseStuff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        databaseStuff = new DatabaseUtility(this);


        Button b1 = (Button)this.findViewById(R.id.button);
        b1.setOnClickListener(this);

        Button b2 = (Button)this.findViewById(R.id.button2);
        b2.setOnClickListener(this);
        //

    }

    @Override
    public void onClick(View v) {

        TextView memes;

        memes = (TextView)this.findViewById(R.id.textView);


        if(v.getId() == R.id.button2){

            Intent inn;
            startActivity(inn = new Intent(HomeActivity.this, SellBook.class));


        }else if (v.getId() == R.id.button){

            Intent in;

            startActivity(in = new Intent(HomeActivity.this, BuySearch.class));

        }

    }
}
