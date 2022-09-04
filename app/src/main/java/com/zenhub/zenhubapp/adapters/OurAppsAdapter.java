package com.zenhub.zenhubapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zenhub.zenhubapp.R;

import java.util.List;

public class OurAppsAdapter extends  RecyclerView.Adapter<OurAppsAdapter.OurAppsViewHolder>{

    Context context;
    List<String> OurAppslistTitle;

    public OurAppsAdapter(Context context, List<String> ourAppslistTitle) {
        this.context = context;
        this.OurAppslistTitle = ourAppslistTitle;
    }

    @NonNull
    @Override
    public OurAppsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.our_apps_list_items, parent, false);

        return new OurAppsAdapter.OurAppsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OurAppsViewHolder holder, int position) {
        holder.ourAppsTitle.setText(OurAppslistTitle.get(position));
    }

    @Override
    public int getItemCount() {
        return OurAppslistTitle.size();
    }

    public static class OurAppsViewHolder extends RecyclerView.ViewHolder{

        TextView ourAppsTitle;

        public OurAppsViewHolder(@NonNull View itemView) {
            super(itemView);

            ourAppsTitle = itemView.findViewById(R.id.OurAppsFrgTextView);
        }
    }
}
