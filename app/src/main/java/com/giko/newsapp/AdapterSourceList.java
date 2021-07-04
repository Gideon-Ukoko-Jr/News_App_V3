package com.giko.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
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
        //Inflating layout row_source_list.xml
        View view = LayoutInflater.from(context).inflate(R.layout.row_source_list, parent, false);
        return new HolderSourceList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSourceList.HolderSourceList holder, int position) {
        //Getting data
        ModelSourceList modelSourceList = sourceLists.get(position);
        String id = modelSourceList.getId();
        String name = modelSourceList.getName();
        String description = modelSourceList.getDescription();
        String country = modelSourceList.getCountry();
        String category = modelSourceList.getCategory();
        String language = modelSourceList.getLanguage();

        //Setting data to layout row_source_list.xml widgets
        holder.tvName.setText(name);
        holder.tvDescription.setText(description);
        holder.tvCountry.setText("Country: " + country);
        holder.tvCategory.setText("Category: " + category);
        holder.tvLanguage.setText("Language: " + language);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return sourceLists.size();
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
