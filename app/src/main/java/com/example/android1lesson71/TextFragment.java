package com.example.android1lesson71;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TextFragment extends Fragment {

    private TextView textView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";


    private String mParam1;
    private String mParam2;
    private int mParam3;

    private TextView txtTitle;
    private TextView txtSubTitle;
    private ImageView imageView;


    public TextFragment() {
    }


    public static TextFragment newInstance(String param1, String param2, int param3) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3=getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        txtTitle=view.findViewById(R.id.txtTitle);
        txtSubTitle=view.findViewById(R.id.txtSubTitle);
        imageView=view.findViewById(R.id.imageView);

        txtTitle.setText(mParam1);
        txtSubTitle.setText(mParam2);
        imageView.setImageResource(mParam3);
        return view;
    }

    void displayDetails(String title, String subTitles, int imageResourceID){
        txtSubTitle.setText(subTitles);
        txtTitle.setText(title);
        imageView.setImageResource(imageResourceID);

    }
}