package com.smd.foodmaster.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smd.foodmaster.R;
import com.smd.foodmaster.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    View root;


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

//        mainCategoryRecycler = (RecyclerView) root.findViewById(R.id.recyclerView_main);
//        mainCategoryRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mainCategoryRecycler.setAdapter(new MainRecyclerAdapter(getActivity(),categoryList));



//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        mainRecyclerAdapter = new MainRecyclerAdapter(getActivity(),categoryList);
//        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);


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