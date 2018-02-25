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
    int news_num = 4;

    int[] news_image = new int[]{
            R.mipmap.news_image_1,
            -1,
            R.mipmap.news_image_3,
            R.mipmap.news_image_4
    };

    String[] news_title = new String[]{
            "干地希望英超用VAR",
            "曼城3：0爆「廠」捧聯賽盃",
            "NIKE 5 土瓜灣分站結束 28隊勁旅殺入麥花臣",
            "盧卡古做好戲 曼聯2：1拆車"
    };


    String[] news_time = new String[]{
            "1小時前",
            "1小時前",
            "1小時前",
            "2小時前"
    };

    String[] news_description = new String[]{
            "車路士負曼聯一役，莫拉達的入球被判越位成為車仔未能追平關鍵，車路士領隊干地表示希望英超能使用VAR技術避免誤判。",
            "曼城3：0爆「廠」捧聯賽盃",
            "【體路專訊】「NIKE香港五人足球賽2018」上週末一連兩天（24、25日）假土瓜灣遊樂場硬地小型足球場上演分站賽事，五個組別共28支出線隊伍，將於4...",
            "英超前列大戰，曼聯主場以2：1反勝車路土，一直對big 6死火的紅魔前鋒盧卡古今場貢獻1入球1助功，可謂對近期外間的質疑作出最好反擊。"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news);

        set_frontend_element();



        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < news_num; i++) {
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
