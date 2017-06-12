package com.gusty.ensiklopedianegaradunia3.LoginRegister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gusty.ensiklopedianegaradunia3.R;

public class Login2ctivity extends AppCompatActivity implements View.OnClickListener{
    private final AppCompatActivity activity = Login2ctivity.this;
    private  Button button;
    private  EditText editText;
    private TextView textView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2ctivity);
        initViews();
        initListene();
        initObjects();
    }
    private void initViews(){
        editText = (EditText)findViewById(R.id.textInputEditTextEmail);
        editText = (EditText)findViewById(R.id.textInputEditTextPassword);
        button = (Button)findViewById(R.id.appCompatButtonLogin);
        textView = (TextView)findViewById(R.id.textViewLinkRegister);
    }
    private  void initListene(){
        button.setOnClickListener(this);
        textView.setOnClickListener(this);
    }
    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);


    }
    private void emptyInputEditText(){
        editText.setText(null);
        textView.setText(null);
    }

    @Override
    public void onClick(View v) {

    }
}