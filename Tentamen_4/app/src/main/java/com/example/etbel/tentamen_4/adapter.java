package com.example.etbel.tentamen_4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Etbel on 14-6-2017.
 */

public  class adapter extends BaseAdapter {

    private static final String TAG = adapter.class.getSimpleName();

    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList mArrayList;

    public adapter(Context context, LayoutInflater layoutInflater, ArrayList<Films> ArrayList) {
        mContext = context;
        mInflator = layoutInflater;
        mArrayList = ArrayList;
    }

    @Override
    public int getCount() {
        int size = mArrayList.size();

        return size;
    }

    public Object getItem(int position) {

        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflator.inflate(R.layout.film_adapter,null);

            viewHolder = new ViewHolder();
            viewHolder.movieName = (TextView) convertView.findViewById(R.id.movieName);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.albumImage);
            viewHolder.beschrijving = (TextView) convertView.findViewById(R.id.asfd);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Films films = (Films) mArrayList.get(position);

        viewHolder.movieName.setText(films.getMovieName());
        viewHolder.beschrijving.setText(films.getBeschrijving());




        return convertView;
    }

    private static class ViewHolder {
        public ImageView imageView;
        public TextView movieName, beschrijving;

    }

}
