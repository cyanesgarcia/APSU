package com.yanes.album;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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

public class CustomListView1 extends ArrayAdapter<Album>{

    private ArrayList<Album> list;
    private Activity context;

    public CustomListView1(Activity context, ArrayList<Album> list) {
        super(context, R.layout.listview_s_t, list);
        Log.i("ttttttttttttttttttttttttt11aaaaa111111", "hh   ");
        this.context=context;
        this.list = list;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.i("ttttttttttttttttttttttttt11aaaaa111111", "hh   ");
        View r = convertView;
        ViewHolder viewHolder = null;
        Log.i("ttttttttttttttttttttttttt111111aquiiiii1", "hh   "+ list.get(position).getName());
        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_s_t, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();

        }
        //String src= list.get(position).getIcon();


        /*Picasso.get()
                .load(src)
                .placeholder(null)
                .resize(250,350)
                .into(viewHolder.imageView);

        Picasso.get().load(src).into(viewHolder.imageView);

      new Bitmap_class(viewHolder.imageView).execute(src);
      viewHolder.imageView.setImageURI(Uri.parse((list.get(position).getIcon())));*/
      viewHolder.textView.setText(list.get(position).getName());
        Log.i("ttttttttttttttttttttttttt11111111111111111111111", "hh   "+ list.get(position).getName());
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
