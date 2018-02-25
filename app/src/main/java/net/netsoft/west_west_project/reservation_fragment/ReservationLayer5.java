package net.netsoft.west_west_project.reservation_fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import net.netsoft.west_west_project.R;
import net.netsoft.west_west_project.data.StrokeData;
import net.netsoft.west_west_project.data.UserData;
import net.netsoft.west_west_project.data.ReservationData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by HCKH on 25/2/2018.
 */

public class ReservationLayer5 extends FragmentActivity {

    private StrokeData stroke_data;
    private UserData user_data = new UserData();

    private SharedPreferences settings;
    private String username;
    private String userid;

    private ReservationData reservation_data = new ReservationData();

    private String reservation_type;
    private String reservation_layer1;
    private String reservation_layer2;
    private int reservation_layer3;
    private String reservation_layer4_date;
    private String reservation_layer4_time;

    Button btn_back;
    TextView tv_title_2;
    TextView tv_register_num;
    Button btn_reservation;

    ListView list_data;
    private ArrayList listItems= new ArrayList<String>();
    private ArrayAdapter listAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reservation_layer5);

        settings = getSharedPreferences("DATA", 0);
        username = settings.getString("username", "");

        getPassedParameter();

        set_frontend_element();

        if(user_data.userData.get(username)[0] != null) {
            userid = user_data.userData.get(username)[1];
        }else{
            userid = "";
        }
        listItems.add(userid);
        listAdapter.notifyDataSetChanged();
        set_tv_register_num();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_title_2 = (TextView) findViewById(R.id.tv_title_2);
        tv_register_num = (TextView) findViewById(R.id.tv_register_num);
        btn_reservation = (Button) findViewById(R.id.btn_reservation);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Map<String, String> reservation_layer2_array = reservation_data.get_reservation_layer2_array(reservation_layer1);
        String[] reservation_layer3_items = reservation_data.get_reservation_layer3_array(reservation_type).get(reservation_layer2);

        tv_title_2.setText(tv_title_2.getText()+
                " - "+reservation_data.reservation_type_array.get(reservation_type)+
                " - "+reservation_data.reservation_layer1_array.get(reservation_layer1)+
                " - "+reservation_layer2_array.get(reservation_layer2)+
                " - "+reservation_layer3_items[reservation_layer3]+
                " - "+reservation_layer4_date+" "+reservation_layer4_time);

        list_data = (ListView) findViewById(R.id.list_data);
        listItems = new ArrayList<String>(Arrays.asList(reservation_data.reservation_layer5_data.get(reservation_type)));
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        list_data.setAdapter(listAdapter);

        set_tv_register_num();

        btn_reservation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Map<String, String> reservation_layer2_array = reservation_data.get_reservation_layer2_array(reservation_layer1);
                String[] reservation_layer3_items = reservation_data.get_reservation_layer3_array(reservation_type).get(reservation_layer2);

                stroke_data.strokeData.add(reservation_data.reservation_type_array.get(reservation_type)+
                        " - "+reservation_data.reservation_layer1_array.get(reservation_layer1)+
                        " - "+reservation_layer2_array.get(reservation_layer2)+
                        " - "+reservation_layer3_items[reservation_layer3]+
                        " - "+reservation_layer4_date+" "+reservation_layer4_time);

                Intent intent = new Intent();
                intent.putExtra("stroke_data", stroke_data);
                setResult(1,intent);
                finish();
            }
        });
    }

    private void getPassedParameter(){
        Bundle b = getIntent().getExtras();
        if(b != null) {
            stroke_data = (StrokeData) b.getSerializable("stroke_data");
            reservation_type = b.getString("reservation_type");
            reservation_layer1 = b.getString("reservation_layer1");
            reservation_layer2 = b.getString("reservation_layer2");
            reservation_layer3 = b.getInt("reservation_layer3");
            reservation_layer4_date = b.getString("reservation_layer4_date");
            reservation_layer4_time = b.getString("reservation_layer4_time");
        }
    }

    private void set_tv_register_num(){
        tv_register_num.setText("登記人數: "+listItems.size()+"/"+reservation_data.reservation_layer5_register_max_num.get(reservation_type));
    }
}