package com.example.alex.groupprojectcomplete;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class BuyResults extends AppCompatActivity implements View.OnClickListener{
    DatabaseUtility databaseStuff;
    TextView R1_Title, R1_Condition, R1_Price, R1_C_Title, R1_P_Title
            ,R2_Title, R2_Condition, R2_Price, R2_C_Title, R2_P_Title
            ,R3_Title, R3_Condition, R3_Price, R3_C_Title, R3_P_Title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_results);
        databaseStuff = new DatabaseUtility(this);
        TextView text;

        text = (TextView) this.findViewById(R.id.textView19);

        ConstraintLayout Result1 = (ConstraintLayout) this.findViewById(R.id.Result1);
        ConstraintLayout Result2 = (ConstraintLayout) this.findViewById(R.id.Result2);
        ConstraintLayout Result3 = (ConstraintLayout) this.findViewById(R.id.Result3);
        View line1 = (View) this.findViewById(R.id.view5);
        View line2 = (View) this.findViewById(R.id.view7);

        ImageButton R_1 = (ImageButton) this.findViewById(R.id.imageButton1);
        ImageButton R_2 = (ImageButton) this.findViewById(R.id.imageButton2);
        ImageButton R_3 = (ImageButton) this.findViewById(R.id.imageButton3);

        R_1.setOnClickListener(this);
        R_2.setOnClickListener(this);
        R_3.setOnClickListener(this);

        Result1.setVisibility(View.INVISIBLE);
        Result2.setVisibility(View.INVISIBLE);
        Result3.setVisibility(View.INVISIBLE);
        line1.setVisibility(View.INVISIBLE);
        line2.setVisibility(View.INVISIBLE);


        R1_Title = (TextView) this.findViewById(R.id.c1Title);
        R1_Condition = (TextView) this.findViewById(R.id.c1Condition);
        R1_Price = (TextView) this.findViewById(R.id.c1Price);
        R1_P_Title = (TextView) this.findViewById(R.id.c1PriceTitle);
        R1_C_Title = (TextView) this.findViewById(R.id.c1ConditionTitle);

        R2_Title = (TextView) this.findViewById(R.id.c2Title);
        R2_Price = (TextView) this.findViewById(R.id.textView16);
        R2_Condition = (TextView) this.findViewById(R.id.c2Condition);
        R2_C_Title = (TextView) this.findViewById(R.id.c2ConditionTitle);
        R2_P_Title = (TextView) this.findViewById(R.id.c2PriceTitle);

        R3_Title = (TextView) this.findViewById(R.id.c3Title);
        R3_Price = (TextView) this.findViewById(R.id.textView20);
        R3_Condition = (TextView) this.findViewById(R.id.c3Condition);
        R3_C_Title = (TextView) this.findViewById(R.id.c3ConditionTitle);
        R3_P_Title = (TextView) this.findViewById(R.id.c3PriceTitle);


        if (databaseStuff.validate().get(0) == null) {
            String Mn = "Module Number";
            String LtR = "Link to Retailer";
            if (BuySearch.ModuleNumber.length() != 0) {
                int Tvm = databaseStuff.getTextbookviaModuleTest().size();
                String test1 = String.valueOf(Tvm);
                Log.d("meme", test1);
                text.setText(databaseStuff.getLink().toString());
                Log.d("dank", databaseStuff.BookNumber);
                String testmeme = databaseStuff.getTextbookviaModuleTest().toString();
                Log.d("memee", testmeme);

                if (Tvm >= 3) {
                    Result1.setVisibility(View.VISIBLE);
                    R1_C_Title.setText(Mn);
                    R1_P_Title.setText(LtR);
                    R1_Title.setText(databaseStuff.getTextbookviaModuleTest().get(0));
                    R1_Condition.setText(databaseStuff.getTextbookviaModuleTest().get(1));
                    R1_Price.setText(databaseStuff.getTextbookviaModuleTest().get(2));

                    if (Tvm >= 6) {
                        Result2.setVisibility(View.VISIBLE);
                        line1.setVisibility(View.VISIBLE);
                        R2_C_Title.setText(Mn);
                        R2_P_Title.setText(LtR);
                        R2_Title.setText(databaseStuff.getTextbookviaModuleTest().get(3));
                        R2_Condition.setText(databaseStuff.getTextbookviaModuleTest().get(4));
                        R2_Price.setText(databaseStuff.getTextbookviaModuleTest().get(5));
                        if (Tvm >= 9) {
                            Result3.setVisibility(View.VISIBLE);
                            line2.setVisibility(View.VISIBLE);
                            R3_C_Title.setText(Mn);
                            R3_P_Title.setText(LtR);
                            R3_Title.setText(databaseStuff.getTextbookviaModuleTest().get(6));
                            R3_Condition.setText(databaseStuff.getTextbookviaModuleTest().get(7));
                            R3_Price.setText(databaseStuff.getTextbookviaModuleTest().get(8));
                        }
                    } else {

                    }
                } else {
                }
            } else if (BuySearch.BookName.length() != 0) {

                int Tvm = databaseStuff.getTextbookviaModuleTest().size();
                String memees = String.valueOf(Tvm);
                Log.d("helpme", memees);
                if (Tvm >= 3) {
                    Result1.setVisibility(View.VISIBLE);
                    R1_C_Title.setText(Mn);
                    R1_P_Title.setText(LtR);
                    R1_Title.setText(databaseStuff.getTextbookviaModuleTest().get(0));
                    R1_Condition.setText(databaseStuff.getTextbookviaModuleTest().get(1));
                    R1_Price.setText(databaseStuff.getTextbookviaModuleTest().get(2));

                    if (Tvm >= 6) {
                        Result2.setVisibility(View.VISIBLE);
                        line1.setVisibility(View.VISIBLE);
                        R2_C_Title.setText(Mn);
                        R2_P_Title.setText(LtR);
                        R2_Title.setText(databaseStuff.getTextbookviaModuleTest().get(3));
                        R2_Condition.setText(databaseStuff.getTextbookviaModuleTest().get(4));
                        R2_Price.setText(databaseStuff.getTextbookviaModuleTest().get(5));
                        if (Tvm >= 9) {
                            Result3.setVisibility(View.VISIBLE);
                            line2.setVisibility(View.VISIBLE);
                            R3_C_Title.setText(Mn);
                            R3_P_Title.setText(LtR);
                            R3_Title.setText(databaseStuff.getTextbookviaModuleTest().get(6));
                            R3_Condition.setText(databaseStuff.getTextbookviaModuleTest().get(7));
                            R3_Price.setText(databaseStuff.getTextbookviaModuleTest().get(8));
                        }
                    } else {

                    }
                } else {
                }
                //  text.setText(databaseStuff.getLink().toString());
            }
        } else if (databaseStuff.validate().get(0) != null) {
            int lnk = databaseStuff.getSellingInfoTest().size();
            String test3 = String.valueOf(lnk);
            Log.d("meme33", test3);
            String meeee = databaseStuff.getSellingInfoTest().toString();
            Log.d("testicles", meeee);
            if (BuySearch.ModuleNumber.length() != 0) {
                int meme = databaseStuff.getTextbookviaModuleTest().size();
                String testing = String.valueOf(meme);
                Log.d("testing", testing);
                Log.d("test", databaseStuff.getTextbookviaModuleTest().toString());
                if (lnk >= 3) {
                    Result1.setVisibility(View.VISIBLE);
                    R1_Title.setText(databaseStuff.getSellingInfoTest().get(0));
                    R1_Condition.setText(databaseStuff.getSellingInfoTest().get(1));
                    R1_Price.setText(databaseStuff.getSellingInfoTest().get(2));
                    if (lnk >= 6) {
                        Result2.setVisibility(View.VISIBLE);
                        line1.setVisibility(View.VISIBLE);
                        R2_Title.setText(databaseStuff.getSellingInfoTest().get(3));
                        R2_Condition.setText(databaseStuff.getSellingInfoTest().get(4));
                        R2_Price.setText(databaseStuff.getSellingInfoTest().get(5));
                        if (lnk >= 9) {
                            Result3.setVisibility(View.VISIBLE);
                            line2.setVisibility(View.VISIBLE);
                            R3_Title.setText(databaseStuff.getSellingInfoTest().get(6));
                            R3_Condition.setText(databaseStuff.getSellingInfoTest().get(7));
                            R3_Price.setText(databaseStuff.getSellingInfoTest().get(8));
                        }
                    }
                }
            } else if (BuySearch.BookName.length() != 0) {
                if (lnk >= 3) {
                    Result1.setVisibility(View.VISIBLE);
                    R1_Title.setText(databaseStuff.getSellingInfoTest().get(0));
                    R1_Condition.setText(databaseStuff.getSellingInfoTest().get(1));
                    R1_Price.setText(databaseStuff.getSellingInfoTest().get(2));
                    if (lnk >= 6) {
                        Result2.setVisibility(View.VISIBLE);
                        line1.setVisibility(View.VISIBLE);
                        R2_Title.setText(databaseStuff.getSellingInfoTest().get(3));
                        R2_Condition.setText(databaseStuff.getSellingInfoTest().get(4));
                        R2_Price.setText(databaseStuff.getSellingInfoTest().get(5));
                        if (lnk >= 9) {
                            Result3.setVisibility(View.VISIBLE);
                            line2.setVisibility(View.VISIBLE);
                            R3_Title.setText(databaseStuff.getSellingInfoTest().get(6));
                            R3_Condition.setText(databaseStuff.getSellingInfoTest().get(7));
                            R3_Price.setText(databaseStuff.getSellingInfoTest().get(8));
                        }
                    }
                }
            }
        }
        Log.d("aaaaa", databaseStuff.validate().toString());
    }

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.imageButton1){
            Intent res1 = new Intent(BuyResults.this, BuyBookPage.class);
            String Title = R1_Title.getText().toString();
            String Condition = R1_Condition.getText().toString();
            String Price = R1_Price.getText().toString();
            res1.putExtra("ResultNo", 1);
            res1.putExtra("Title", Title);
            res1.putExtra("Condition", Condition);
            res1.putExtra("Price", Price);
            startActivity(res1);
        }else if(v.getId() == R.id.imageButton2){
            Intent res2 = new Intent(BuyResults.this, BuyBookPage.class);
            String Title = R2_Title.getText().toString();
            String Condition = R2_Condition.getText().toString();
            String Price = R2_Price.getText().toString();
            res2.putExtra("ResultNo", 2);
            res2.putExtra("Title", Title);
            res2.putExtra("Condition", Condition);
            res2.putExtra("Price", Price);
            startActivity(res2);
        }else if(v.getId() == R.id.imageButton3){
            Intent res3 = new Intent(BuyResults.this, BuyBookPage.class);
            String Title = R3_Title.getText().toString();
            String Condition = R3_Condition.getText().toString();
            String Price = R3_Price.getText().toString();
            res3.putExtra("ResultNo", 3);
            res3.putExtra("Title", Title);
            res3.putExtra("Condition", Condition);
            res3.putExtra("Price", Price);
            startActivity(res3);


        }


       // Intent in = new Intent(BuyResults.this, BuyBookPage.class);
        //startActivity(in);



    }
}
