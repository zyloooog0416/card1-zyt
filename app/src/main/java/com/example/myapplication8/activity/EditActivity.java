package com.example.myapplication8.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication8.JavaBean.Person;
import com.example.myapplication8.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class EditActivity extends AppCompatActivity {
    private EditText edit_name,edit_company,edit_department,edit_position,
            edit_mail,edit_phonenumber,edit_fax,edit_website,edit_address;
    private TextView keep;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Bmob.initialize(this, "0e4efeb8f4a816a01f116edc48fbfd2d");
        keep=findViewById(R.id.textView5);
        back=findViewById(R.id.imageView2);
        initView();
        keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCard();

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setClass(EditActivity.this, MainActivity.class);
                startActivity(i);

            }
        });


    }

    private void initView() {
        edit_name=findViewById(R.id.edit_name);
        edit_company=findViewById(R.id.edit_company);
        edit_department=findViewById(R.id.edit_department);
        edit_position=findViewById(R.id.edit_position);
        edit_phonenumber=findViewById(R.id.edit_phonenumber);
        edit_mail=findViewById(R.id.edit_mail);
        edit_fax=findViewById(R.id.edit_fax);
        edit_website=findViewById(R.id.edit_website);
        edit_address=findViewById(R.id.edit_address);

    }
    private void addCard(){
        String edit_name1 = edit_name.getText().toString();
        String edit_company1 = edit_company.getText().toString();
        String edit_department1 = edit_department.getText().toString();
        String edit_position1 = edit_position.getText().toString();
        String edit_phonenumber1 = edit_phonenumber.getText().toString();
        String edit_mail1 = edit_mail.getText().toString();
        String edit_fax1 = edit_fax.getText().toString();
        String edit_website1 = edit_website.getText().toString();
        String edit_address1= edit_address.getText().toString();
        Person p2 = new Person();
        p2.setName(edit_name1);
        p2.setCompany(edit_company1);
        p2.setDepartment(edit_department1);
        p2.setPosition(edit_position1);
        p2.setPhonenumber(edit_phonenumber1);
        p2.setMail(edit_mail1);
        p2.setFax(edit_fax1);
        p2.setWebsite(edit_website1);
        p2.setAddress(edit_address1);
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if(e==null){
                    Toast.makeText(getApplicationContext(),"保存成功"+objectId,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"保存失败"+ e.getMessage(),Toast.LENGTH_LONG).show();
                    //toast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }
}
