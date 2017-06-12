package com.gusty.ensiklopedianegaradunia3.Bendera;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gusty.ensiklopedianegaradunia3.R;

/**
 * Created by gusty on 30/05/2017.
 */

public class MyAdapter extends ArrayAdapter<String> {
    String [] nama;
    int [] bendera;
    Context mContext;
    public MyAdapter(Context context, String[] namaNegara, int[] benderaNegara) {
        super(context,R.layout.listview_item);
        this.nama = namaNegara;
        this.bendera = benderaNegara;
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return nama.length;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mBendera = (ImageView) convertView.findViewById(R.id.imageView11);
            mViewHolder.mNama = (TextView) convertView.findViewById(R.id.textView5);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mBendera.setImageResource(bendera[position]);
        mViewHolder.mNama.setText(nama[position]);
        return convertView;
    }
    static class ViewHolder{
        ImageView mBendera;
        TextView mNama;
    }
}

