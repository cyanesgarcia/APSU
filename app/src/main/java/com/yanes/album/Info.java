package com.yanes.album;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.res.*;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ThemedSpinnerAdapter;

import java.util.List;

/**
 * Created by claud on 4/27/2018.
 */

public class Info extends ListActivity {
    private DBDataSource dbDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbDataSource = new DBDataSource(getApplicationContext());

    }

    @Override
    protected void onStart() {
        super.onStart();
        dbDataSource.open();
        List<Album> people = dbDataSource.getAll();
        ArrayAdapter<Album> adapter = new ArrayAdapter<Album>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1, people);
        setListAdapter(adapter);
        final ListView listView = getListView();
        listView.setBackgroundColor(Color.parseColor("#4597CD"));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);



        ArrayAdapter adapter = (ArrayAdapter<Album>)getListAdapter();
        Album fin = (Album) adapter.getItem(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);



        builder.setMessage(Html.fromHtml("<html>" + "<p><b>Name: </b>" + fin.getName()+"</p>" + "<p><b>State: </b>" + fin.getState()+"</p>" +
                "<p><b>Type: </b>" + fin.getType()+"</p>" + "<p><b>Description: </b>" + fin.getDescription() +"</p>" +"</html>"));
        builder. setTitle("Info");
        builder.create().show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        dbDataSource.close();
    }



}
