package com.example.alex.groupprojectcomplete;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 21/11/2017.
 */

public class DBHandler extends SQLiteOpenHelper {



    public static final String DB_NAME = "BookInfo";
    public static final String TB_NAME = "Selling";
    public static final int DB_VERSION = 1;


            public DBHandler(Context myContext){

                super(myContext, DB_NAME, null, DB_VERSION);

            }


    public void onConfigure(SQLiteDatabase myDB) {

        myDB.setForeignKeyConstraintsEnabled(true);
    }




    @Override
    public void onCreate(SQLiteDatabase myDB) {


        String sql, sq2, sq3, sq4;
        ContentValues TbInfo, Sell, test;
        sql = "CREATE TABLE " + DB_NAME +
                "(ISBN INTEGER NOT NULL, name TEXT, module TEXT, PRIMARY KEY(name , module));";
        sq2 = "CREATE TABLE " + TB_NAME + "(uID INTEGER , ISBN INTEGER NOT NULL" +
                ", Condition TEXT ," +
                " price INT , link TEXT ,PRIMARY KEY(uID, ISBN)); ";

        myDB.execSQL(sql);



        TbInfo = new ContentValues();
        TbInfo.put("ISBN", "123443");
        TbInfo.put("name", "Biology");
        TbInfo.put("module", "CM3202");
        myDB.insert(DB_NAME, null, TbInfo);
        TbInfo.put("ISBN","128782");
        TbInfo.put("name", "Physics");
        TbInfo.put("module", "CM3202");
        myDB.insert(DB_NAME, null, TbInfo);
        TbInfo.put("ISBN","345323");
        TbInfo.put("name", "Chemistry");
        TbInfo.put("module", "CM3202");
        myDB.insert(DB_NAME, null, TbInfo);
        TbInfo.put("ISBN","352234");
        TbInfo.put("name", "Thermodynamics");
        TbInfo.put("module", "CM1234");
        myDB.insert(DB_NAME, null, TbInfo);
        TbInfo.put("ISBN","372142");
        TbInfo.put("name", "Matlab");
        TbInfo.put("module", "CM1234");
        myDB.insert(DB_NAME, null, TbInfo);
        TbInfo.put("ISBN","375345");
        TbInfo.put("name", "Statistics");
        TbInfo.put("module", "CM1234");
        myDB.insert(DB_NAME, null, TbInfo);
        myDB.execSQL(sq2);




        Sell = new ContentValues();

    /*    Sell.put("uID", 123);
        Sell.put("ISBN", "123443");
        Sell.put("Condition", "Mint");
        Sell.put("price", 10);


        myDB.insert(TB_NAME, null, Sell);
*/


        ContentValues stock = new ContentValues();
        stock.put("ISBN", "123443");
        stock.put("link", "HTTP://www.thisisatest.com");
        myDB.insert(TB_NAME, null, stock);
        stock.put("ISBN", "128782");
        stock.put("link", "HTTP://www.memes.com");
        myDB.insert(TB_NAME, null, stock);
        stock.put("ISBN", "345323");
        stock.put("link", "HTTP://www.comrade.com");
        myDB.insert(TB_NAME, null, stock);
        stock.put("ISBN", "352234");
        stock.put("link", "HTTP://www.scheckle.ru");
        myDB.insert(TB_NAME, null, stock);
        stock.put("ISBN", "372142");
        stock.put("link", "HTTP://www.reddit.com");
        myDB.insert(TB_NAME, null, stock);
        stock.put("ISBN", "375345");
        stock.put("link", "HTTP://www.geoguessr.co.uk");
        myDB.insert(TB_NAME, null, stock);




      //      sq4 = "PRAGMA automatic_index=off;";
       // sq4 = "CREATE INDEX memes ON BookInfo(name, module);";
       /* sq3 = "SELECT * FROM BookInfo JOIN Selling ON Selling.ISBN WHERE Selling.ISBN = BookInfo.ISBN" +
                " JOIN Selling ON BookInfo.name WHERE Selling.ISBN = BookInfo.ISBN " +
                "JOIN Selling ON Selling.module = BookInfo.module WHERE Selling.ISBN = BookInfo.ISBN;";
        */
      //  String sq5;
       // sq5 = "SELECT * FROM BookInfo CROSS JOIN Selling WHERE BookInfo.ISBN = Selling.ISBN;";




     //   try {
      //      myDB.execSQL(sq4);
           // myDB.execSQL(sq3);
      //      myDB.rawQuery(sq5, null);

      //  }catch (SQLException e){


     //       e.printStackTrace();
     //   }
      /*  String name = "";
        String module = "";
        Cursor cur = null;
        try
        {

            cur = myDB.rawQuery(sq3, null);


        }catch (SQLException e){

        e.printStackTrace();

        }while(cur.moveToNext()){

            name = cur.getString(0);
            module = cur.getString(1);



        }*/





       /* test = new ContentValues();
        test.put("name",name);
        test.put("module", module);

        myDB.insert(TB_NAME, null, test);
*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

      //  db.execSQL("DROP TABLE IF EXISTS " + TB_NAME);


    }







}
