package com.example.riddhi.coronatracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<DemoStatewiseModel> {

    private Context context;
    private List<DemoStatewiseModel> stateModelList;

    public CustomAdapter(@NonNull Context context, List<DemoStatewiseModel> stateModelList) {
        super(context, R.layout.list_state_item, stateModelList);

        this.context = context;
        this.stateModelList = stateModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_state_item, null, true);
        TextView tvStateName = view.findViewById(R.id.tvStateName);
        TextView tvConfirmed = view.findViewById(R.id.tvConfirmed);
        TextView tvRecovered = view.findViewById(R.id.tvRecovered);
        TextView tvDeaths = view.findViewById(R.id.tvDeaths);
        TextView tvActive = view.findViewById(R.id.tvActive);

        DemoStatewiseModel statewiseModel = stateModelList.get(position);
        tvStateName.setText(statewiseModel.getState());
        tvConfirmed.setText(String.valueOf(statewiseModel.getConfirmed()));
        tvRecovered.setText(String.valueOf(statewiseModel.getRecovered()));
        tvDeaths.setText(String.valueOf(statewiseModel.getDeaths()));
        tvActive.setText(String.valueOf(statewiseModel.getActive()));

        return view;
    }

    @Override
    public int getCount() {
        return stateModelList.size();
    }

    @Nullable
    @Override
    public DemoStatewiseModel getItem(int position) {
        return stateModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return super.getFilter();
    }
}
