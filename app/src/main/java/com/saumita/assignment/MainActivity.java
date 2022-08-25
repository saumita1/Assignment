package com.saumita.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText loginUsername, loginPassword;
    Button btnLogin;
    TextView tvMessage;
    private ArrayList<LoginList> loginLists;
    private LoginAdapter loginAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvMessage = findViewById(R.id.tvMessage);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processlogin();
            }
        });
    }

    void processlogin() {
        String username = loginUsername.getText().toString();
        String password = loginPassword.getText().toString();

        if (username.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Please Enter Username & Password", Toast.LENGTH_SHORT).show();
        } else if (username.isEmpty()) {
            Toast.makeText(this, "Please Enter Username", Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        } else {
            Call<LoginResponse> call = LoginApiController
                    .getInstance()
                    .getapi()
                    .verifyuser(username, password);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    LoginResponse obj = response.body();
                    try {
                        String output = obj.getStatus();
                        if (!output.equals("1")) {
                            loginPassword.setText("");
                            tvMessage.setText(response.message());
                        }
                        if (output.equals("1")) {
                            LoginResponse loginResponse = response.body();
                            loginLists = new ArrayList<>(Arrays.asList(loginResponse.getData()));
                            loginAdapter = new LoginAdapter(loginLists);

                            Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("loginLists", loginLists);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    } catch (Exception e) {
                        tvMessage.setText("Invalid Username or Password");
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    tvMessage.setText(t.toString());
                }
            });
        }
    }
}