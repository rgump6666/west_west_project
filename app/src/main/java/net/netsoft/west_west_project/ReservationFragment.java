package net.netsoft.west_west_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.netsoft.west_west_project.data.StrokeData;
import net.netsoft.west_west_project.reservation_fragment.ReservationLayer1;

/**
 * Created by HCKH on 17/2/18.
 */

public class ReservationFragment extends FragmentActivity {

    private StrokeData stroke_data;

    Button btn_back;
    Button btn_menu_1;
    Button btn_menu_2;
    Button btn_menu_3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reservation);

        stroke_data = (StrokeData) getIntent().getSerializableExtra("stroke_data");

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_menu_1 = (Button) findViewById(R.id.btn_menu_1);
        btn_menu_2 = (Button) findViewById(R.id.btn_menu_2);
        btn_menu_3 = (Button) findViewById(R.id.btn_menu_3);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        btn_menu_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ReservationFragment.this, ReservationLayer1.class);
                Bundle b = new Bundle();
                b.putSerializable("stroke_data", stroke_data);
                b.putString("reservation_type", "1");
                intent.putExtras(b);
                startActivityForResult(intent, 0);
            }
        });
        btn_menu_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ReservationFragment.this, ReservationLayer1.class);
                Bundle b = new Bundle();
                b.putSerializable("stroke_data", stroke_data);
                b.putString("reservation_type", "2");
                intent.putExtras(b);
                startActivityForResult(intent, 0);
            }
        });
        btn_menu_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ReservationFragment.this, ReservationLayer1.class);
                Bundle b = new Bundle();
                b.putSerializable("stroke_data", stroke_data);
                b.putString("reservation_type", "3");
                intent.putExtras(b);
                startActivityForResult(intent, 0);
            }
        });
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