package net.netsoft.west_west_project;

/**
 * Created by HCKH on 21/2/18.
 */

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewsFragment extends FragmentActivity {

    Button btn_back;
    ListView list_data;

    int[] news_image = new int[]{
            R.mipmap.news_image_1, R.mipmap.news_image_1, R.mipmap.news_image_1, R.mipmap.news_image_1,
            R.mipmap.news_image_1, R.mipmap.news_image_1, R.mipmap.news_image_1, R.mipmap.news_image_1,
    };

    String[] news_title = new String[]{
            "ListView Title 1", "ListView Title 2", "ListView Title 3", "ListView Title 4",
            "ListView Title 5", "ListView Title 6", "ListView Title 7", "ListView Title 8",
    };


    String[] news_time = new String[]{
            "2018-01-01", "2018-02-02", "2018-03-03", "2018-04-04",
            "2018-05-05", "2018-06-06", "2018-07-07", "2018-08-08"
    };

    String[] news_description = new String[]{
            "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description",
            "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description",
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news);

        set_frontend_element();



        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("news_image", Integer.toString(news_image[i]));
            hm.put("news_title", news_title[i]);
            hm.put("news_time", news_time[i]);
            hm.put("news_description", news_description[i]);
            aList.add(hm);
        }

        String[] from = {"news_image", "news_title", "news_time", "news_description"};
        int[] to = {R.id.news_image, R.id.news_title, R.id.news_time, R.id.news_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.new_row, from, to);
        ListView list_data = (ListView) findViewById(R.id.list_data);
        list_data.setAdapter(simpleAdapter);
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
