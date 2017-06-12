package com.gusty.ensiklopedianegaradunia3.Bendera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.gusty.ensiklopedianegaradunia3.R;

public class ListViewActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListview;
    ImageView mImangeView2;


    String [] namaNegara =
            {"Australia","Amerika","Arab","Argentina","Belanda","Brazil","canada"
                    ,"Cina","India","Indonesia","Itali","Jepang",
            "Jerman","Korea Selatan","Perancis","Rusia","Selandia Baru","Spanyol","Turki","Inggris",};
    int [] benderaNegara = {R.drawable.australia,R.drawable.usa,
            R.drawable.arab,
            R.drawable.argentina,
            R.drawable.belanda,
            R.drawable.brazil,
            R.drawable.canada,
            R.drawable.cina,
            R.drawable.india,
            R.drawable.indonesia,
            R.drawable.itali,
            R.drawable.jepang,
            R.drawable.jerman,
            R.drawable.koreaselatan,
            R.drawable.prancis,
            R.drawable.rusia,
            R.drawable.selandiabaru,
            R.drawable.spanyol,
            R.drawable.turki,
            R.drawable.uk,};
    int [] diskripnegara ={
            R.drawable.australiad,
            R.drawable.amerikad,
            R.drawable.arabd,
            R.drawable.argentinad,
            R.drawable.belandad,
            R.drawable.brazil,
            R.drawable.cina,
            R.drawable.india,
            R.drawable.indonesia,
            R.drawable.itali,
            R.drawable.jepang,
            R.drawable.jerman,
            R.drawable.koreaselatan,
            R.drawable.prancis,
            R.drawable.rusia,
            R.drawable.selandiabaru,
            R.drawable.spanyol,
            R.drawable.turki,
            R.drawable.uk,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mToolbar = (Toolbar) findViewById(R.id.toolbar4);
        mToolbar.setTag(getResources().getString(R.string.app_name));
        mListview = (ListView)findViewById(R.id.Listview);
        mImangeView2 = (ImageView) findViewById(R.id.imageView14);
        MyAdapter myAdapter = new MyAdapter(ListViewActivity.this,namaNegara,benderaNegara);
        mListview.setAdapter(myAdapter );
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView , View view, int i, long l) {
                Intent mIntent = new Intent(ListViewActivity.this,DetailActivity.class);
                mIntent.putExtra("namaNegara",namaNegara[i]);
                mIntent.putExtra("diskripnegara",diskripnegara[i]);
                startActivity(mIntent);
            }
        });
    }
}


