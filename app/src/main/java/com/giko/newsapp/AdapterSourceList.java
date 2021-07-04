package com.giko.newsapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSourceList extends RecyclerView.Adapter<AdapterSourceList.HolderSourceList> {

    private Context context;
    private ArrayList<ModelSourceList> sourceLists;

    public AdapterSourceList(Context context, ArrayList<ModelSourceList> sourceLists) {
        this.context = context;
        this.sourceLists = sourceLists;
    }

    @NonNull
    @Override
    public HolderSourceList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSourceList.HolderSourceList holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HolderSourceList extends RecyclerView.ViewHolder {

        //Widgets from layout row_source_list.xml
        TextView tvName;
        TextView tvDescription;
        TextView tvCountry;
        TextView tvCategory;
        TextView tvLanguage;

        public HolderSourceList(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvLanguage = itemView.findViewById(R.id.tvLanguage);
        }
    }
}
