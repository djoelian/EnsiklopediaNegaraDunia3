package com.gusty.ensiklopedianegaradunia3.Question;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.gusty.ensiklopedianegaradunia3.R;
import java.util.Random;
public class QuestionActivity extends AppCompatActivity {
    Button answer1,answer2,answer3,answer4;
    TextView score,question;
    private Question mQuestion = new Question();
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionLenght = mQuestion.mQuestion.length;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        r = new Random();
        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);
        score = (TextView)findViewById(R.id.score);
        question = (TextView)findViewById(R.id.question);
        score.setText("Score:"+ mScore);
        updateQuestio(r.nextInt(mQuestionLenght));
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText()==mAnswer){
                    mScore++;
                    score.setText("Score:"+ mScore);
                    updateQuestio(r.nextInt(mQuestionLenght));
                }else{
                    gameOver();
                }

            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getText()==mAnswer){
                    mScore++;
                    score.setText("Score:"+ mScore);
                    updateQuestio(r.nextInt(mQuestionLenght));
                }else{
                    gameOver();
                }

            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getText()==mAnswer){
                    mScore++;
                    score.setText("Score:"+ mScore);
                    updateQuestio(r.nextInt(mQuestionLenght));
                }else{
                    gameOver();
                }

            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer4.getText()==mAnswer){
                    mScore++;
                    score.setText("Score:"+ mScore);
                    updateQuestio(r.nextInt(mQuestionLenght));
                }else{
                    gameOver();
                }

            }
        });
    }
    private void updateQuestio (int num){
        question.setText(mQuestion.getQuestion(num));
        answer1.setText(mQuestion.getChoice1(num));
        answer2.setText(mQuestion.getChoice2(num));
        answer3.setText(mQuestion.getChoice3(num));
        answer4.setText(mQuestion.getChoice4(num));

        mAnswer = mQuestion.getCorrectAnswer(num);
    }
    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuestionActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your Score is"+ mScore +"point.")
                .setCancelable(false)
                .setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(),QuestionActivity.class));

                            }

                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();

                            }

                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
