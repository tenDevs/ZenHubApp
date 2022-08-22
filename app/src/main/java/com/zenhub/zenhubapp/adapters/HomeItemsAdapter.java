package com.zenhub.zenhubapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zenhub.zenhubapp.R;

import java.util.List;

public class HomeItemsAdapter extends RecyclerView.Adapter<HomeItemsAdapter.HomeViewHolder> {

    Context context;
    List<String> listTitle;
    List<Integer> listIcon;

    public HomeItemsAdapter(Context context, List<String> listTitle, List<Integer> listIcon) {
        this.context = context;
        this.listTitle = listTitle;
        this.listIcon = listIcon;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_list_items, parent, false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.textView.setText(listTitle.get(position));
        holder.imageView.setImageResource(listIcon.get(position));
    }

    @Override
    public int getItemCount() {
        return listTitle.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.HomeFrgTextView);
            imageView = itemView.findViewById(R.id.HomeFrgImageView);
        }
    }
}
