package com.smd.foodmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smd.foodmaster.R;
import com.smd.foodmaster.model.Category;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    Context context;
    List<Category> categoryList;

    public MainRecyclerAdapter(Context context, List<Category> categoryList) {
        Toast.makeText(context.getApplicationContext(), "main recycler adapter ", Toast.LENGTH_SHORT).show();
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Toast.makeText(context.getApplicationContext(), "on create view holder", Toast.LENGTH_SHORT).show();
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycle_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.categoryTitle.setText(categoryList.get(position).getCategoryTitle());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder{
        TextView categoryTitle;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = (TextView) itemView.findViewById(R.id.txt_category_title);
        }
    }
}
