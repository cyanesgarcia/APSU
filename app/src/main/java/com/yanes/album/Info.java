package com.yanes.album;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
import java.util.List;

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
    private getData updateTask;
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
                HttpPost httppost = new HttpPost("https://lidiayanesgarcia.000webhostapp.com/php2.php"); //YOUR PHP SCRIPT ADDRESS
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


                    Album a = new Album(json.getString("State"),json.getString("Type"),json.getString("Name"),json.getString("Description"));
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        dialog = new AlertDialog.Builder(this).create();

       // ArrayAdapter adapter = (ArrayAdapter<Album>) getListAdapter();
        fin = (Album)adapter.getItem(position);

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


                    if(MainActivity.total>=5 ){
                       MainActivity.check.add(fin.getName());
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


            builder.setMessage(Html.fromHtml("<html>" + "<p><b>Name: </b>" + fin.getName()+"</p>" + "<p><b>State: </b>" + fin.getState()+"</p>" +
                    "<p><b>Type: </b>" + fin.getType()+"</p>" + "<p><b>Description: </b>" + fin.getDescription() +"</p>" +"</html>"));
            builder. setTitle("Info");
            builder.create().show();

        }else{
            Toast.makeText(getApplicationContext(),"You do not have enough coins",Toast.LENGTH_LONG).show();
            builder.setMessage(Html.fromHtml("<html>" + "<p><b>Name: ????</b>" +"</p>" + "<p><b>State: ????</b>" + "</p>" +
                    "<p><b>Type: ????</b>"+"</p>" + "<p><b>Description: ????</b>" +"</p>" +"</html>"));
            builder. setTitle("Info");
            builder.create().show();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        lista.clear();
    }
}



