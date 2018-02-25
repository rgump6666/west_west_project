package net.netsoft.west_west_project.reservation_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.netsoft.west_west_project.R;
import net.netsoft.west_west_project.data.ReservationData;
import net.netsoft.west_west_project.data.StrokeData;

/**
 * Created by HCKH on 22/2/18.
 */

public class ReservationLayer1 extends FragmentActivity {

    private StrokeData stroke_data;
    private ReservationData reservation_data = new ReservationData();

    private String reservation_type;

    Button btn_back;
    Button btn_menu_1;
    Button btn_menu_2;
    Button btn_menu_3;
    TextView tv_title_2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reservation_layer1);

        getPassedParameter();

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_menu_1 = (Button) findViewById(R.id.btn_menu_1);
        btn_menu_2 = (Button) findViewById(R.id.btn_menu_2);
        btn_menu_3 = (Button) findViewById(R.id.btn_menu_3);
        tv_title_2 = (TextView) findViewById(R.id.tv_title_2);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        btn_menu_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ReservationLayer1.this, ReservationLayer2.class);
                Bundle b = new Bundle();
                b.putSerializable("stroke_data", stroke_data);
                b.putString("reservation_type", reservation_type);
                b.putString("reservation_layer1", "1");
                intent.putExtras(b);
                startActivityForResult(intent, 0);
            }
        });
        btn_menu_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ReservationLayer1.this, ReservationLayer2.class);
                Bundle b = new Bundle();
                b.putSerializable("stroke_data", stroke_data);
                b.putString("reservation_type", reservation_type);
                b.putString("reservation_layer1", "2");
                intent.putExtras(b);
                startActivityForResult(intent, 0);
            }
        });
        btn_menu_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ReservationLayer1.this, ReservationLayer2.class);
                Bundle b = new Bundle();
                b.putSerializable("stroke_data", stroke_data);
                b.putString("reservation_type", reservation_type);
                b.putString("reservation_layer1", "3");
                intent.putExtras(b);
                startActivityForResult(intent, 0);
            }
        });
        tv_title_2.setText(tv_title_2.getText()+
                " - "+reservation_data.reservation_type_array.get(reservation_type)+
                " - 地區");
    }

    private void getPassedParameter(){
        Bundle b = getIntent().getExtras();
        if(b != null) {
            stroke_data = (StrokeData) b.getSerializable("stroke_data");
            reservation_type = b.getString("reservation_type");
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