package net.netsoft.west_west_project;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by HCKH on 20/2/18.
 */

public class RegisterFragment extends FragmentActivity {

    Button btn_back;
    EditText ed_email;
    EditText ed_password;
    EditText ed_confirm_password;
    EditText ed_username;
    Button btn_submit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);

        set_frontend_element();
    }

    private void set_frontend_element(){
        btn_back = (Button) findViewById(R.id.btn_back);
        ed_email = (EditText) findViewById(R.id.ed_email);
        ed_password = (EditText) findViewById(R.id.ed_password);
        ed_confirm_password = (EditText) findViewById(R.id.ed_confirm_password);
        ed_username = (EditText) findViewById(R.id.ed_username);
        btn_submit = (Button) findViewById(R.id.btn_submit);


        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
