package com.saumita.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    RecyclerView recviewHorizontal, recviewVertical;
    private ArrayList<DetailsList> detailsLists;
    private ArrayList<LoginList> loginLists;
    private DetailsAdapter detailsAdapter;
    private LoginAdapter loginAdapter;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        recviewHorizontal = findViewById(R.id.recviewHorizontal);
        recviewVertical = findViewById(R.id.recviewVertical);
        back = findViewById(R.id.back);

        recviewVertical.setLayoutManager(new LinearLayoutManager(this));
        processVerticaldata();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recviewHorizontal.setLayoutManager(linearLayoutManager);

        Bundle bundleObject = getIntent().getExtras();
        loginLists = (ArrayList<LoginList>) bundleObject.getSerializable("loginLists");
        loginAdapter = new LoginAdapter(loginLists);
        recviewHorizontal.setAdapter(loginAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailsActivity.this, MainActivity.class));
            }
        });
    }

    public void processVerticaldata() {
        Call<DetailsResponse> call = DetailsApiController.getInstance().getapi().getVerticalData();

        call.enqueue(new Callback<DetailsResponse>() {
            @Override
            public void onResponse(Call<DetailsResponse> call, Response<DetailsResponse> response) {
                DetailsResponse detailsResponse = response.body();
                detailsLists = new ArrayList<>(Arrays.asList(detailsResponse.getData()));
                detailsAdapter = new DetailsAdapter(detailsLists);
                recviewVertical.setAdapter(detailsAdapter);
            }

            @Override
            public void onFailure(Call<DetailsResponse> call, Throwable t) {
                Toast.makeText(DetailsActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}