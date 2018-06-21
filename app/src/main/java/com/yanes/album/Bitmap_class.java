package com.yanes.album;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by claud on 5/26/2018.
 */

public class Bitmap_class extends AsyncTask<String, Void, Bitmap>{
    private ImageView imgV;
    Bitmap bitmap;

    public Bitmap_class(ImageView imgV){
        this.imgV = imgV;
    }
    @Override
    protected Bitmap doInBackground(String... url){
        String urldisplay = url[0];
        bitmap = null;
        try{
            InputStream srt = new java.net.URL(urldisplay).openStream();
            bitmap= BitmapFactory.decodeStream(srt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imgV.setImageBitmap(bitmap);
    }
}
