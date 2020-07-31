package com.example.coronatracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coronatracker.Model.MyResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText searchCountryEt;
    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;
    private List<Country> countries;
    private String country_name;
    private Context context;

    ArrayList<Country> mItemList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            country_name=savedInstanceState.getString("searchCountry");
        }
        setContentView(R.layout.activity_main);
        init();
        populateDataToRecyclearView();

        searchCountryEt.addTextChangedListener(
                new addListenerOnTextChange(this,searchCountryEt,countries,recyclerView));






    }



    private void populateDataToRecyclearView() {
        countries=new ArrayList<Country>();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        JsonPlaceHolderApi jsonPlaceHolderApi=retrofit.create(JsonPlaceHolderApi.class);
        Call<List<MyResponse>> call=jsonPlaceHolderApi.getData();

        call.enqueue(new Callback<List<MyResponse>>() {
            @Override
            public void onResponse(Call<List<MyResponse>> call, Response<List<MyResponse>> response) {


                if (!response.isSuccessful()) {
                    return;
                }
                List<MyResponse> data = response.body();
                for (MyResponse result : data) {
                    countries.add(new Country(String.valueOf(result.getDeaths()),result.getCountry(),
                            String.valueOf(result.getCases()),
                            String.valueOf(result.getTodayDeaths()),
                            String.valueOf(result.getActive()),
                            String.valueOf(result.getRecovered())));

                }

                countryAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<MyResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "dkfj", Toast.LENGTH_SHORT).show();


            }
        });
        




        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        countryAdapter=new CountryAdapter(this,countries);
        recyclerView.setAdapter(countryAdapter);

    }

    private void init() {
        searchCountryEt=findViewById(R.id.searchCountryEt);
        recyclerView=findViewById(R.id.recyclearView);


        //countryAdapter=new CountryAdapter(getApplicationContext(),countries);

    }


    @Override
    protected void onResume() {
        super.onResume();
        country_name=searchCountryEt.getText().toString();
            countryAdapter  = new CountryAdapter(this,countries);
            recyclerView.setAdapter(countryAdapter);
            countryAdapter.notifyDataSetChanged();



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        country_name=searchCountryEt.getText().toString().trim();
        outState.putString("searchCountry",country_name);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        //searchCountryEt.setText(savedInstanceState.getString("serachCountry",country_name));
       // searchCountryEt.setText(country_name);


    }
}