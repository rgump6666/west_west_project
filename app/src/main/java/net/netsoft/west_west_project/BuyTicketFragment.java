package net.netsoft.west_west_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.netsoft.west_west_project.data.UserData;

/**
 * Created by HCKH on 26/2/2018.
 */

public class BuyTicketFragment extends FragmentActivity {

    private SharedPreferences settings;
    private UserData user_data = new UserData();

    Button btn_back;

    TextView tv_ticket_type_1;
    TextView tv_ticket_type_2;
    TextView tv_ticket_type_3;
    TextView tv_ticket_type_1_num;
    TextView tv_ticket_type_2_num;
    TextView tv_ticket_type_3_num;
    TextView tv_ticket_type_1_add;
    TextView tv_ticket_type_2_add;
    TextView tv_ticket_type_3_add;
    Button btn_buy;

    private String username;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_buy_ticket);

        settings = getSharedPreferences("DATA", 0);
        username = settings.getString("username", "");

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_ticket_type_1 = (TextView) findViewById(R.id.tv_ticket_type_1);
        tv_ticket_type_2 = (TextView) findViewById(R.id.tv_ticket_type_2);
        tv_ticket_type_3 = (TextView) findViewById(R.id.tv_ticket_type_3);
        tv_ticket_type_1_num = (TextView) findViewById(R.id.tv_ticket_type_1_num);
        tv_ticket_type_2_num = (TextView) findViewById(R.id.tv_ticket_type_2_num);
        tv_ticket_type_3_num = (TextView) findViewById(R.id.tv_ticket_type_3_num);
        tv_ticket_type_1_add = (TextView) findViewById(R.id.tv_ticket_type_1_add);
        tv_ticket_type_2_add = (TextView) findViewById(R.id.tv_ticket_type_2_add);
        tv_ticket_type_3_add = (TextView) findViewById(R.id.tv_ticket_type_3_add);
        btn_buy = (Button) findViewById(R.id.btn_buy);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });


        if(user_data.userData.get(username)[2] != null){
            if(user_data.userData.get(username)[2].equals("1")){
                tv_ticket_type_1.setText("$8");
                tv_ticket_type_2.setText("$35");
                tv_ticket_type_3.setText("$65");
            }else if(user_data.userData.get(username)[2].equals("0")){
                tv_ticket_type_1.setText("$10");
                tv_ticket_type_2.setText("$45");
                tv_ticket_type_3.setText("$80");
            }else{
                Toast.makeText(this, "Wrong Vip Value", Toast.LENGTH_SHORT);
                finish();
            }
        }

        tv_ticket_type_1_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv_ticket_type_1_num.setText(""+(Integer.parseInt(tv_ticket_type_1_num.getText().toString())+1));
            }
        });
        tv_ticket_type_2_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv_ticket_type_2_num.setText(""+(Integer.parseInt(tv_ticket_type_2_num.getText().toString())+1));
            }
        });
        tv_ticket_type_3_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv_ticket_type_3_num.setText(""+(Integer.parseInt(tv_ticket_type_3_num.getText().toString())+1));
            }
        });
        btn_buy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BuyTicketFragment.this, BuyTicketLayer1.class);
                Bundle b = new Bundle();
                b.putInt("buy_ticket_type_1", Integer.parseInt(tv_ticket_type_1.getText().toString().replace("$","")));
                b.putInt("buy_ticket_type_2", Integer.parseInt(tv_ticket_type_2.getText().toString().replace("$","")));
                b.putInt("buy_ticket_type_3", Integer.parseInt(tv_ticket_type_3.getText().toString().replace("$","")));
                b.putInt("buy_ticket_type_1_num", Integer.parseInt(tv_ticket_type_1_num.getText().toString()));
                b.putInt("buy_ticket_type_2_num", Integer.parseInt(tv_ticket_type_2_num.getText().toString()));
                b.putInt("buy_ticket_type_3_num", Integer.parseInt(tv_ticket_type_3_num.getText().toString()));
                intent.putExtras(b);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 2){
            Intent intent = new Intent();
            setResult(resultCode,intent);
            finish();
        }
    }
}
