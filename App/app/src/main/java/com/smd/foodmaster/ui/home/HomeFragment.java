package com.smd.foodmaster.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smd.foodmaster.R;
import com.smd.foodmaster.adapter.MainRecyclerAdapter;
import com.smd.foodmaster.databinding.FragmentHomeBinding;
import com.smd.foodmaster.model.Category;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    View root;

    RecyclerView mainCategoryRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        root = inflater.inflate(R.layout.fragment_home, container, false);
//        button = (Button) root.findViewById(R.id.home_submit_btn);
//        editText = (EditText) root.findViewById(R.id.home_edit_text);

//        Toast.makeText(getActivity(), "editText.getText().toString()", Toast.LENGTH_SHORT).show();


        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Sachintha"));
        categoryList.add(new Category("Madhawa"));
        categoryList.add(new Category("Deniyegedara"));

        mainCategoryRecycler = (RecyclerView) root.findViewById(R.id.recyclerView_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mainRecyclerAdapter = new MainRecyclerAdapter(getActivity(),categoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);

        return root;
    }

//    private void setMainCategoryRecycler(List<Category> categoryList){
//        mainCategoryRecycler = (RecyclerView) root.findViewById(R.id.recyclerView_main);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        mainRecyclerAdapter = new MainRecyclerAdapter(getActivity(),categoryList);
//        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}