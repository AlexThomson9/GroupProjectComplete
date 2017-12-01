package com.example.alex.groupprojectcomplete;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import static com.example.alex.groupprojectcomplete.R.id.checkBox;

public class SellBook extends AppCompatActivity implements View.OnClickListener{
    private static final int REQUEST_CODE = 0 ;
    private static final String TAG = "" ;
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

        CheckBox meme = (CheckBox)this.findViewById(R.id.checkBox);
        meme.setOnClickListener(this);


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case REQUEST_CODE:
                    if (resultCode == Activity.RESULT_OK) {
                        //data gives you the image uri. Try to convert that to bitmap
                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Log.e(TAG, "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception in onActivityResult : " + e.getMessage());
        }
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
        if(v.getId() == checkBox){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_CODE);


        }



    }
}
