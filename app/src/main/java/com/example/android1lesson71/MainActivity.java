package com.example.android1lesson71;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private View fragmentView;
    private boolean mViewFragment = false;
    public static String KEY = "key";
    public static String KEY2 = "key2";
    public static String KEY3 = "key3";
    private View FragmentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentView = findViewById(R.id.fragment_second);

        if (fragmentView != null) {
            mViewFragment = true;
        }
        if (mViewFragment) {//true
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_first, new ChangeFragment());
            transaction.commit();

        }
    }

    public void displayDetails(String title, String subTitle, int imageResourceID) {

        View fragmentView = findViewById(R.id.fragment_second);

        if (fragmentView != null) {//если не в landscape то просто перезаписывет нажатое
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_second, TextFragment.newInstance(title, subTitle, imageResourceID));
            transaction.commit();
        } else {//иначе все как в режиме layout
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(KEY, title);
            intent.putExtra(KEY2, subTitle);
            intent.putExtra(KEY3, imageResourceID);
            startActivity(intent);
        }
    }
}