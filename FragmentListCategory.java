package com.fit2081.assignment12081;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentListCategory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentListCategory extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    MyRecyclerAdapter recyclerAdapter;

    ArrayList<AddCategoryNavDrawer> data = new ArrayList<>();

    public FragmentListCategory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentListCategory.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentListCategory newInstance(String param1, String param2) {
        FragmentListCategory fragment = new FragmentListCategory();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_category, container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences(KeyStore.FILE_NAME, Context.MODE_PRIVATE);

        String addCategoryList = sharedPreferences.getString(KeyStore.KEY_ARRAY_LIST_ID, "[]");
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<AddCategoryNavDrawer>>() {}.getType();
        data = gson.fromJson(addCategoryList,type);




        RecyclerView recyclerView = view.findViewById(R.id.category_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        recyclerAdapter = new MyRecyclerAdapter();
        recyclerAdapter.setData(data);
        recyclerView.setAdapter(recyclerAdapter);


        return view;

    }


    public void refreshData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(KeyStore.FILE_NAME, Context.MODE_PRIVATE);
        String addCategoryList = sharedPreferences.getString(KeyStore.KEY_ARRAY_LIST_ID, "[]");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<AddCategoryNavDrawer>>() {}.getType();
        ArrayList<AddCategoryNavDrawer> newData = gson.fromJson(addCategoryList, type);

        recyclerAdapter.setData(newData != null ? newData : new ArrayList<>());
        recyclerAdapter.notifyDataSetChanged();
    }



}