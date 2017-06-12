package com.gusty.ensiklopedianegaradunia3.LoginRegister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gusty.ensiklopedianegaradunia3.R;

    public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
        private final AppCompatActivity activity = RegisterActivity.this;
        private Button button;
        private EditText editText;
        private TextView textView;
        private DatabaseHelper databaseHelper;
        private User user;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);
            initView();
            initListener();
            initObjects();
        }
        private void initListener(){
            button.setOnClickListener(this);
            editText.setOnClickListener(this);
        }
        private void initObjects(){
            databaseHelper=new DatabaseHelper(this);
        }

        private void initView(){
            editText = (EditText)findViewById(R.id.nameregister);
            editText = (EditText)findViewById(R.id.emailregister);
            editText = (EditText)findViewById(R.id.passwordregister);
            button = (Button)findViewById(R.id.btnregister);
        }

        @Override
        public void onClick(View v) {

        }
        private void emptyInputaEditText(){
            editText.setText(null);
        }
    }