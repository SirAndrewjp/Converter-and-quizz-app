package com.example.calc;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calc.data.DbHelper;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    Vibrator vibrate;
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        vibrate = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        ProgressBar bar= findViewById(R.id.ratingBarquestion);
        bar.setFocusable(false);
        DbHelper db=new DbHelper(this);

        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion= findViewById(R.id.textView1);
        rda= findViewById(R.id.radio0);
        rdb= findViewById(R.id.radio1);
        rdc= findViewById(R.id.radio2);
        rdd= findViewById(R.id.radio3);
        butNext= findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(v -> {
            RadioGroup grp= findViewById(R.id.radioGroup1);
            vibrate.vibrate(100);
            butNext.setEnabled(true);
            rda.setEnabled(true);
            rdb.setEnabled(true);
            rdc.setEnabled(true);
            rdd.setEnabled(true);
            bar.incrementProgressBy(1);
            if (grp.getCheckedRadioButtonId() == -1)
            {
                butNext.setEnabled(false);
                Toast.makeText(getApplicationContext(), "Please select an option", Toast.LENGTH_SHORT).show();
                butNext.setEnabled(true);
            }
            else {
                RadioButton answer = findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());

                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    //set custom toast message for right
                    Toast right = new Toast(getApplicationContext());
                    right.setGravity(Gravity.CENTER, 0,1000);
                    TextView tvright = new TextView(QuizActivity.this);
                    tvright.setBackgroundColor(Color.WHITE);
                    tvright.setTextColor(Color.GREEN);
                    tvright.setTextSize(20);
                    
                    Typeface t = Typeface.create("impact", Typeface.BOLD);
                    tvright.setTypeface(t);
                    tvright.setPadding(10,10,10,10);
                    tvright.setText("Correct!");
                    right.setView(tvright);
                    right.show();
                    //cut toast to a shorter time
                    Handler stoptoast = new Handler();
                    stoptoast.postDelayed(() -> right.cancel(), 4000);

                    //shows in log for debugging purposes
                    Log.d("score", "Your score " + score);
                }
                else{
                    Toast wrong = new Toast(getApplicationContext());
                    wrong.setGravity(Gravity.CENTER, 0,1000);
                    TextView tvwrong = new TextView(QuizActivity.this);
                    tvwrong.setBackgroundColor(Color.WHITE);
                    tvwrong.setTextColor(Color.RED);
                    tvwrong.setTextSize(20);
                    Typeface t = Typeface.create("impact", Typeface.BOLD);
                    tvwrong.setTypeface(t);
                    tvwrong.setPadding(10,10,10,10);
                    tvwrong.setText("\"Incorrect!\"");
                    wrong.setView(tvwrong);
                    wrong.show();
                    //cut toast to a shorter time
                    Handler stoptoast = new Handler();
                    stoptoast.postDelayed(() -> wrong.cancel(), 7000);

                    Toast wronganswer = new Toast(getApplicationContext());
                    wrong.setGravity(Gravity.CENTER, 0,1100);
                    TextView tvwronganswer = new TextView(QuizActivity.this);
                    tvwronganswer.setBackgroundColor(Color.WHITE);
                    tvwronganswer.setTextColor(Color.RED);
                    tvwronganswer.setTextSize(20);
                    Typeface t1 = Typeface.create("impact", Typeface.BOLD);
                    tvwronganswer.setTypeface(t1);
                    tvwronganswer.setPadding(10,10,10,10);
                    tvwronganswer.setText(currentQ.getANSWER());
                    wrong.setView(tvwronganswer);
                    wrong.show();
                    //cut toast to a shorter time
                    Handler stoptoast1 = new Handler();
                    stoptoast1.postDelayed(() -> wronganswer.cancel(), 7000);
                }
                if (qid < 32) {
                    butNext.setEnabled(false);
                    rda.setEnabled(false);
                    rdb.setEnabled(false);
                    rdc.setEnabled(false);
                    rdd.setEnabled(false);
                    currentQ = quesList.get(qid);
                    new Handler().postDelayed(() -> {
                        butNext.setEnabled(true);
                        rda.setEnabled(true);
                        rdb.setEnabled(true);
                        rdc.setEnabled(true);
                        rdd.setEnabled(true);
                        setQuestionView();
                    },3000);
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if(item.getItemId()==R.id.Calculator) {
            Intent i = new Intent(QuizActivity.this, MainActivity.class);
            startActivity(i);
            return false;
        }
        if(item.getItemId()==R.id.Home){
            Intent i = new Intent(QuizActivity.this, HomeScreen.class);
            startActivity(i);
            finish();
            return false;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());
        qid++;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent tohome = new Intent(QuizActivity.this, HomeScreen.class);
        tohome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(tohome);
    }
}