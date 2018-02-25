package net.netsoft.west_west_project;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import net.netsoft.west_west_project.data.StrokeData;

import java.util.ArrayList;

/**
 * Created by HCKH on 20/2/18.
 */

public class MyStrokeFragment extends FragmentActivity {

    private StrokeData stroke_data;

    Button btn_back;

    ListView list_data;
    private ArrayList listItems;
    private ArrayAdapter listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_stroke);

        stroke_data = (StrokeData) getIntent().getSerializableExtra("stroke_data");

        set_frontend_element();

        listAdapter.notifyDataSetChanged();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);

        listItems = stroke_data.strokeData;

        list_data = (ListView) findViewById(R.id.list_data);
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        list_data.setAdapter(listAdapter);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
