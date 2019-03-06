package com.example.cpshome.navagationbar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cpshome.navagationbar.R;
import com.example.cpshome.navagationbar.sql.DatabaseHelper2;
import com.example.cpshome.navagationbar.sql.DatabaseHelper2;

import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Observer;



public class QuizActivity extends AppCompatActivity {

    List<Question> quesList;

    int score=0;

    int qid=0;
// Sets Score
    Question currentQ;

    TextView txtQuestion;

    RadioButton rda, rdb, rdc;

    Button butNext;

    //

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);

        DatabaseHelper2 db=new DatabaseHelper2(this);

        quesList=db.getAllQuestions();

        currentQ=quesList.get(qid);

        txtQuestion=(TextView)findViewById(R.id.textView1);

        rda=(RadioButton)findViewById(R.id.radio0);

        rdb=(RadioButton)findViewById(R.id.radio1);

        rdc=(RadioButton)findViewById(R.id.radio2);

        butNext=(Button)findViewById(R.id.button1);

        setQuestionView();

        butNext.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);



                if (grp.getCheckedRadioButtonId() == -1){

                    return;

                }



                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());



                grp.clearCheck();

                //Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());



                if(currentQ.getANSWER().equals(answer.getText()))

                {

                    score++;

                    Log.d("score", "Your score"+score);

                }

                if(qid<5){

                    currentQ=quesList.get(qid);

                    setQuestionView();

                }else{

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

    private void setQuestionView()

    {

        txtQuestion.setText(currentQ.getQUESTION());

        rda.setText(currentQ.getOPTA());

        rdb.setText(currentQ.getOPTB());

        rdc.setText(currentQ.getOPTC());

        qid++;

    }

}