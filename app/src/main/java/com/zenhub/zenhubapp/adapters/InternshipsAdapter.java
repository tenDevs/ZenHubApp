package com.zenhub.zenhubapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zenhub.zenhubapp.R;

import java.sql.Timestamp;
import java.util.List;

public class InternshipsAdapter extends RecyclerView.Adapter<InternshipsAdapter.InternshipsViewHolder>{

    Context context;
    List<String> internshipTitlelist;
    List<String> internshipCompanylist;
    List<String> internshipLocationlist;
    List<Timestamp> internshipTimestamplist;

    public InternshipsAdapter(Context context, List<String> internshipTitlelist, List<String> internshipCompanylist, List<String> internshipLocationlist, List<Timestamp> internshipTimestamplist) {
        this.context = context;
        this.internshipTitlelist = internshipTitlelist;
        this.internshipCompanylist = internshipCompanylist;
        this.internshipLocationlist = internshipLocationlist;
        this.internshipTimestamplist = internshipTimestamplist;
    }

    @NonNull
    @Override
    public InternshipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull InternshipsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class InternshipsViewHolder extends RecyclerView.ViewHolder{

        TextView internshipTitle;
        TextView internshipCompany;
        TextView internshipLocation;
        TextView internshipTimestamp;

        public InternshipsViewHolder(@NonNull View itemView) {
            super(itemView);

            internshipTitle = itemView.findViewById(R.id.internship_title_txt);
            internshipCompany = itemView.findViewById(R.id.internship_company_txt);
            internshipLocation = itemView.findViewById(R.id.internship_location_txt);
            internshipTimestamp = itemView.findViewById(R.id.internship_timestamp_txt);
        }
    }
}
