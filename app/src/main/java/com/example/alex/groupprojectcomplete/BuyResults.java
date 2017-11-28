package com.example.alex.groupprojectcomplete;

import android.support.constraint.ConstraintLayout;
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

        text = (TextView)this.findViewById(R.id.textView19) ;

        ConstraintLayout Result1 = (ConstraintLayout)this.findViewById(R.id.Result1);
        ConstraintLayout Result2 = (ConstraintLayout)this.findViewById(R.id.Result2);
        ConstraintLayout Result3 = (ConstraintLayout)this.findViewById(R.id.Result3);
        View line1 = (View)this.findViewById(R.id.view5);
        View line2 = (View)this.findViewById(R.id.view7);


        Result1.setVisibility(View.INVISIBLE);
        Result2.setVisibility(View.INVISIBLE);
        Result3.setVisibility(View.INVISIBLE);
        line1.setVisibility(View.INVISIBLE);
        line2.setVisibility(View.INVISIBLE);


        TextView Title = (TextView)this.findViewById(R.id.c1Title);
        TextView Condition = (TextView)this.findViewById(R.id.c1Condition);
        TextView Price = (TextView)this.findViewById(R.id.c1Price);
        TextView P_Title = (TextView)this.findViewById(R.id.c1PriceTitle);
        TextView C_Title = (TextView)this.findViewById(R.id.c1ConditionTitle);




        if(databaseStuff.validate().get(0) == null)
        {
            if (BuySearch.ModuleNumber.length() != 0 )
            {
                int Tvm = databaseStuff.getTextbookviaModule().size();
                String test1 = String.valueOf(Tvm);
                Log.d("meme",test1 );
               text.setText(databaseStuff.getLink().toString());

                Log.d("dank", databaseStuff.BookNumber);

            }
            else if(BuySearch.BookName.length() != 0 )
            {
                int Tvn = databaseStuff.getTextbookviaName().size();
                String test2 = String.valueOf(Tvn);
                Log.d("memee",test2 );

                if (Tvn <= 6){


                    String memes = databaseStuff.getLink().toString();
                    Log.d("guess", memes);
                    Result1.setVisibility(View.VISIBLE);

                    C_Title.setText("Module Number");
                    P_Title.setText("Link to Purchaser");
                    Title.setText(databaseStuff.getLink().get(0).toString());
                    Condition.setText(databaseStuff.getLink().get(1).toString());
                    Price.setText(databaseStuff.getLink().get(2).toString());

                }

              //  text.setText(databaseStuff.getLink().toString());




            }
        }
        else if (databaseStuff.validate().get(0) != null)
        {
            int lnk = databaseStuff.getLink().size();
            String test3 = String.valueOf(lnk);
            Log.d("meme33",test3 );
        }





        TextView book;
        //book = (TextView)this.findViewById(R.id.textView5);
       // book.setText(databaseStuff.getSeller().toString());
        // user databaseStuff.getSeller().get(1) to get 2nd value and so forth

            //String instock = databaseStuff.getSeller().get(2).toString();

          //  String test = databaseStuff.validate().toString();

        Log.d ("aaaaa", databaseStuff.validate().toString());
      /* if(databaseStuff.validate().get(0) == null){

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
*/


    }

    @Override
    public void onClick(View v) {

    }
}
