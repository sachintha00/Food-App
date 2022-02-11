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
import com.smd.foodmaster.adapter.CategoryAdapter;
import com.smd.foodmaster.databinding.FragmentHomeBinding;
import com.smd.foodmaster.model.Category;
import com.smd.foodmaster.model.Food;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private View root;

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView_main);
        categoryAdapter = new CategoryAdapter(getActivity());
//        button = (Button) root.findViewById(R.id.home_submit_btn);
//        editText = (EditText) root.findViewById(R.id.home_edit_text);

//        Toast.makeText(getActivity(), "editText.getText().toString()", Toast.LENGTH_SHORT).show();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        categoryAdapter.setData(getListOfCategory());
        recyclerView.setAdapter(categoryAdapter);

//        mainCategoryRecycler = (RecyclerView) root.findViewById(R.id.recyclerView_main);
//        mainCategoryRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mainCategoryRecycler.setAdapter(new MainRecyclerAdapter(getActivity(),categoryList));



//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        mainRecyclerAdapter = new MainRecyclerAdapter(getActivity(),categoryList);
//        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);


        return root;
    }

    private List<Category> getListOfCategory() {
        List<Category> list = new ArrayList<>();

        List<Food> listFood = new ArrayList<>();
        listFood.add(new Food(R.drawable.image_avatar_1,"sachintha","Lorem Ipsum"));
        listFood.add(new Food(R.drawable.image_avatar_1,"madhawa","Lorem Ipsum"));
        listFood.add(new Food(R.drawable.image_avatar_1,"deniyegedara","Lorem Ipsum"));
        listFood.add(new Food(R.drawable.image_avatar_1,"ashani","Lorem Ipsum"));

        listFood.add(new Food(R.drawable.image_avatar_1,"dilanka","Lorem Ipsum"));
        listFood.add(new Food(R.drawable.image_avatar_1,"wkramathunga","Lorem Ipsum"));
        listFood.add(new Food(R.drawable.image_avatar_1,"Koththu","Lorem Ipsum"));
        listFood.add(new Food(R.drawable.image_avatar_1,"Koththu","Lorem Ipsum"));

        list.add(new Category("Category 1",listFood));
        list.add(new Category("Category 2",listFood));
        list.add(new Category("Category 3",listFood));
        list.add(new Category("Category 4",listFood));

        return list;
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