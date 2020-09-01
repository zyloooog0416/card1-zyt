package com.example.myapplication8.fragment;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication8.JavaBean.Person;
import com.example.myapplication8.R;
import com.example.myapplication8.activity.EditActivity;
import com.example.myapplication8.adapter.NewAdapter;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private View view;
    private ListView listView;
    private List<Fragment> fragmentList;
    private ImageView scanning, img_add;
    private SearchView search;
    private ViewPager viewPager;
    private SearchFragment searchFragment;
    private CustomDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        img_add = view.findViewById(R.id.add);
        ListView listView = view.findViewById(R.id.lv_card);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditActivity.class);
                startActivity(intent);
            }
        });
        Bmob.initialize(getContext(), "0e4efeb8f4a816a01f116edc48fbfd2d");
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.findObjects(new FindListener<Person>() {
            @Override
            public void done(List<Person> list, BmobException e) {
                if (e == null) {
                    Log.d("path", "ch");
                    NewAdapter newAdapte = new NewAdapter(getContext(), R.layout.new_item, list);
                    listView.setAdapter(newAdapte);
                } else {

                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showLostFindDialog(i);
                return false;
            }
        });
        return view;

    }

    private void showLostFindDialog(final int i) {
        dialog = new CustomDialog(getContext(), R.style.mystyle,
                R.layout.dialog, i);
        dialog.show();
    }
    public class CustomDialog extends Dialog implements
            View.OnClickListener {
        int layoutRes;
        Context context;
        private Button bt_update;
        private Button bt_delect;
        private int i;
        public CustomDialog(Context context) {
            super(context);
            this.context = context;
        }

        public CustomDialog(Context context, int resLayout) {
            super(context);
            this.context = context;
            this.layoutRes = resLayout;
        }

        public CustomDialog(Context context, int theme, int resLayout,
                            int i) {
            super(context, theme);
            this.context = context;
            this.layoutRes = resLayout;
            this.i = i;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.setContentView(layoutRes);
            bt_update = (Button) findViewById(R.id.bt_update);
            bt_delect = (Button) findViewById(R.id.bt_delect);
            bt_update.setOnClickListener(this);
            bt_delect.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_delect:
                    deleteItem(i);
                    dialog.dismiss();
                    break;
                case R.id.bt_update:
                    dialog.dismiss();
                default:
                    break;
            }
        }
        private void deleteItem(int postion) {

        }

    }

}

