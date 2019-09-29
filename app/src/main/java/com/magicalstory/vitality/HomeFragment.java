package com.magicalstory.vitality;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class HomeFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initTaskList();//初始化任务列表
        return view;
    }

    //初始化任务列表
    private void initTaskList() {
        ArrayList<tasks> tasksList = new ArrayList<>();

        com.magicalstory.vitality.tasks tasks01;
        com.magicalstory.vitality.tasks tasks02;
        com.magicalstory.vitality.tasks tasks03;

        //创建一个每天任务01
        tasks01 = new tasks();
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setName("早起挑战");
        tasks01.setType(type.taskDateAlways);
        tasks01.setVitality(5);
        tasks01.setDate(0);
        tasksList.add(tasks01);


        //创建一个每天任务02
        tasks01 = new tasks();
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setName("环校跑步");
        tasks01.setType(type.taskDateAlways);
        tasks01.setNum(3000);
        tasks01.setDanwei("米");
        tasks01.setVitality(2);
        tasks01.setDate(0);
        tasksList.add(tasks01);


        //创建一个时间段任务03
        tasks01 = new tasks();
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setName("读四大名著");
        tasks01.setType(type.taskDate);
        tasks01.setNum(3);
        tasks01.setDays(30);
        tasks01.setKeeyDays(12);
        tasks01.setDanwei("小时");
        tasks01.setVitality(2);
        tasks01.setDate(0);
        tasksList.add(tasks01);



        //创建一个时间段任务03
        tasks01 = new tasks();
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setName("深蹲");
        tasks01.setType(type.taskDate);
        tasks01.setNum(40);
        tasks01.setDays(100);
        tasks01.setKeeyDays(12);
        tasks01.setDanwei("个");
        tasks01.setVitality(2);
        tasks01.setDate(0);
        tasksList.add(tasks01);


        //创建一个每天任务04
        tasks01 = new tasks();
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setName("学习英语单词");
        tasks01.setType(type.taskDateAlways);
        tasks01.setNum(2);
        tasks01.setDanwei("小时");
        tasks01.setVitality(20);
        tasks01.setDate(0);
        tasksList.add(tasks01);

        RecyclerView recyclerLayoutTask;
        recyclerLayoutTask = (RecyclerView) view.findViewById(R.id.recyclerLayout_task);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerLayoutTask.setLayoutManager(linearLayoutManager);
        recyclerLayoutTask.setNestedScrollingEnabled(false);
        mainTaskListAdapter taskListAdapter = new mainTaskListAdapter(tasksList, getActivity());//创建适配器
        recyclerLayoutTask.setAdapter(taskListAdapter);//设置适配器

        //---------------------------设置列表显示模式------------------------------

    }
}