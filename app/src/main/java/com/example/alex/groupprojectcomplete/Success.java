package com.example.alex.groupprojectcomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Success extends AppCompatActivity {
    DatabaseUtility databaseStuff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        databaseStuff = new DatabaseUtility(this);


        TextView book;
        book = (TextView)this.findViewById(R.id.textView6);
        book.setText(databaseStuff.getSellerTestMethod().toString());

    }
}
