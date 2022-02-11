package com.smd.foodmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smd.foodmaster.R;
import com.smd.foodmaster.model.CategoryItem;

import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViwHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;

    @NonNull
    @Override
    public CategoryItemViwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViwHolder(LayoutInflater.from(context).inflate(R.layout.category_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViwHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static final class CategoryItemViwHolder extends RecyclerView.ViewHolder{
        public CategoryItemViwHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
