package com.example.parsetagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import  androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RatiosAdapter extends RecyclerView.Adapter<RatiosAdapter.ViewHolder>{

    private Context context;
    private List<Ratio> ratios;

    public RatiosAdapter(Context context, List<Ratio> ratios){
        this.context=context;
        this.ratios=ratios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ratio, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ratio ratio = ratios.get(position);
        holder.bind(ratio);
    }

    @Override
    public int getItemCount() {
        return ratios.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvFoodName;
        private TextView tvRatio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFoodName=itemView.findViewById(R.id.tvFoodName);
            tvRatio=itemView.findViewById(R.id.tvRatio);
        }

        public void bind(Ratio ratio) {
            tvRatio.setText(ratio.getRatio()+ " grams of carbs per ounce");
            tvFoodName.setText(ratio.getName());
        }
    }

}
