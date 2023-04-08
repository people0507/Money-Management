package com.example.moneymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moneymanagement.model2.User;
import com.example.moneymanagement.model2.UserDao;
import com.example.moneymanagement.model2.UserDatabaseClass;

public class SignupActivity extends AppCompatActivity {

    Button button;
    EditText name_ed,email_ed,pass_ed;
    private UserDao userDao;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup2);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        name_ed = findViewById(R.id.name_signup);
        email_ed = findViewById(R.id.email_signup);
        pass_ed = findViewById(R.id.pass_signup);
        button = findViewById(R.id.create_signup);
        userDao = Room.databaseBuilder(this, UserDatabaseClass.class,"UserDb").allowMainThreadQueries().build().getUserDao();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isEmpty()){
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(name_ed.getText().toString(),email_ed.getText().toString(),pass_ed.getText().toString());
                            userDao.insert(user);
                            progressDialog.dismiss();
                            startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                        }
                    },1000);
                }
                else {
                    Toast.makeText(SignupActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty(name_ed.getText().toString()) || TextUtils.isEmpty(email_ed.getText().toString()) || TextUtils.isEmpty(pass_ed.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }
}