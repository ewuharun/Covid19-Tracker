package com.example.coronatracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronatracker.Model.MyResponse;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private Context context;
    private List<Country> countryList;

    public CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.all_country_item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country=countryList.get(position);

        holder.country_name.setText(country.getCountry_name());
        holder.totalCase.setText(country.getTotalCase());
        holder.totalActive.setText(country.getTotalActive());
        holder.totalDeaths.setText(country.getTotalDeaths());
        holder.totalRecovered.setText(country.getTotalRecovered());
        holder.totalNumberOfDeaths.setText(country.getTotalNumberOfDeaths());

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void filter(List<Country> filteredList) {
        countryList=filteredList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView country_name;
        private TextView totalCase;
        private TextView totalDeaths;
        private TextView totalActive;
        private TextView totalRecovered;
        private TextView totalNumberOfDeaths;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            country_name=itemView.findViewById(R.id.country_name);
            totalCase=itemView.findViewById(R.id.totalCase);
            totalActive=itemView.findViewById(R.id.totalActive);
            totalDeaths=itemView.findViewById(R.id.totalDeaths);
            totalRecovered=itemView.findViewById(R.id.totalRecovered);
            totalNumberOfDeaths=itemView.findViewById(R.id.totalNumberOfDeaths);

        }
    }
}
