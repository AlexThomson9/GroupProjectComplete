package com.example.alex.groupprojectcomplete;

import android.content.ContentValues;
import android.content.Intent;
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

    public static String ISBN;
    public static String Condition;
    public static int Price;

    @Override
    public void onClick(View v) {

        EditText BookNo, Cond, price;





        BookNo = (EditText)this.findViewById(R.id.bookNo);
        Cond = (EditText)this.findViewById(R.id.Condit);
        price = (EditText)this.findViewById(R.id.price);




        String BookID = BookNo.getText().toString();
        String Condit = Cond.getText().toString();
        int Cost = price.getText().length();

        ISBN = BookID;
        Condition = Condit;
        Price = Cost;





        ContentValues sellbook = new ContentValues();
        sellbook.put("uID", 3);
        sellbook.put("ISBN",ISBN);
        sellbook.put("Condition",Condition);
        sellbook.put("Price",Price);

        databaseStuff.myDB.insert("Selling", null, sellbook);

        if(v.getId() == R.id.sell){

            Intent go;

            startActivity(go = new Intent(SellBook.this, Success.class));

        } else if(v.getId() == R.id.buy_button){

            Intent go;
            go = new Intent(this, BuySearch.class);
            startActivity(go);
        }

    }
}
