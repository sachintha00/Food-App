package com.smd.foodmaster.AdminClasses;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.smd.foodmaster.AdminAdapters.AdminDrawerAdapter;
import com.smd.foodmaster.AdminAdapters.AdminDrawerItem;

public class SpaceItem extends AdminDrawerItem<SpaceItem.ViewHolder> {

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {

    }

    public class ViewHolder extends AdminDrawerAdapter.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
