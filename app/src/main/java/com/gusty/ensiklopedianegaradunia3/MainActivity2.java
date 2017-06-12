package com.gusty.ensiklopedianegaradunia3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gusty.ensiklopedianegaradunia3.Bendera.ListViewActivity;
import com.gusty.ensiklopedianegaradunia3.LoginRegister.RegisterActivity;
import com.gusty.ensiklopedianegaradunia3.Question.QuestionActivity;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String username = getIntent().getStringExtra("Username");

        TextView tv =(TextView)findViewById(R.id.getname);
        tv.setText(username);

    }
    public void masukdrmenu(View view){
        Intent menuBtnSignin = new Intent(this,RegisterActivity.class);
        startActivity(menuBtnSignin);
    }
    public void onClickList(View view){
        Intent  btnClickList= new Intent(this, ListViewActivity.class);
        startActivity(btnClickList);
    }
    public void onclickquiz(View view){
        Intent btnQuiz = new Intent(this, QuestionActivity.class);
        startActivity(btnQuiz);
    }

}
