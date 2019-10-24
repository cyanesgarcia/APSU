package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

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
 * Created by LidiayClaudia on 28/04/2018.
 */


public class type extends Activity implements AdapterView.OnItemClickListener {
    int count= 0;
    public static String Type;
    Toolbar toolbar;
    ListView lv;
    String result;
    String check="no";
    InputStream isr;
    final static ArrayList<String> TYPES =new ArrayList<>();
    final static ArrayList<String> ima1 = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onResume() {
        //toolbar=(Toolbar) findViewById(R.id.toolbar);
        // toolbar.setTitle(MainActivity.total + " coins");
        super.onResume();


        getData updateTask = new getData();
        updateTask.execute();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_t);

        lv = (ListView) findViewById(R.id.listview);

        adapter=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, TYPES
        );
        adapter= new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, ima1
        );
        lv.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Type = (String) adapterView.getItemAtPosition(i);
       Intent intent=new Intent(this,Info.class);
        startActivity(intent);
    }

    private class getData extends AsyncTask<String, Void, String> {
        String name;

        @Override
        protected String doInBackground(String... params) {
            result = "";
            isr = null;
            String type_url ="https://apalbum.000webhostapp.com/php2.php";
            try {

                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(type_url); //YOUR PHP SCRIPT ADDRESS
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


                    // Data=Data+"\n"+  json.getString("State");
                    // Log.i("aqui","str" + json.getString("State"));
                    for(int ii=0; ii<TYPES.size(); ii++) {
                        if (TYPES.get(ii).equals(json.getString("categories"))) {
                            check="si";
                        }
                    }


                    if(check.equals("no")) {
                        TYPES.add(json.getString("categories"));
                        ima1.add(json.getString("icon"));
                    }

                    check="no";


                }

            } catch (Exception e) {
                // TODO: handle exception

                Log.e("log_tag", "Error Parsing Data " + e.toString());
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            //tv.setText(""+Data);

            if(count==0){
                CustomListView customListView = new CustomListView(type.this,TYPES, ima1);
                lv.setAdapter(customListView);}
            count++;
        }

        @Override
        protected void onPreExecute() {
            //TYPES.clear();
            //  ima1.clear();
        }

        @Override
        protected void onProgressUpdate(Void... values) {


        }
    }

}