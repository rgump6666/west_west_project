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

/**
 * Created by HCKH on 17/2/18.
 */

public class LoginActivity extends FragmentActivity {

    private String app_username;
    private String default_username = "111";

    private String app_password;
    private String default_password = "222";

    Button btn_back;
    EditText ed_username;
    EditText ed_password;
    Button btn_register;
    Button btn_login;
    Button btn_direct_login;
    TextView tv_error;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        ed_username = (EditText) findViewById(R.id.ed_username);
        ed_password = (EditText) findViewById(R.id.ed_password);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_direct_login = (Button) findViewById(R.id.btn_direct_login);
        tv_error = (TextView) findViewById(R.id.tv_error);

        btn_back.setVisibility(View.GONE);

        btn_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterFragment.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv_error.setText("");

                boolean can_login = false;

                String input_username = ed_username.getText().toString();
                String input_password = ed_password.getText().toString();

                if(!input_username.equals(null) && !input_password.equals(null)) {
                    if (input_username.equals(app_username) || input_username.equals(default_username)) {
                        if (input_password.equals(app_password) || input_password.equals(default_password)) {
                            can_login = true;
                        }
                    }
                }

                if(can_login) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    Bundle b = new Bundle();
                    b.putString("username", input_username);
                    intent.putExtras(b);
                    startActivity(intent);
                }else{
                    tv_error.setText("Wrong password");
                }
            }
        });

        btn_direct_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putString("username", "-1");
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}