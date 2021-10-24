package com.smd.foodmaster.AdminClasses;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.smd.foodmaster.AdminAdapters.AdminDrawerAdapter;
import com.smd.foodmaster.AdminAdapters.AdminDrawerItem;
import com.smd.foodmaster.R;

public class Item extends AdminDrawerItem<Item.ViewHolder> {

    private int selectedItemIconTint;
    private int selectedItemTextTint;

    private int normalItemIconTint;
    private int normalItemTextTint;

    private Drawable icon;
    private String title;

    public Item(Drawable icon, String title){
        this.icon = icon;
        this.title = title;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.admin_menu_item_option,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {

    }

    static class ViewHolder extends AdminDrawerAdapter.ViewHolder{

        private ImageView icon;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.admin_icon);
            title = itemView.findViewById(R.id.admin_title);
        }
    }
}
