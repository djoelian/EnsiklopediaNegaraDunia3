package com.gusty.ensiklopedianegaradunia3.Bendera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.gusty.ensiklopedianegaradunia3.R;

public class DetailActivity extends AppCompatActivity {
    Toolbar mToolbar;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolbar = (Toolbar) findViewById(R.id.toolbar5);

        mImageView = (ImageView)findViewById(R.id.imageView14);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle !=null){
            mToolbar.setTitle(mBundle.getString("namaNegara"));
            mImageView.setImageResource(mBundle.getInt("diskripnegara"));
        }
    }
}
