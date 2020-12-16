package com.example.android1lesson71;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ChangeFragment extends Fragment implements IFragments{


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Destination> list;

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
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
        View view = inflater.inflate(R.layout.fragment_change, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        list=new ArrayList<>();
        list.add(new Destination("Java", "medium", R.drawable.java));
        list.add(new Destination("JS", "easy", R.drawable.js));
        list.add(new Destination("Kotlin", "easy", R.drawable.kotlin));
        list.add(new Destination("C++", "hard", R.drawable.cpluslpus));
        list.add(new Destination("C#", "medium", R.drawable.csharp));
        list.add(new Destination("Python", "easy", R.drawable.python));
        list.add(new Destination("Ruby", "medium", R.drawable.ruby));
        list.add(new Destination("Type-Script", "easy", R.drawable.type_script));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new RecyclerAdapter(list, getContext());
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayDetails(String title, String subTitle,int imageResourceID) {
        MainActivity activity = (MainActivity)getActivity();
        activity.displayDetails(title, subTitle, imageResourceID);
    }

}