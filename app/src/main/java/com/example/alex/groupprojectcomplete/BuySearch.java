package com.example.alex.groupprojectcomplete;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuySearch extends AppCompatActivity implements View.OnClickListener {
    DatabaseUtility databaseStuff;
    static EditText ModuleNo;
    static EditText B_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_search);
        databaseStuff = new DatabaseUtility(this);
        Button Search;
        Search = (Button)this.findViewById(R.id.button6);
        Search.setOnClickListener(this);

    }

public static String ModuleNumber;
public static String BookName;
    @Override
    public void onClick(View v) {


        ModuleNo = (EditText)this.findViewById(R.id.editText);
        B_name = (EditText)this.findViewById(R.id.editText2);
        if(v.getId() == R.id.button6){

            String name = B_name.getText().toString();
            String module = ModuleNo.getText().toString();


            BookName = name;
            ModuleNumber = module;

            if(ModuleNo.getText().toString() == null){







            }else if (B_name.getText().toString() == null){




            }



            Intent in;
            startActivity(in = new Intent(BuySearch.this, BuyResults.class));
            //memes.setText(databaseStuff.getTextbook().toString());
        }







    }






}
