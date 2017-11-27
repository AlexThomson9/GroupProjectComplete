package com.example.alex.groupprojectcomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BuyResults extends AppCompatActivity implements View.OnClickListener{
    DatabaseUtility databaseStuff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_results);
        databaseStuff = new DatabaseUtility(this);
        TextView text;

        text = (TextView)this.findViewById(R.id.textView4);

       // text.setText(databaseStuff.getTextbook().toString());

        TextView book;
        book = (TextView)this.findViewById(R.id.textView5);
       // book.setText(databaseStuff.getSeller().toString());
        // user databaseStuff.getSeller().get(1) to get 2nd value and so forth

            //String instock = databaseStuff.getSeller().get(2).toString();

          //  String test = databaseStuff.validate().toString();

        Log.d ("aaaaa", databaseStuff.validate().toString());
       if(databaseStuff.validate().get(0) == null){

          //  book.setText(databaseStuff.getSeller().toString());
            text.setText(databaseStuff.getTextbookviaModule().get(0));
           // book.setText(databaseStuff.getTextbookviaModule().get(1));
            //book.setText(databaseStuff.getTextbookviaName().toString());
           //book.setText(databaseStuff.validate().get(0));

           book.setText("yaya i work ");







        }else if(databaseStuff.validate().get(0) != null) {

      //     book.setText(databaseStuff.validate().toString());
          // book.setText(test);
           book.setText(databaseStuff.validate().toString());
         //  book.setText(instock);
       }



    }

    @Override
    public void onClick(View v) {

    }
}
