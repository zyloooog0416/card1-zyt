package com.example.myapplication8.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication8.JavaBean.Person;
import com.example.myapplication8.R;
import com.example.myapplication8.adapter.NewAdapter;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    private View view;
    private SearchView search;
    private ListView lv_search;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_search, container, false);
        Bmob.initialize(getContext(), "0e4efeb8f4a816a01f116edc48fbfd2d");
        search=view.findViewById(R.id.search);
        lv_search=view.findViewById(R.id.lv_search);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (!TextUtils.isEmpty(s)){
                    BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
                    bmobQuery.addWhereEqualTo("phonenumber",s);
                    bmobQuery.findObjects(new FindListener<Person>() {
                        @Override
                        public void done(List<Person> list, BmobException e) {
                            if (e == null) {
                                NewAdapter newAdapte = new NewAdapter(getContext(), R.layout.new_item, list);
                                lv_search.setAdapter(newAdapte);
                            } else {
                                Toast.makeText(getContext(),"没有该名片 "+ e.getMessage(),Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }else {
                    lv_search.clearTextFilter();
                }
                return false;
            }
        });


        return view;


    }

}
