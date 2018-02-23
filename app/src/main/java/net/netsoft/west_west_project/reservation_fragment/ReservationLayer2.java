package net.netsoft.west_west_project.reservation_fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.netsoft.west_west_project.R;
import net.netsoft.west_west_project.ReservationFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HCKH on 22/2/18.
 */

public class ReservationLayer2 extends FragmentActivity {

    private ReservationData reservation_data = new ReservationData();

    private String reservation_type;
    private String reservation_layer1;

    Button btn_back;
    TextView tv_title_2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reservation_layer2);

        getPassedParameter();

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_title_2 = (TextView) findViewById(R.id.tv_title_2);

        Map<String, Button> btn_menu_map = new HashMap<String, Button>();
        btn_menu_map.put("1", (Button) findViewById(R.id.btn_menu_1));
        btn_menu_map.put("2", (Button) findViewById(R.id.btn_menu_2));
        btn_menu_map.put("3", (Button) findViewById(R.id.btn_menu_3));
        btn_menu_map.put("4", (Button) findViewById(R.id.btn_menu_4));
        btn_menu_map.put("5", (Button) findViewById(R.id.btn_menu_5));
        btn_menu_map.put("6", (Button) findViewById(R.id.btn_menu_6));
        btn_menu_map.put("7", (Button) findViewById(R.id.btn_menu_7));
        btn_menu_map.put("8", (Button) findViewById(R.id.btn_menu_8));
        btn_menu_map.put("9", (Button) findViewById(R.id.btn_menu_9));
        btn_menu_map.put("10", (Button) findViewById(R.id.btn_menu_10));
        btn_menu_map.put("11", (Button) findViewById(R.id.btn_menu_11));
        btn_menu_map.put("12", (Button) findViewById(R.id.btn_menu_12));
        btn_menu_map.put("13", (Button) findViewById(R.id.btn_menu_13));
        btn_menu_map.put("14", (Button) findViewById(R.id.btn_menu_14));
        btn_menu_map.put("15", (Button) findViewById(R.id.btn_menu_15));
        btn_menu_map.put("16", (Button) findViewById(R.id.btn_menu_16));
        btn_menu_map.put("17", (Button) findViewById(R.id.btn_menu_17));
        btn_menu_map.put("18", (Button) findViewById(R.id.btn_menu_18));

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });


        tv_title_2.setText(tv_title_2.getText()+reservation_data.reservation_type_array.get(reservation_type)+
                " - "+reservation_data.reservation_layer1_array.get(reservation_layer1)+
                " - 十八區");

        Map<String, String> reservation_layer2_array = reservation_data.get_reservation_layer2_array(reservation_layer1);
        if(reservation_layer2_array != null) {
            for (Map.Entry<String, Button> row : btn_menu_map.entrySet()) {
                final String key = row.getKey();
                Button btn_menu = row.getValue();

                if(!reservation_layer2_array.containsKey(key)) {
                    btn_menu.setBackgroundColor(Color.GRAY);
                    btn_menu.setClickable(false);
                }else{
                    btn_menu.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(ReservationLayer2.this, ReservationLayer3.class);
                            Bundle b = new Bundle();
                            b.putString("reservation_type", reservation_type);
                            b.putString("reservation_layer1", reservation_layer1);
                            b.putString("reservation_layer2", key);
                            intent.putExtras(b);
                            startActivityForResult(intent, 0);
                        }
                    });
                }
            }
        }
    }

    private void getPassedParameter(){
        Bundle b = getIntent().getExtras();
        if(b != null) {
            reservation_type = b.getString("reservation_type");
            reservation_layer1 = b.getString("reservation_layer1");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            Intent intent = new Intent();
            setResult(resultCode,intent);
            finish();
        }
    }
}