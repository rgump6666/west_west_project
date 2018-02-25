package net.netsoft.west_west_project;

import android.content.Intent;
import android.net.Uri;
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

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        btn_promotion_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sunball3.com/"));
                startActivity(browserIntent);
            }
        });
        btn_promotion_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goma.com.hk/"));
                startActivity(browserIntent);
            }
        });
        btn_promotion_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.underarmour.hk/Activity/cny2018?utm_source=google&utm_campaign=HK-%E6%A0%B8%E5%BF%83%E5%93%81%E7%89%8C%E8%A9%9E&utm_adgroup=HK-%E6%A0%B8%E5%BF%83%E5%93%81%E7%89%8C%E8%A9%9E%EF%BC%88%E7%B2%BE%E7%A2%BA%EF%BC%89&utm_term=under%20armour&utm_medium=search_cpc&utm_channel=SEM"));
                startActivity(browserIntent);
            }
        });
        btn_promotion_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/SoccerFunHongKong/"));
                startActivity(browserIntent);
            }
        });
        btn_promotion_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sportshouse.com/web/sp/home/index.html"));
                startActivity(browserIntent);
            }
        });
    }
}
