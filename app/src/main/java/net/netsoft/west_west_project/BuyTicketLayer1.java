package net.netsoft.west_west_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.netsoft.west_west_project.data.StrokeData;
import net.netsoft.west_west_project.data.UserData;

/**
 * Created by HCKH on 26/2/2018.
 */

public class BuyTicketLayer1 extends FragmentActivity {

    Button btn_back;

    Button btn_buy;

    private int buy_ticket_type_1;
    private int buy_ticket_type_2;
    private int buy_ticket_type_3;
    private int buy_ticket_type_1_num;
    private int buy_ticket_type_2_num;
    private int buy_ticket_type_3_num;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_buy_ticket_layer1);

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_buy = (Button) findViewById(R.id.btn_buy);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });


        btn_buy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(2,intent);
                finish();
            }
        });
    }

    private void getPassedParameter(){
        Bundle b = getIntent().getExtras();
        if(b != null) {
            buy_ticket_type_1 = b.getInt("buy_ticket_type_1");
            buy_ticket_type_2 = b.getInt("buy_ticket_type_2");
            buy_ticket_type_3 = b.getInt("buy_ticket_type_3");
            buy_ticket_type_1_num = b.getInt("buy_ticket_type_1_num");
            buy_ticket_type_2_num = b.getInt("buy_ticket_type_2_num");
            buy_ticket_type_3_num = b.getInt("buy_ticket_type_3_num");
        }
    }
}