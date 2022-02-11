package com.smd.foodmaster.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smd.foodmaster.R;
import com.smd.foodmaster.model.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{


    private List<Food> foodList;

    public void setData(List<Food> foodList){
        this.foodList = foodList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        if(food == null){
            return;
        }

        holder.foodImage.setImageResource(food.getResourceId());
        holder.foodTitle.setText(food.getTitle());
        holder.foodDescription.setText(food.getDescription());
    }

    @Override
    public int getItemCount() {
        if(foodList != null){
            return foodList.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView foodImage;
        private TextView foodTitle;
        private TextView foodDescription;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = (ImageView) itemView.findViewById(R.id.img_food);
            foodTitle = (TextView) itemView.findViewById(R.id.food_title);
            foodDescription = (TextView) itemView.findViewById(R.id.food_description);
        }
    }
}
