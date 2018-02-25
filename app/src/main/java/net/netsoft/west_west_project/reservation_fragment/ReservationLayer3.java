package net.netsoft.west_west_project.reservation_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import net.netsoft.west_west_project.R;
import net.netsoft.west_west_project.data.ReservationData;
import net.netsoft.west_west_project.data.StrokeData;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by HCKH on 22/2/18.
 */

public class ReservationLayer3 extends FragmentActivity {

    private StrokeData stroke_data;
    private ReservationData reservation_data = new ReservationData();

    private String reservation_type;
    private String reservation_layer1;
    private String reservation_layer2;

    Button btn_back;
    TextView tv_title_2;

    ListView list_data;
    private ArrayList listItems = new ArrayList<String>();
    private ArrayAdapter listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reservation_layer3);

        getPassedParameter();

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_title_2 = (TextView) findViewById(R.id.tv_title_2);

        list_data = (ListView) findViewById(R.id.list_data);
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        list_data.setAdapter(listAdapter);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Map<String, String> reservation_layer2_array = reservation_data.get_reservation_layer2_array(reservation_layer1);

        tv_title_2.setText(tv_title_2.getText()+
                " - "+reservation_data.reservation_type_array.get(reservation_type)+
                " - "+reservation_data.reservation_layer1_array.get(reservation_layer1)+
                " - "+reservation_layer2_array.get(reservation_layer2)+
                " - 球場");



        String[] reservation_layer3_items = reservation_data.get_reservation_layer3_array(reservation_type).get(reservation_layer2);
        if(reservation_layer3_items != null) {
            for(String item : reservation_layer3_items){
                listItems.add(item);
                listAdapter.notifyDataSetChanged();
            }
        }
        list_data.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapter,View v, int position, long id){
                Intent intent = new Intent(ReservationLayer3.this, ReservationLayer4.class);
                Bundle b = new Bundle();
                b.putSerializable("stroke_data", stroke_data);
                b.putString("reservation_type", reservation_type);
                b.putString("reservation_layer1", reservation_layer1);
                b.putString("reservation_layer2", reservation_layer2);
                b.putInt("reservation_layer3", position);
                intent.putExtras(b);
                startActivityForResult(intent, 0);
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
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            Intent intent = new Intent();
            intent.putExtra("stroke_data", data.getSerializableExtra("stroke_data"));
            setResult(resultCode,intent);
            finish();
        }
    }
}