package com.example.alex.groupprojectcomplete;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SellBook extends AppCompatActivity implements View.OnClickListener{
    DatabaseUtility databaseStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_book);
        databaseStuff = new DatabaseUtility(this);
        Button Update;
        Update = (Button)this.findViewById(R.id.sell);
        Update.setOnClickListener(this);

        Button BuyButton = (Button)this.findViewById(R.id.buy_button);
        BuyButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        EditText BookNo, Cond, price;
        BookNo = (EditText)this.findViewById(R.id.bookNo);
        Cond = (EditText)this.findViewById(R.id.Condit);
        price = (EditText)this.findViewById(R.id.price);
        String BookID = BookNo.getText().toString();
        String Condit = Cond.getText().toString();
        int Cost = price.getText().length();





        ContentValues sellbook = new ContentValues();
        sellbook.put("uID", 3);
        sellbook.put("ISBN",BookID);
        sellbook.put("Condition",Condit);
        sellbook.put("Price",Cost);

        databaseStuff.myDB.insert("Selling", null, sellbook);

        if(v.getId() == R.id.sell){
            AlertDialog.Builder builder = new AlertDialog.Builder(SellBook.this);
            builder.setMessage("Listed Successfully").setNegativeButton("close", null).create().show();

        } else if(v.getId() == R.id.buy_button){

            Intent go;
            go = new Intent(this, BuySearch.class);
            startActivity(go);
        }

    }
}
