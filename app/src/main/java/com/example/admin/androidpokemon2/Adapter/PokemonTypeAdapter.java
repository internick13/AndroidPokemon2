package com.example.admin.androidpokemon2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.androidpokemon2.Common.Common;
import com.example.admin.androidpokemon2.Interface.IItemClickListener;
import com.example.admin.androidpokemon2.R;
import com.robertlevonyan.views.chip.Chip;
import com.robertlevonyan.views.chip.OnChipClickListener;

import java.util.List;

public class PokemonTypeAdapter extends RecyclerView.Adapter<PokemonTypeAdapter.MyViewHolder> {
    Context context;
    List<String> typeList;

    public PokemonTypeAdapter(Context context, List<String> typeList) {
        this.context = context;
        this.typeList = typeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.chip_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.chip.setChipText(typeList.get(position));
        holder.chip.changeBackgroundColor(Common.getColorByType(typeList.get(position)));

        holder.setItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View view, int position) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Chip chip;
        IItemClickListener itemClickListener;

        public void setItemClickListener(IItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            chip = itemView.findViewById(R.id.chip);
            chip.setOnChipClickListener(new OnChipClickListener() {
                @Override
                public void onChipClick(View v) {
                    itemClickListener.onClick(v, getAdapterPosition());
                }
            });
        }
    }
}
