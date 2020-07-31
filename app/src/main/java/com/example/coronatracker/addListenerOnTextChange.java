package com.example.coronatracker;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class addListenerOnTextChange implements TextWatcher {
    private Context context;
    private EditText mEditTextView;
    private List<Country> countries;
    private CountryAdapter adapter;
    private RecyclerView recyclerView;

    public addListenerOnTextChange(Context context, EditText mEditTextView,List<Country> countries,RecyclerView recyclerView) {
        this.context = context;
        this.mEditTextView = mEditTextView;
        this.countries=countries;
        this.recyclerView=recyclerView;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


    }

    @Override
    public void afterTextChanged(Editable editable) {
        List<Country> filteredList=new ArrayList<>();
        for(Country country : countries){
            if(country.getCountry_name().toLowerCase().contains(editable.toString().toLowerCase())){
                filteredList.add(country);
                //Toast.makeText(context, country.getCountry_name(), Toast.LENGTH_SHORT).show();

            }
        }
            adapter= new CountryAdapter(context,filteredList);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();











    }


}
