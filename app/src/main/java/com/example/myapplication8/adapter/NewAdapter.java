package com.example.myapplication8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication8.JavaBean.Person;
import com.example.myapplication8.R;

import java.util.List;
import java.util.Map;

public class NewAdapter extends ArrayAdapter<Person> {
    private int resourceId;
    private Context context;
    private List<Map<String,Object>>data;
    public NewAdapter(Context context, int resource,  List<Person> objects) {
        super(context,resource,objects);
        resourceId=resource;

    }


    @Override
    public int getCount() {
        return data.size();
    }
/*
    @Override
    public Person getItem(int i) {
        return (Person) data.get(i);
    }

 */



    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Person person = (Person) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView  n_name= view.findViewById(R.id.name);
        TextView n_compy = view.findViewById(R.id.compy);
        TextView n_number = view.findViewById(R.id.number);
        n_name.setText(person.getName());
        n_compy.setText(person.getCompany());
        n_number.setText(person.getPhonenumber());
        return view;
        /*
         public class ViewHolder{
        private ImageView n_background;
        private ImageView n_card;
        private ImageView n_call;
        private ImageView n_share;
        private TextView n_name;
        private TextView n_compy;
        private TextView n_number;
    }
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.new_item,null);
            viewHolder.n_background=convertView.findViewById(R.id.background);
            viewHolder.n_card=convertView.findViewById(R.id.card);
            viewHolder.n_call=convertView.findViewById(R.id.call);
            viewHolder.n_share=convertView.findViewById(R.id.share);
            viewHolder.n_name=convertView.findViewById(R.id.name);
            viewHolder.n_compy=convertView.findViewById(R.id.compy);
            viewHolder.n_number=convertView.findViewById(R.id.number);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        //viewHolder.n_background.setImageResource((Integer) data.get(i).get(""));
        viewHolder.n_name.setText((String)data.get(i).get("name"));
        viewHolder.n_compy.setText((String)data.get(i).get("compay"));
        viewHolder.n_number.setText((String)data.get(i).get("phonenumber"));

         */

    }

}
