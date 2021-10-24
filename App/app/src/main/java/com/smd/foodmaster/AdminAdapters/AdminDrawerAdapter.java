package com.smd.foodmaster.AdminAdapters;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDrawerAdapter extends RecyclerView.Adapter<AdminDrawerAdapter.ViewHolder> {

    private List<AdminDrawerItem<ViewHolder>> items;
    private Map<Class<? extends AdminDrawerItem>,Integer>  viewType;
    private SparseArray<AdminDrawerItem<ViewHolder>> holderFactories;

    private OnItemSelectedListener listner;

    public AdminDrawerAdapter(List<AdminDrawerItem<ViewHolder>> items){
        this.items = items;
        this.viewType = new HashMap<>();
        this.holderFactories = new SparseArray<>();
        processViewType();
    }

    private void processViewType() {
        int type = 0;
        for(AdminDrawerItem item : items){
            if(!viewType.containsKey(item.getClass())){
                viewType.put(item.getClass(),type);
                holderFactories.put(type,item);
                type++;
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder = holderFactories.get(viewType).createViewHolder(parent);
        holder.adminDrawerAdapter = this;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        items.get(position).bindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return viewType.get(items.get(position).getClass());
    }

    public void setSelected(int position){
        AdminDrawerItem newChecked = items.get(position);
        if(!newChecked.isSelectable()){
            return;
        }

        for(int i=0; i<items.size(); i++){
            AdminDrawerItem item = items.get(i);
            if(item.isChecked()){
                item.setChecked(false);
                notifyItemChanged(i);
                break;
            }
        }

        newChecked.setChecked(true);
        notifyItemChanged(position);

        if(listner != null){
            listner.onItemSelected(position);
        }
    }

    public void setListner(OnItemSelectedListener listner){
        this.listner = listner;
    }

    public interface OnItemSelectedListener{
        void onItemSelected(int position);
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private AdminDrawerAdapter adminDrawerAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            adminDrawerAdapter.setSelected(getAdapterPosition());
        }
    }
}
