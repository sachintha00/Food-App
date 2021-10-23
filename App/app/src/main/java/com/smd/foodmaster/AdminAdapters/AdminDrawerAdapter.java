package com.smd.foodmaster.AdminAdapters;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDrawerAdapter extends RecyclerView.Adapter<AdminDrawerAdapter.ViewHolder> {

    private List<AdminDrawerItem> items;
    private Map<Class<? extends AdminDrawerItem>,Integer>  viewType;
    private SparseArray<AdminDrawerItem> holderFactories;

    public AdminDrawerAdapter(List<AdminDrawerItem> items){
        this.items = items;
        this.viewType = new HashMap<>();
        this.holderFactories = new SparseArray<>();
        processViewType();
    }

    private void processViewType() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder = holderFactories.get(viewType).createViewHolder(parent);
        holder.
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private AdminDrawerAdapter adminDrawerAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
