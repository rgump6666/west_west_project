package net.netsoft.west_west_project;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HCKH on 22/2/18.
 */

public class DiscountFragment extends FragmentActivity {

    Button btn_back;
    Button btn_promotion_1;
    Button btn_promotion_2;
    Button btn_promotion_3;
    Button btn_promotion_4;
    Button btn_promotion_5;
    Button btn_promotion_6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_discount);

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_promotion_1 = (Button) findViewById(R.id.btn_promotion_1);
        btn_promotion_2 = (Button) findViewById(R.id.btn_promotion_2);
        btn_promotion_3 = (Button) findViewById(R.id.btn_promotion_3);
        btn_promotion_4 = (Button) findViewById(R.id.btn_promotion_4);
        btn_promotion_5 = (Button) findViewById(R.id.btn_promotion_5);
        btn_promotion_6 = (Button) findViewById(R.id.btn_promotion_6);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        btn_promotion_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        btn_promotion_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        btn_promotion_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        btn_promotion_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        btn_promotion_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        btn_promotion_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
