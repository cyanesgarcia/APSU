package com.yanes.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by LidiayClaudia on 28/04/2018.
 */

public class States extends Activity implements AdapterView.OnItemClickListener{
    public static String State;

    static final String[] STATES={
            "California(CA)","Florida(FL)","Georgia(GA)","Hawaii(HI)",
            "New York(NY)", "Tennessee(TN)", "Texas(TX)",
    };
    Integer [] ima ={R.drawable.ny, R.drawable.ca,R.drawable.ny, R.drawable.ca, R.drawable.ny, R.drawable.ca,R.drawable.ca};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_t);

        ListView lv= (ListView) findViewById(R.id.listview);
       CustomListView customListView = new CustomListView(this,STATES,ima);
        lv.setAdapter(customListView);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        State = (String) adapterView.getItemAtPosition(i);
        Intent intent=new Intent(this,type.class);
        startActivity(intent);
    }


}
