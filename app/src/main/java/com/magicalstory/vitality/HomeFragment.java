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
        for (int n = 0; n < 10; n++) {
            com.magicalstory.vitality.tasks tasks_single;
            tasks_single = new tasks();
            tasks_single.setName("任务" + n);
            tasks_single.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
            tasksList.add(tasks_single);
        }//添加假数据


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