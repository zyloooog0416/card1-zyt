package com.example.myapplication8.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication8.R;
import com.example.myapplication8.fragment.MainFragment;
import com.example.myapplication8.fragment.SearchFragment;
import com.example.myapplication8.util.ApplicationUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout ll_main, ll_search;

    private MainFragment mainFragment;
    private SearchFragment searchFragment;

    private List<Fragment> fragmentList = new ArrayList<>();

    private ImageView img_main, img_search;
    private TextView text_main, text_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        ll_main.setOnClickListener(this);
        ll_search.setOnClickListener(this);

        ApplicationUtil.getInstance().addActivity(this);
    }

    private void initView() {
        ll_main=(LinearLayout)findViewById(R.id.layout_main);
        ll_search=(LinearLayout)findViewById(R.id.layout_search);

        text_main = (TextView) findViewById(R.id.text_main);
        text_search = (TextView) findViewById(R.id.text_search);


        img_main = (ImageView) findViewById(R.id.img_main);
        img_search =(ImageView) findViewById(R.id.img_search);

        img_main.setImageResource(R.drawable.bmob_update_btn_check_off_focused_holo_light);
        text_main.setTextColor(Color.RED);


    }

    private void initFragment() {
        mainFragment = new MainFragment();
        addFragment(mainFragment);
        showFragment(mainFragment);
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.add(R.id.main_content, fragment).commit();
            fragmentList.add(fragment);
        }

    }

    private void showFragment(Fragment fragment) {
        for (Fragment frag : fragmentList) {
            if (frag != fragment) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.hide(frag).commit();
            }
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.show(fragment).commit();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_main: {
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                }
                addFragment(mainFragment);
                showFragment(mainFragment);
                text_main.setTextColor(Color.RED);
                text_search.setTextColor(Color.BLACK);


                img_main.setImageResource(R.drawable.bmob_update_btn_check_off_focused_holo_light);
                img_search.setImageResource(R.drawable.search);

            }
            break;
            case R.id.layout_search: {
                if (searchFragment == null) {
                    searchFragment = new SearchFragment();
                }
                addFragment(searchFragment);
                showFragment(searchFragment);
                text_search.setTextColor(Color.RED);
                text_main.setTextColor(Color.BLACK);

                img_main.setImageResource(R.drawable.bmob_update_btn_check_off_focused_holo_light);
                img_search.setImageResource(R.drawable.search);
            }
            break;
            default:
                break;
        }

    }
}
