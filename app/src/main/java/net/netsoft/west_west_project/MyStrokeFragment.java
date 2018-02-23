package net.netsoft.west_west_project;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by HCKH on 20/2/18.
 */

public class MyStrokeFragment extends FragmentActivity {

    Button btn_back;

    ListView list_data;
    private ArrayList listItems = new ArrayList<String>();
    private ArrayAdapter listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_stroke);

        set_frontend_element();

        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listItems.add(0, "足球/2018年/3月2日/香港島,跑馬地,跑馬地足球場");
        listAdapter.notifyDataSetChanged();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);

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
