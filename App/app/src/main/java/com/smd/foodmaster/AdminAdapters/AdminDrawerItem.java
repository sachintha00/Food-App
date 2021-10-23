package com.smd.foodmaster.AdminAdapters;

import android.view.ViewGroup;

public abstract class AdminDrawerItem<T extends AdminDrawerAdapter.ViewHolder> {

    protected boolean isChecked;
    public abstract T createViewHolder(ViewGroup parent);
    public abstract void bindViewHolder(T holder);
    public AdminDrawerItem<T>setChecked(boolean isChecked){
        this.isChecked = isChecked;
        return this;
    }
    public boolean isChecked(){
        return isChecked;
    }
    public boolean isSelectable(){
        return true;
    }
}
