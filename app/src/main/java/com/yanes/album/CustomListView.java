package com.yanes.album;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by claud on 4/29/2018.
 */

public class CustomListView extends ArrayAdapter<String>{

    private ArrayList<String> STATES;
    private ArrayList<String> ima;
    private Activity context;

    public CustomListView(Activity context, ArrayList<String> STATES, ArrayList<String> ima) {
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
        String src= ima.get(position);

        Picasso.with(this.context)
                .load(src)
                .placeholder(null)
                .resize(250,350)
                .into(viewHolder.imageView);

        //Picasso.with(this.context).load(src).into(viewHolder.imageView);

       // new Bitmap_class(viewHolder.imageView).execute(src);
       //viewHolder.imageView.setImageURI(Uri.parse((ima.get(position))));
        viewHolder.textView.setText(STATES.get(position));

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
