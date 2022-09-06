package com.zenhub.zenhubapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.zenhub.zenhubapp.R;
import com.zenhub.zenhubapp.activities.AboutZensarActivity;
import com.zenhub.zenhubapp.activities.ContactUsActivity;
import com.zenhub.zenhubapp.activities.FAQActivity;
import com.zenhub.zenhubapp.activities.MainActivity;
import com.zenhub.zenhubapp.activities.ProfileActivity;
import com.zenhub.zenhubapp.fragments.AboutZensarFragment;
import com.zenhub.zenhubapp.fragments.HomeFragment;

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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int itemPosistion = holder.getAdapterPosition();
                Intent intent;

                switch(itemPosistion){
                    case 0:
                        intent = new Intent(context, AboutZensarActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, FAQActivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, ContactUsActivity.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, AboutZensarActivity.class);
                        context.startActivity(intent);
                        break;
                }

//                if(holder.getAdapterPosition() == 0){
//                    Intent intent = new Intent(context, AboutZensarActivity.class);
//                    context.startActivity(intent);
//                }
            }
        });
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
