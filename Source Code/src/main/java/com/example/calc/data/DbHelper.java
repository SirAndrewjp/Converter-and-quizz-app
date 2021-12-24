package com.example.calc.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.calc.Question;

import static com.example.calc.data.QuizContract.MovieEntry.KEY_ANSWER;
import static com.example.calc.data.QuizContract.MovieEntry.KEY_ID;
import static com.example.calc.data.QuizContract.MovieEntry.KEY_OPTA;
import static com.example.calc.data.QuizContract.MovieEntry.KEY_OPTB;
import static com.example.calc.data.QuizContract.MovieEntry.KEY_OPTC;
import static com.example.calc.data.QuizContract.MovieEntry.KEY_OPTD;
import static com.example.calc.data.QuizContract.MovieEntry.KEY_QUES;
import static com.example.calc.data.QuizContract.MovieEntry.TABLE_QUEST;


public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 6;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name

    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT ,"+KEY_OPTD+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("How do you write the decimal number 335 in Roman numerals?", "a) CCCXXXV", "b) XXXCCD", "c) DVI", "d) CCCIIV", "a) CCCXXXV");
        this.addQuestion(q1);
        Question q2=new Question("How do you write the decimal number 949 in Roman numerals?","a) XXVI","b) CMIX","c) CMXLIX","d) CCCIIV","c) CMXLIX");
        this.addQuestion(q2);
        Question q3=new Question("How do you write the decimal number 1441 in Roman numerals?","a) CDDIIV","b) MCDXLI","c) MCDXXV","d) MCDXIV","b) MCDXLI" );
        this.addQuestion(q3);
        Question q4=new Question("How do you write (10001001)\u2082 in Roman numerals?","a) CCCXXV","b) CXXXVII","c) XLVII","d) CMXIV","b) CXXXVII");
        this.addQuestion(q4);
        Question q5=new Question("How do you write (2F)\u2081\u2086 in Roman numerals?","a) XXILV","b) XLVII","c) XLLVI","d) XIV","b) XLVII");
        this.addQuestion(q5);
        Question q6=new Question("How do you write (136)\u2088 in Roman numerals?","a) CXLV","b) CXI","c) XCIV","d) CIV","c) XCIV");
        this.addQuestion(q6);
        Question q7=new Question("How do you write (F2A1)\u2081\u2086 as a binary number?","a) 1111001010100001","b) 1111000010100111","c) 1111011010111001","d) 1111001010110010","a) 1111001010100001");
        this.addQuestion(q7);
        Question q8=new Question("How do you write 7261\u2088 as a binary number?","a) 1111000011100001","b) 111010111101","c) 101010110001","d) 111010110001","d) 111010110001");
        this.addQuestion(q8);
        Question q9=new Question("How do you write the binary number 1111001010100011 as an hexadecimal number?","a) 0xF2A3","b) 0xF3A8","c) 0x2A1","d) 0xF2A","a) 0xF2A3");
        this.addQuestion(q9);
        Question q10=new Question( "How do you write the binary number 111010110001 in the octal base?","a) 7211","b) 7261","c) 7256","d) 8219","b) 7261");
        this.addQuestion(q10);
        Question q11=new Question("What is the result of 235 + 176 (all in decimal base)?","a) 402","b) 401","c) 411","d) 421","c) 411");
        this.addQuestion(q11);
        Question q12=new Question("What is the result of 235 - 176 (all in decimal base)?","a) 61","b) 21","c) 49","d) 59","d) 59");
        this.addQuestion(q12);
        Question q13=new Question("What is the result of 235 + 176 (all in octal base)?","a) 433","b) 421","c) 389","d) 411","a) 433");
        this.addQuestion(q13);
        Question q14=new Question("What is the result of 433 - 176 (all in octal base)?","a) 523","b) 253","c) 235","d) 257","c) 235");
        this.addQuestion(q14);
        Question q15=new Question("What is the result of 100110 + 011011 (all in binary base)?","a) 00110001","b) 10011011","c) 1000001","d) 1000111","c) 1000001");
        this.addQuestion(q15);
        Question q16=new Question("What is the result of 100110 - 11011 (all in binary base)?","a) 1011","b) 0101","c) 1100","d) 1010","a) 1011");
        this.addQuestion(q16);
        Question q17=new Question("What is the result of 10110 x 101 (all in binary base)?","a) 1101011","b) 1001110","c) 1100010","d) 1101110","d) 1101110");
        this.addQuestion(q17);
        Question q18=new Question("What is the result of 10100 / 100 (all in binary base)?","a) 111","b) 1010","c) 1110","d) 101","d) 101");
        this.addQuestion(q18);
        Question q19=new Question("What is the half of the binary number 10110010? Express the result as a binary number.","a) 1011001","b) 1100010","c) 1100100","d) 1001001","a) 1011001");
        this.addQuestion(q19);
        Question q20=new Question("What is the double of the binary number 1011001? Express the result as a binary number.","a) 10010110","b) 10110010","c) 10110000","d) 10111010","b) 10110010");
        this.addQuestion(q20);
        Question q21=new Question("What is the result of 326 x 12 (all in octal base)?","a) 4134","b) 4214","c) 4231","d) 3912","a) 4134");
        this.addQuestion(q21);
        Question q22=new Question("What is the result of 4134 / 12 (all in octal base)?","a) 344","b) 326","c) 327","d) 316"," b)326");
        this.addQuestion(q22);
        Question q23=new Question("How do you write the decimal number 14.625 in binary notation?","a) 1100.011","b) 1000.101","c) 1110.101","d) 1110.111","c) 1110.101");
        this.addQuestion(q23);
        Question q24=new Question("How do you write the binary number 1010.11 in decimal notation?","a) 10.75","b) 10.625","c) 10.65","d) 14.25","a) 10.75");
        this.addQuestion(q24);
        Question q25=new Question("How do you write the octal number 5274\u2088 in hexadecimal notation?","a) 0x2A4","b) 0x1B9","c) 0x123","d) 0xABC","d) 0xABC");
        this.addQuestion(q25);
        Question q26=new Question("How do you write the hexadecimal number 0xAAA in octal notation?","a) 5252\u2088","b) 2222\u2088","c) 7675\u2088","d) 5767\u2088","a) 5252\u2088");
        this.addQuestion(q26);
        Question q27=new Question("How do you write the octal number (777)\u2088 in hexadecimal notation?","a) 0x1F","b) 0xFF","c) 0xFFF","d) 0x1FF","d) 0x1FF");
        this.addQuestion(q27);
        Question q28=new Question("The decimal number 16\u2074 can be written in hexadecimal notation as:","a) 0xFFFF","b) 0xF0F0","c) 0xF000","d) 0xFF00","c) 0xF000");
        this.addQuestion(q28);
        Question q29=new Question("What is the result of the operation 1 + 2 + 4 + 8 + 16 + 32 + 64 + 128 + 256 + 512 (all in decimal notation)?","a) 1024","b) 1023","c) 1025","d) 2024","b) 1023");
        this.addQuestion(q29);
        Question q30=new Question("What is the result of the operation 1 + 10 + 100 + 1000 + 10000 + 100000 + 1000000 (all in binary notation)?","a) 1111111","b) 111111","c) 10000000","d) 1000000","a) 1111111");
        this.addQuestion(q30);
        Question q31=new Question("What is the result of the operation 1 + 11111 (all in binary notation)?","a) 10000","b) 100000","c) 1000000","d) 111111","b) 100000");
        this.addQuestion(q31);
        Question q32=new Question("What is the result of the operation 11111 + 11111 (all in binary notation)?","a) 111110","b) 1000000","c) 100000","d) 111111","a) 111110");
        this.addQuestion(q32);
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
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;

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
                quest.setOPTD(cursor.getString(6));
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