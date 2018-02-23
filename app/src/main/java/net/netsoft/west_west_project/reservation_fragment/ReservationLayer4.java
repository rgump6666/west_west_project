package net.netsoft.west_west_project.reservation_fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kd.dynamic.calendar.generator.ImageGenerator;

import net.netsoft.west_west_project.R;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HCKH on 23/2/18.
 */

public class ReservationLayer4 extends FragmentActivity{

    private ReservationData reservation_data = new ReservationData();

    private String reservation_type;
    private String reservation_layer1;
    private String reservation_layer2;
    private int reservation_layer3;

    Button btn_back;
    TextView tv_title_2;
    EditText ed_date;

    ImageGenerator mImageGenerator;
    Calendar mCurrentDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reservation_layer4);

        getPassedParameter();

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_title_2 = (TextView) findViewById(R.id.tv_title_2);
        ed_date = (EditText) findViewById(R.id.ed_date);

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

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Map<String, String> reservation_layer2_array = reservation_data.get_reservation_layer2_array(reservation_layer1);
        String[] reservation_layer3_items = reservation_data.get_reservation_layer3_array(reservation_type).get(reservation_layer2);

        tv_title_2.setText(tv_title_2.getText()+reservation_data.reservation_type_array.get(reservation_type)+
                " - "+reservation_data.reservation_layer1_array.get(reservation_layer1)+
                " - "+reservation_layer2_array.get(reservation_layer2)+
                " - "+reservation_layer3_items[reservation_layer3]+
                " - 日期時間");

        ed_date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            mCurrentDate = Calendar.getInstance();
            int year = mCurrentDate.get(Calendar.YEAR);
            int month = mCurrentDate.get(Calendar.MONTH);
            int day = mCurrentDate.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog mDatePicker = new DatePickerDialog(ReservationLayer4.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    ed_date.setText(year+"-"+month+"-"+dayOfMonth);
                }
            }, year, month, day);
            mDatePicker.show();
            }
        });
        for (Map.Entry<String, Button> row : btn_menu_map.entrySet()) {
            final String key = row.getKey();
            Button btn_menu = row.getValue();

            btn_menu.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Button btn_clicked = (Button)v;
                    if(!ed_date.getText().toString().equals("")) {

                        Intent intent = new Intent();
                        setResult(1,intent);
                        finish();

                    }
                }
            });
        }

    }

    private void getPassedParameter(){
        Bundle b = getIntent().getExtras();
        if(b != null) {
            reservation_type = b.getString("reservation_type");
            reservation_layer1 = b.getString("reservation_layer1");
            reservation_layer2 = b.getString("reservation_layer2");
            reservation_layer3 = b.getInt("reservation_layer3");
        }
    }
}
