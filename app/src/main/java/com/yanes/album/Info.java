package com.yanes.album;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by claud on 4/27/2018.
 */

public class Info extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private AlertDialog dialog;
    private int card_key= 100;
    private Album fin;

    ListView lv;
    String result;
    InputStream isr;
    final static ArrayList<Album> lista = new ArrayList<>();
    ArrayAdapter<Album> adapter;

    @Override
    protected void onResume() {
        super.onResume();

      getData updateTask = new getData();
       updateTask.execute();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_union);
        lv = (ListView) findViewById(R.id.listview);
        lv.setBackgroundColor(Color.parseColor("#4597CD"));

        //src= "http://images.nationalgeographic.com.es/medio/2016/02/23/8def375banciano_arbol_de_bataszek_hungria_1000x750.jpg";
        //new Bitmap_class(iv).execute(src);

/*
        for(int count=0; count <MainActivity.position.size();count++) {
            Log.i("numero", "count "+count);
            MainActivity.position.get(count).setBackgroundColor(Color.RED);


        }*/

        adapter = new ArrayAdapter<Album>(
                this, android.R.layout.simple_list_item_1, lista
        );

        lv.setOnItemClickListener(this);
    }


    private class getData extends AsyncTask<String, Void, String> {
        String name;

        @Override
        protected String doInBackground(String... params) {
            result = "";
            isr = null;
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("https://lidiayanesgarcia.000webhostapp.com/php1.php"); //YOUR PHP SCRIPT ADDRESS
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                isr = entity.getContent();
            } catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());

            }


            //convert response to string
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(isr, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                isr.close();

                result = sb.toString();
            } catch (Exception e) {
                Log.e("log_tag", "Error  converting result " + e.toString());
            }


            try {


                JSONArray jArray = new JSONArray(result);

                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json = jArray.getJSONObject(i);


                    Album a = new Album(json.getString("State"),json.getString("Type"),json.getString("Name"),json.getString("Description"),json.getString("Photo"));
                    if(json.getString("State").equals( States.State )&& json.getString("Type").equals( type.Type)) {
                        lista.add(a);
                    }
                }

            } catch (Exception e) {
                // TODO: handle exception

                Log.e("log_tag", "Error Parsing Data " + e.toString());
            }
            return "Executed";

        }

        @Override
        protected void onPostExecute(String result) {
            lv.setAdapter(adapter);
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
        dialog = new AlertDialog.Builder(this).create();
        fin = (Album)adapter.getItem(position);

        Log.i("este", "position " + parent);


        for(int ii=0; ii<MainActivity.check.size();ii++){
            if(fin.getName().equals(MainActivity.check.get(ii))){
                card_key=1;
                break;
            }else{
                card_key=100;
            }
        }

        if(card_key!=1){

            dialog.setTitle("Do you want to buy this card?");
            dialog.setButton("Yes", new DialogInterface.OnClickListener(){


                @Override
                public void onClick(DialogInterface dialogInterface, int i) {


                    if(MainActivity.total<=5 ){
                        MainActivity.position.add(view);
                       MainActivity.check.add(fin.getName());
                        //view.setBackgroundColor(Color.RED);
                        MainActivity.total -= 5;
                        card_key = 1;
                    }

                    f();
                }});

            dialog.setButton2("No",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    card_key=100;

                }
            });
            dialog.show();



        }else if(card_key ==1 ){
            f();
        }
        card_key=100;

    }
    public void f(){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(card_key==1) {

            MyCustomAlertDialog(new Album(fin.getState(),fin.getType(),fin.getName(),fin.getDescription(), fin.getPhoto()));

        }else{

            MyCustomAlertDialog(new Album("????", "????", "????", "????","????" ));
        }
    }

    public  void MyCustomAlertDialog(Album fin){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Info.this);
        View mView = getLayoutInflater().inflate(R.layout.customdialog, null);



        //front
/*
        TextView mText = (TextView)mView.findViewById(R.id.title);
        mText.setText(Html.fromHtml(fin.getName()));
       ImageView mImagen = (ImageView) mView.findViewById(R.id.i);
        String src= fin.getPhoto();
        Picasso.with(this)
                .load(fin.getPhoto())
                .placeholder(null)
                .resize(500,600)
                .into(mImagen);
        TextView mText2 = (TextView) mView.findViewById(R.id.title2);
        mText2.setText(Html.fromHtml("<html>" + "<p><b>Name: </b>" + fin.getName() + "</p>" + "<p><b>State: </b>" + fin.getState() + "</p>" +
                "<p><b>Type: </b>" + fin.getType() + "</p>" + "<p><b>Description: </b>" + fin.getDescription() + "</p>" + "</html>"));

*/
      mBuilder.setView(mView);
       AlertDialog dialog = mBuilder.create();
        dialog.show();


    }
    public void onCardClick(View view)
    {
        Log.i("sillega","d");
flipCard();
    }


    private void flipCard()
    {
        Log.i("sillega1","d");
        View rootLayout = (View) findViewById(R.id.main_activity_root);
        View cardFace = (View) findViewById(R.id.main_activity_card_face);
        View cardBack = (View) findViewById(R.id.main_activity_card_back);
        Log.i("sillega2","d");
        FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);
        Log.i("sillega3","d");
        if (cardFace.getVisibility() == View.GONE)
        {
            Log.i("sillega4","d");
            flipAnimation.reverse();
        }

        rootLayout.startAnimation(flipAnimation);
        Log.i("sillega5","d");
    }



    @Override
    protected void onStop() {
        super.onStop();
        lista.clear();
    }

}



