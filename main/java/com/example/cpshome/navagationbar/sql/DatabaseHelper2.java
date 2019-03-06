package com.example.cpshome.navagationbar.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.util.Output;

import com.example.cpshome.navagationbar.activities.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.cpshome.navagationbar.activities.QuizContract.MovieEntry.KEY_ANSWER;
import static com.example.cpshome.navagationbar.activities.QuizContract.MovieEntry.KEY_ID;
import static com.example.cpshome.navagationbar.activities.QuizContract.MovieEntry.KEY_OPTA;
import static com.example.cpshome.navagationbar.activities.QuizContract.MovieEntry.KEY_OPTB;
import static com.example.cpshome.navagationbar.activities.QuizContract.MovieEntry.KEY_OPTC;
import static com.example.cpshome.navagationbar.activities.QuizContract.MovieEntry.KEY_QUES;
import static com.example.cpshome.navagationbar.activities.QuizContract.MovieEntry.TABLE_QUEST;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name

    private static final String DATABASE_NAME = "triviaQuiz";

    // tasks table name



    private SQLiteDatabase dbase;

    public DatabaseHelper2(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        dbase=db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "

                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES

                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "

                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";

        db.execSQL(sql);

        addQuestions();

        //db.close();

    }




    private void addQuestions()
    {
        Question q1=new Question("What is the formula for Capacity Utilisation?", "(Output/Capacity)*100", "(Capacity/Output)*100", "(Input/Capacity)*10" , "(Output/Capacity)*100");
        this.addQuestion(q1);
        Question q2=new Question("What is the formula for Price elasticity of Demand?", "Percentage change in price/Percentage change in quantity demand", "Percentage change in quantity demand/Percentage change in price", "Percentage change in price demand/Percentage change in demand", "Percentage change in price/Percentage change in quantity demand" );
        this.addQuestion(q2);
        Question q3=new Question("What is the formula for Receivables Days?", "(Sales Revenue/Receivables)*365" , "(Receivables/Sales Revenue)*100", "(Receivables/Sales Revenue)*365", "(Receivables/Sales Revenue)*365");
        this.addQuestion(q3);
        Question q4=new Question("What is the formula for Unit Costs?", "Total Costs/Units Output", "Units Output/Total Costs" , "Total Costs/Unit Input", "Total Costs/Units Output" );
        this.addQuestion(q4);
        Question q5=new Question("What is the formula for Profit?", "Total Costs-Total Revenue", "Total Revenue-Total Costs", "Variable Costs-Fixed Costs", "Total Revenue-Total Costs" );
        this.addQuestion(q5);
        Question q6=new Question("What is the formula for Total  Variable Costs?", "Variable Costs per unit-Number of Units Sold", "Number of units Sold-Variable Costs per unit", "Variable Costs per unit-Fixed Costs", "Variable Costs per unit-Numer of Units Sold" );
        this.addQuestion(q6);
        Question q7=new Question("What is the formula for Inventory Turnover?", "Cost of Sales/Stock Held", "Cost of Sales-Cost of average Stock Held", "Cost of Sales/Cost of average Stock held", "Cost of Sales/Cost of average Stock held" );
        this.addQuestion(q7);
        Question q8=new Question("What is the formula for Revenue?", "Selling price per unit*Numbers Sold", "Selling price per unit+Numbers Sold", "Selling price per unit/Numbers Sold", "Selling price per unit*Numbers Sold" );
        this.addQuestion(q8);
        Question q9=new Question("What is the formula for Market Share?", "(Sales/Total Market Size)*365", "(Sales/Total Market Size)*100", "(Total Market Size/Sales)*100", "(Sales/Total Market Size)*100" );
        this.addQuestion(q9);
        Question q10=new Question("What is the formula for Income elasticity of Demand?", "Percentage change in Real Income/Percentage change in quantity demand", "Percentage change in quantity demand/Percentage change in Real Income", "Percentage change in quantity demand/Percentage change in demand", "Percentage change in quantity demand/Percentage change in Real Income" );
        this.addQuestion(q10);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

        // Drop older table if existed

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        // Create tables again

        onCreate(db);

    }

    // Adding new question

    public void addQuestion(Question quest) {

        //SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_QUES, quest.getQUESTION());

        values.put(KEY_ANSWER, quest.getANSWER());

        values.put(KEY_OPTA, quest.getOPTA());

        values.put(KEY_OPTB, quest.getOPTB());

        values.put(KEY_OPTC, quest.getOPTC());

        // Inserting Row

        dbase.insert(TABLE_QUEST, null, values);

    }

    public List<Question> getAllQuestions() {

        List<Question> quesList = new ArrayList<Question>();

        // Select All Query

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST + " ORDER BY "+ "RANDOM()";

        dbase=this.getReadableDatabase();

        Cursor cursor = dbase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {

            do {

                Question quest = new Question();

                quest.setID(cursor.getInt(0));

                quest.setQUESTION(cursor.getString(1));

                quest.setANSWER(cursor.getString(2));

                quest.setOPTA(cursor.getString(3));

                quest.setOPTB(cursor.getString(4));

                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);

            } while (cursor.moveToNext());

            Collections.shuffle(quesList);

        }

        // return quest list

        return quesList;

    }

    public int rowcount()

    {

        int row=0;

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        row=cursor.getCount();

        return row;

    }

}


