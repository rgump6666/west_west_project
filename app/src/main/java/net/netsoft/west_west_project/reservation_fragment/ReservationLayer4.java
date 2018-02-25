package net.netsoft.west_west_project.reservation_fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kd.dynamic.calendar.generator.ImageGenerator;

import net.netsoft.west_west_project.R;
import net.netsoft.west_west_project.data.ReservationData;
import net.netsoft.west_west_project.data.StrokeData;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HCKH on 23/2/18.
 */

public class ReservationLayer4 extends FragmentActivity{

    private StrokeData stroke_data;
    private ReservationData reservation_data = new ReservationData();

    private String reservation_type;
    private String reservation_layer1;
    private String reservation_layer2;
    private int reservation_layer3;

    Button btn_back;
    TextView tv_title_2;
    EditText ed_date;
    Map<String, Button> btn_menu_map = new HashMap<String, Button>();

    ImageGenerator mImageGenerator;
    Calendar mCurrentDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reservation_layer4);

        getPassedParameter();

        set_frontend_element();

        if(reservation_type.equals("1")){
            set_type_1_timetable();
        }

        set_timebtn_disable();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_title_2 = (TextView) findViewById(R.id.tv_title_2);
        ed_date = (EditText) findViewById(R.id.ed_date);

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

        tv_title_2.setText(tv_title_2.getText()+
                " - "+reservation_data.reservation_type_array.get(reservation_type)+
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
                    ed_date.setText(year+"/"+month+"/"+dayOfMonth);
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

                        Intent intent = new Intent(ReservationLayer4.this, ReservationLayer5.class);
                        Bundle b = new Bundle();
                        b.putSerializable("stroke_data", stroke_data);
                        b.putString("reservation_type", reservation_type);
                        b.putString("reservation_layer1", reservation_layer1);
                        b.putString("reservation_layer2", reservation_layer2);
                        b.putInt("reservation_layer3", reservation_layer3);
                        b.putString("reservation_layer4_date", ed_date.getText().toString());
                        b.putString("reservation_layer4_time", ((Button) v).getText().toString());
                        intent.putExtras(b);
                        startActivityForResult(intent, 0);

                    }else{
                        Toast.makeText(getApplicationContext(), "請先輸入日期", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void getPassedParameter(){
        Bundle b = getIntent().getExtras();
        if(b != null) {
            stroke_data = (StrokeData) b.getSerializable("stroke_data");
            reservation_type = b.getString("reservation_type");
            reservation_layer1 = b.getString("reservation_layer1");
            reservation_layer2 = b.getString("reservation_layer2");
            reservation_layer3 = b.getInt("reservation_layer3");
        }
    }

    private void set_type_1_timetable(){
        btn_menu_map.get("1").setText("0900-1100");
        btn_menu_map.get("2").setText("1100-1300");
        btn_menu_map.get("3").setText("1300-1500");
        btn_menu_map.get("4").setText("1500-1700");
        btn_menu_map.get("5").setText("1700-1900");
        btn_menu_map.get("6").setText("1900-2100");
        btn_menu_map.get("7").setText("2100-2300");
        btn_menu_map.get("8").setVisibility(View.VISIBLE);
        btn_menu_map.get("9").setVisibility(View.VISIBLE);
    }

    private void set_timebtn_disable(){
        btn_menu_map.get("2").setBackgroundColor(Color.GRAY);
        btn_menu_map.get("2").setClickable(false);
        btn_menu_map.get("3").setBackgroundColor(Color.GRAY);
        btn_menu_map.get("3").setClickable(false);
        btn_menu_map.get("5").setBackgroundColor(Color.GRAY);
        btn_menu_map.get("5").setClickable(false);
        btn_menu_map.get("8").setBackgroundColor(Color.GRAY);
        btn_menu_map.get("8").setClickable(false);
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
