package com.example.alex.groupprojectcomplete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static com.example.alex.groupprojectcomplete.DBHandler.DB_NAME;
import static com.example.alex.groupprojectcomplete.DBHandler.TB_NAME;

/**
 * Created by Alex on 21/11/2017.
 */

public class DatabaseUtility {
    SQLiteDatabase myDB;

    public DatabaseUtility(Context con){
        DBHandler db = new DBHandler(con);
        myDB = db.getWritableDatabase();
        //  myDB = db.getReadableDatabase();

    }
    public ArrayList<String> getTextbookviaModule() {

        List<String> textbookviaModule = new ArrayList<String>();
        Cursor cursor = null;
        String countQuery = "SELECT * FROM " + DB_NAME + " CROSS JOIN Selling WHERE module = '"+ BuySearch.ModuleNumber + "' ";
        try {
            cursor = myDB.rawQuery(countQuery, null);
        }catch (SQLException e){
            e.printStackTrace();
        }while(cursor.moveToNext()){

            textbookviaModule.add(cursor.getString(1));
            textbookviaModule.add(cursor.getString(2));
            textbookviaModule.add(cursor.getString(7));
        }  cursor.close();
// return count
        return (ArrayList<String>)textbookviaModule;
    }


    public ArrayList<String> getTextbookviaName()
    {
        List<String> textbookviaName = new ArrayList<String>();
        Cursor cursor = null;
        String countQuery = "SELECT * FROM " + DB_NAME + " CROSS JOIN Selling WHERE BookInfo.name = '"+ BuySearch.BookName + "' ";
        try {
            cursor = myDB.rawQuery(countQuery, null);
        }catch (SQLException e){
            e.printStackTrace();
        }if(cursor.moveToNext()){
            textbookviaName.add(cursor.getString(1));
            textbookviaName.add(cursor.getString(2));
            textbookviaName.add(cursor.getString(7));
        }  cursor.close();

// return count
        return (ArrayList<String>)textbookviaName;
    }

    public ArrayList<String> getSeller(){
        List<String> book = new ArrayList<String>();
        Cursor cur = null;


      //  String[] rows = new String[] {"isbn", "name", "module", "Condition", "Price"};
        String Qry = "SELECT name FROM BookInfo CROSS JOIN Selling WHERE BookInfo.ISBN = Selling.ISBN";

        try {
            cur = myDB.rawQuery(Qry, null);
        }catch (SQLException e){
            e.printStackTrace();
        }
        while (!cur.isAfterLast()){
         /*   book.add(cur.getString(1));
            book.add(cur.getString(2));
            book.add(cur.getString(3));
            book.add(cur.getString(4));
            book.add(cur.getString(5));
            book.add(cur.getString(6));
            book.add(cur.getString(7));
*/
         book.add(cur.getString(0));
            cur.moveToNext();
        }
        return (ArrayList<String>)book;
    }
    public String BookNumber;

    public ArrayList<String> validate(){
        List<String> part1 = new ArrayList<String>();
        List<String> part2 = new ArrayList<String>();
        Cursor curs = null;

        if (BuySearch.ModuleNumber.length() != 0)
        {
            String qry = " SELECT ISBN FROM BookInfo WHERE module =  '" + BuySearch.ModuleNumber + "'";
            try
            {
                curs = myDB.rawQuery(qry, null);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            while(curs.moveToNext())
            {
                part1.add(curs.getString(0));
                BookNumber = part1.get(0);
            }
           // curs.close();
            if(part1.get(0) != null)
            {
                String ISBN = part1.get(0);
                part1.clear();
                String qry2 = "SELECT uID FROM Selling WHERE  ISBN =  '" + ISBN + "'" ;
                try
                {
                    curs = myDB.rawQuery(qry2, null);
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
                while(curs.moveToNext())
                {
                    part2.clear();
                    part2.add(curs.getString(0));
                }
            }

        }
        else if (BuySearch.BookName.length() != 0)
        {
            String qry = " SELECT ISBN FROM BookInfo WHERE name =  '" + BuySearch.BookName + "'";
            try
            {
                curs = myDB.rawQuery(qry, null);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            while(curs.moveToNext())
            {
                part1.add(curs.getString(0));
                BookNumber = part1.get(0);

            }
            curs.close();
            if(part1.get(0) != null)
            {
                String ISBN = part1.get(0);
                part1.clear();
                String qry2 = "SELECT uID FROM Selling WHERE  ISBN =  '" + ISBN + "'" ;
                try
                {
                    curs = myDB.rawQuery(qry2, null);
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
                while(curs.moveToNext())
                {
                    part2.clear();
                    part2.add(curs.getString(0));
                }
            }
        }
        return (ArrayList<String>)part2;
    }

    public ArrayList<String> getSellerPart1(){
        List<String> seller = new ArrayList<String>();
        Cursor get = null;


        String userID = validate().get(0);
        String sql = "SELECT * FROM Selling WHERE uID = '" + userID + "'";

        try{

            get = myDB.rawQuery(sql, null);

        }catch (SQLException e){


            e.printStackTrace();
        }while(get.moveToNext()){


            seller.add(get.getString(0));
            seller.add(get.getString(1));
            seller.add(get.getString(2));
            seller.add(get.getString(3));
        }

            return (ArrayList<String>)seller;
    }


    public ArrayList<String> getSellerPart2(){
        List<String> info = new ArrayList<String>();
        Cursor cur = null;

        String ISBN = getSellerPart1().get(1);
        String sql = "SELECT name, Module FROM BookInfo WHERE ISBN = '" + ISBN + "'";


        try{

            cur = myDB.rawQuery(sql, null);


        }catch (SQLException e){



            e.printStackTrace();
        }while(cur.moveToNext()){
            info.add(cur.getString(0));
            info.add(cur.getString(1));

        }
        return (ArrayList<String>)info;
    }

    public ArrayList<String> getLink(){
        List<String> link = new ArrayList<String>();
        Cursor cur = null;

        String sql = "SELECT name, module , link FROM BookInfo CROSS JOIN Selling WHERE ISBN =  '" + BookNumber + "'";
        try{


            cur = myDB.rawQuery(sql, null);

        }catch (SQLException e){



            e.printStackTrace();
        }while(cur.moveToNext()){

            link.add(cur.getString(0));
            link.add(cur.getString(1));
            link.add(cur.getString(3));


        }
        return (ArrayList<String>)link;
    }

}
