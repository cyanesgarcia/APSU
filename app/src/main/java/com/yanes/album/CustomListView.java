package com.yanes.album;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by claud on 4/29/2018.
 */

public class CustomListView extends ArrayAdapter<String>{

    private String[] STATES;
    private Integer[] ima;
    private Activity context;

    public CustomListView(Activity context, String[] STATES, Integer[] ima) {
        super(context, R.layout.listview_s_t, STATES);

        this.context=context;
        this.STATES = STATES;
        this.ima=ima;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;

        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_s_t, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();

        }
        viewHolder.imageView.setImageResource(ima[position]);
        viewHolder.textView.setText(STATES[position]);

        return r;


    }

    class ViewHolder{

        TextView textView;
        ImageView imageView;
        ViewHolder(View view){
            textView = (TextView) view.findViewById(R.id.tvoptions);
            imageView = (ImageView)view.findViewById(R.id.imageView);


        }
    }

}
