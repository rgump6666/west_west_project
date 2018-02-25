package net.netsoft.west_west_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import net.netsoft.west_west_project.data.StrokeData;
import net.netsoft.west_west_project.data.UserData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends FragmentActivity {

    private UserData user_data = new UserData();
    private StrokeData stroke_data = new StrokeData();

    private SharedPreferences settings;
    private String username = null;
    private String userid;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.ic_menu_camera,R.drawable.ic_menu_gallery};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    Button btn_back;
    Button btn_menu_1;
    Button btn_menu_2;
    Button btn_menu_3;
    Button btn_menu_4;
    Button btn_menu_5;
    Button btn_menu_6;
    ViewPager viewPager;
    TextView tv_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences("DATA", 0);

        getPassedParameter();

        set_frontend_element();

        if(!username.equals("-1")) {
            if(user_data.userData.get(username)[0] != null) {
                userid = user_data.userData.get(username)[1];
            }else{
                userid = "";
            }
            tv_username.setText(userid);
        }
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        tv_username = (TextView) findViewById(R.id.tv_username);
        btn_menu_1 = (Button) findViewById(R.id.btn_menu_1);
        btn_menu_2 = (Button) findViewById(R.id.btn_menu_2);
        btn_menu_3 = (Button) findViewById(R.id.btn_menu_3);
        btn_menu_4 = (Button) findViewById(R.id.btn_menu_4);
        btn_menu_5 = (Button) findViewById(R.id.btn_menu_5);
        btn_menu_6 = (Button) findViewById(R.id.btn_menu_6);

        btn_back.setText("登出");

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        btn_menu_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservationFragment.class);
                Bundle b = new Bundle();
                b.putSerializable("stroke_data", stroke_data);
                intent.putExtras(b);
                startActivityForResult(intent, 0);
            }
        });
        btn_menu_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyStrokeFragment.class);
                Bundle b = new Bundle();
                b.putSerializable("stroke_data", stroke_data);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        btn_menu_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiscountFragment.class);
                startActivity(intent);
            }
        });
        btn_menu_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsFragment.class);
                startActivity(intent);
            }
        });
        if(username.equals("-1")) {
            btn_menu_5.setBackgroundColor(Color.GRAY);
            btn_menu_5.setClickable(false);
        }else{
            btn_menu_5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, BuyTicketFragment.class);
                    startActivityForResult(intent, 0);
                }
            });
        }
        btn_menu_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutUsFragment.class);
                startActivity(intent);
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void getPassedParameter(){
        Bundle b = getIntent().getExtras();
        if(b != null) {
            username = b.getString("username");
            settings.edit().putString("username", username).commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            if(data.getSerializableExtra("stroke_data") != null) {
                stroke_data = (StrokeData) data.getSerializableExtra("stroke_data");
                Toast.makeText(this, "finish reservation", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "fail reservation", Toast.LENGTH_SHORT).show();
            }
        }else if(resultCode == 2){
            Toast.makeText(this, "finish buying ticket", Toast.LENGTH_SHORT).show();
        }
    }
}
