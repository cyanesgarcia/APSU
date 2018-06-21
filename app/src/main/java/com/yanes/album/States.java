package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
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
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by LidiayClaudia on 28/04/2018.
 */

public class States extends Activity implements AdapterView.OnItemClickListener{

    public static String State;
    Toolbar toolbar;
    ListView lv;
    String result;
    InputStream isr;
    String check="no";
    final static ArrayList<String> STATES =new ArrayList<>();
    final static ArrayList<String> ima = new ArrayList<>();
   // Integer [] ima ={R.drawable.ca, R.drawable.fl,R.drawable.ga, R.drawable.hi, R.drawable.ny, R.drawable.tn,R.drawable.tx,R.drawable.tx};
    ArrayAdapter<String> adapter;
    @Override
    protected void onResume() {
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(MainActivity.total + " coins");
        super.onResume();

        getData updateTask = new getData();
        updateTask.execute();

    }
  /* static final String[] STATES={
            "California(CA)","Florida(FL)","Georgia(GA)","Hawaii(HI)",
            "New York(NY)", "Tennessee(TN)", "Texas(TX)",
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_t);

        lv= (ListView) findViewById(R.id.listview);


        adapter=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, STATES
        );
        adapter= new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, ima
        );
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        State = (String) adapterView.getItemAtPosition(i);
        Intent intent=new Intent(this,type.class);
        startActivity(intent);
    }

    private class getData extends AsyncTask<String, Void, String> {
        String name;

        @Override
        protected String doInBackground(String... params) {
            result = "";
            isr = null;
            String state_url = "https://lidiayanesgarcia.000webhostapp.com/php2.php";
            try {

                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(state_url); //YOUR PHP SCRIPT ADDRESS
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

                  //  STATES.add(json.getString("State"));
                    // Data=Data+"\n"+  json.getString("State");
                    // Log.i("aqui","str" + json.getString("State"));


                   for(int ii=0; ii<STATES.size(); ii++) {
                       if (STATES.get(ii).equals(json.getString("State"))) {
                           check="si";
                       }
                   }


                   if(check.equals("no")) {
                            STATES.add(json.getString("State"));
                        }

                        check="no";
                //}

                    ima.add(json.getString("SImage"));

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
           CustomListView customListView = new CustomListView(States.this,STATES,ima);
            lv.setAdapter(customListView);

        }

        @Override
        protected void onPreExecute() {
           //STATES.clear();
          // ima.clear();

        }

        @Override
        protected void onProgressUpdate(Void... values) {


        }
    }


}
