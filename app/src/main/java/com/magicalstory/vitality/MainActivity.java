package com.magicalstory.vitality;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.magicalstory.vitality.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class MainActivity  extends AppCompatActivity  {
    ViewModel viewModel;
  FragmentHomeBinding dataBinding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding=DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(MainActivity.this).get(MainActivityViewModel.class);
        setStateBar();//设置状态栏

    }




    private void setStateBar() {
       appUtil.setStateBar(MainActivity.this);
    }





}
