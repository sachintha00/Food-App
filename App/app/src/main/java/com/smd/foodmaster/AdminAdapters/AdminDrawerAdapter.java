package com.smd.foodmaster.AdminAdapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdminDrawerAdapter extends RecyclerView.Adapter<AdminDrawerAdapter.ViewHolder> {

    static abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private AdminDrawerAdapter adminDrawerAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
