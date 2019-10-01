package com.magicalstory.vitality;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class HomeFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (ViewHoder.homeView == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);
            initTaskList();//初始化任务列表
            initTaskInfo(view);//刷新任务列表头部信息
            initToDoList();//初始化todo列表
            bingListener();//绑定主页新建按钮特效
            ViewHoder.homeView = view;
        } else {
            view = ViewHoder.homeView;
        }

        return view;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void bingListener() {
        final TextView button_new_task = view.findViewById(R.id.button_new_task);
        final ConstraintLayout button_layout = view.findViewById(R.id.new_task_button);
        final ImageView icon = view.findViewById(R.id.imageView_icon_add);
        final ConstraintLayout todo_layout = view.findViewById(R.id.button_new_todo);
        final ImageView todo_icon = view.findViewById(R.id.icon_new_todo);
        final TextView todo_text = view.findViewById(R.id.new_todo);

        button_new_task.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_CANCEL:
                        icon.setImageResource(R.drawable.icon_new_task_common);
                        button_layout.setBackground(getContext().getDrawable(R.drawable.button_new_task_common));
                        button_new_task.setTextColor(getContext().getResources().getColor(R.color.black));
                        break;
                    case MotionEvent.ACTION_UP:
                        icon.setImageResource(R.drawable.icon_new_task_common);
                        button_layout.setBackground(getContext().getDrawable(R.drawable.button_new_task_common));
                        button_new_task.setTextColor(getContext().getResources().getColor(R.color.black));
                        break;
                    case MotionEvent.ACTION_DOWN:
                        icon.setImageResource(R.drawable.icon_new_task_pressed);
                        button_layout.setBackground(getContext().getDrawable(R.drawable.button_new_task_pressed));
                        button_new_task.setTextColor(getContext().getResources().getColor(R.color.new_task_pressed));
                        break;
                }

                return false;
            }
        });


        button_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_CANCEL:
                        icon.setImageResource(R.drawable.icon_new_task_common);
                        button_layout.setBackground(getContext().getDrawable(R.drawable.button_new_task_common));
                        button_new_task.setTextColor(getContext().getResources().getColor(R.color.black));
                        break;
                    case MotionEvent.ACTION_UP:
                        icon.setImageResource(R.drawable.icon_new_task_common);
                        button_layout.setBackground(getContext().getDrawable(R.drawable.button_new_task_common));
                        button_new_task.setTextColor(getContext().getResources().getColor(R.color.black));
                        break;
                    case MotionEvent.ACTION_DOWN:
                        icon.setImageResource(R.drawable.icon_new_task_pressed);
                        button_layout.setBackground(getContext().getDrawable(R.drawable.button_new_task_pressed));
                        button_new_task.setTextColor(getContext().getResources().getColor(R.color.new_task_pressed));
                        break;
                }

                return false;
            }
        });


        icon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_CANCEL:
                        icon.setImageResource(R.drawable.icon_new_task_common);
                        button_layout.setBackground(getContext().getDrawable(R.drawable.button_new_task_common));
                        button_new_task.setTextColor(getContext().getResources().getColor(R.color.black));
                        break;
                    case MotionEvent.ACTION_UP:
                        icon.setImageResource(R.drawable.icon_new_task_common);
                        button_layout.setBackground(getContext().getDrawable(R.drawable.button_new_task_common));
                        button_new_task.setTextColor(getContext().getResources().getColor(R.color.black));
                        break;
                    case MotionEvent.ACTION_DOWN:
                        icon.setImageResource(R.drawable.icon_new_task_pressed);
                        button_layout.setBackground(getContext().getDrawable(R.drawable.button_new_task_pressed));
                        button_new_task.setTextColor(getContext().getResources().getColor(R.color.new_task_pressed));
                        break;
                }

                return false;
            }
        });


        todo_text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_CANCEL:
                        todo_icon.setImageResource(R.drawable.icon_new_todo_common);
                        todo_layout.setBackground(getContext().getDrawable(R.drawable.button_new_todo_common));
                        todo_text.setTextColor(getContext().getResources().getColor(R.color.White));
                        break;
                    case MotionEvent.ACTION_UP:
                        todo_icon.setImageResource(R.drawable.icon_new_todo_common);
                        todo_layout.setBackground(getContext().getDrawable(R.drawable.button_new_todo_common));
                        todo_text.setTextColor(getContext().getResources().getColor(R.color.White));
                        break;
                    case MotionEvent.ACTION_DOWN:
                        todo_icon.setImageResource(R.drawable.icon_new_todo_pressed);
                        todo_layout.setBackground(getContext().getDrawable(R.drawable.button_new_todo_pressed));
                        todo_text.setTextColor(getContext().getResources().getColor(R.color.new_todo_pressed));
                        break;
                }

                return false;
            }
        });


        todo_icon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_CANCEL:
                        todo_icon.setImageResource(R.drawable.icon_new_todo_common);
                        todo_layout.setBackground(getContext().getDrawable(R.drawable.button_new_todo_common));
                        todo_text.setTextColor(getContext().getResources().getColor(R.color.White));
                        break;
                    case MotionEvent.ACTION_UP:
                        todo_icon.setImageResource(R.drawable.icon_new_todo_common);
                        todo_layout.setBackground(getContext().getDrawable(R.drawable.button_new_todo_common));
                        todo_text.setTextColor(getContext().getResources().getColor(R.color.White));
                        break;
                    case MotionEvent.ACTION_DOWN:
                        todo_icon.setImageResource(R.drawable.icon_new_todo_pressed);
                        todo_layout.setBackground(getContext().getDrawable(R.drawable.button_new_todo_pressed));
                        todo_text.setTextColor(getContext().getResources().getColor(R.color.new_todo_pressed));
                        break;
                }

                return false;
            }
        });

        todo_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_CANCEL:
                        todo_icon.setImageResource(R.drawable.icon_new_todo_common);
                        todo_layout.setBackground(getContext().getDrawable(R.drawable.button_new_todo_common));
                        todo_text.setTextColor(getContext().getResources().getColor(R.color.White));
                        break;
                    case MotionEvent.ACTION_UP:
                        todo_icon.setImageResource(R.drawable.icon_new_todo_common);
                        todo_layout.setBackground(getContext().getDrawable(R.drawable.button_new_todo_common));
                        todo_text.setTextColor(getContext().getResources().getColor(R.color.White));
                        break;
                    case MotionEvent.ACTION_DOWN:
                        todo_icon.setImageResource(R.drawable.icon_new_todo_pressed);
                        todo_layout.setBackground(getContext().getDrawable(R.drawable.button_new_todo_pressed));
                        todo_text.setTextColor(getContext().getResources().getColor(R.color.new_todo_pressed));
                        break;
                }

                return false;
            }
        });
    }

    static void initTaskInfo(View view) {
        //*初始化列表头部任务信息
        TextView allTaskNum;//全部任务TextView
        TextView completedTaskNum;//完成任务TextView
        TextView uncpmletedTaskNum;//没完成TextView
        TextView vitalityToday;//今日元气值TextView
        allTaskNum = view.findViewById(R.id.allTaskNum);
        completedTaskNum = view.findViewById(R.id.completedTaskNum);
        uncpmletedTaskNum = view.findViewById(R.id.uncompletedTaskNum);
        vitalityToday = view.findViewById(R.id.vitality_today);
        //获取组件完毕

        allTaskNum.setText(String.valueOf(tasks.getAllTaskNum()));
        completedTaskNum.setText(String.valueOf(tasks.getCompletedTaskNum()));
        uncpmletedTaskNum.setText(String.valueOf(tasks.getAllTaskNum() - tasks.getCompletedTaskNum()));
        vitalityToday.setText(String.valueOf(tasks.getVitalityToday()));
    }

    //*初始化任务列表
    private void initTaskList() {
        com.magicalstory.vitality.tasks tasks01;
        //创建一个每天任务01
        tasks01 = new tasks("早起挑战", 5, type.taskDateAlways, type.Task, "健康");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setVitality(5);
        tasks01.setDate(0);
        tasks.getTaskList().add(tasks01);
        //创建一个每天任务02
        tasks01 = new tasks("环校跑步", 2, type.taskDateAlways, type.Task, "健康");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setValue(3000);
        tasks01.setDanwei("米");
        tasks01.setDate(0);
        tasks.getTaskList().add(tasks01);
        //创建一个时间段任务03
        tasks01 = new tasks("读四大名著", 2, type.taskDate, type.Task, "学习");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setValue(3);
        tasks01.setDays(30);
        tasks01.setKeeyDays(12);
        tasks01.setDanwei("小时");
        tasks01.setVitality(2);
        tasks01.setDate(0);
        tasks.getTaskList().add(tasks01);

        //创建一个时间段任务03
        tasks01 = new tasks("深蹲", 3, type.taskDate, type.Task, "健身");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setValue(40);
        tasks01.setDays(100);
        tasks01.setKeeyDays(12);
        tasks01.setDanwei("个");
        tasks01.setDate(0);
        tasks.getTaskList().add(tasks01);


        //创建一个每天任务04
        tasks01 = new tasks("学习英语单词", 20, type.taskDateAlways, type.Task, "健康");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setValue(2);
        tasks01.setDanwei("小时");
        tasks01.setDate(0);
        tasks.getTaskList().add(tasks01);

//创建一个每天任务04
        tasks01 = new tasks("看佛学", 20, type.taskDateAlways, type.Task, "修身");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks01.setValue(3);
        tasks01.setDanwei("小时");
        tasks01.setDate(0);
        tasks.getTaskList().add(tasks01);
        RecyclerView recyclerLayoutTask;
        recyclerLayoutTask = (RecyclerView) view.findViewById(R.id.list_task);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerLayoutTask.setLayoutManager(linearLayoutManager);
        recyclerLayoutTask.setNestedScrollingEnabled(false);
        mainTaskListAdapter taskListAdapter = new mainTaskListAdapter(tasks.getTaskList(), getActivity(), view);//创建适配器
        recyclerLayoutTask.setAdapter(taskListAdapter);//设置适配器
        tasks.initAllCompletedTasks();//刷新tasks完成任务总数
        //---------------------------设置列表显示模式------------------------------

    }


    //*初始化todo列表
    private void initToDoList() {
        com.magicalstory.vitality.tasks tasks01;
        //创建一个ToDo01
        tasks01 = new tasks("帮陈志坤寄东西", 5, type.taskDateAlways, type.ToDo, "待做");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks.getTodoList().add(tasks01);
        //创建一个每天ToDo02
        tasks01 = new tasks("买个厕所清洁剂", 2, type.taskDateAlways, type.ToDo, "待做");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks.getTodoList().add(tasks01);
        //创建一个时间段ToDo03
        tasks01 = new tasks("下午去剪个帅气的发型", 2, type.taskDate, type.ToDo, "待做");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks.getTodoList().add(tasks01);

        //创建一个时间段ToDo03
        tasks01 = new tasks("帮同学做PPT", 3, type.taskDate, type.ToDo, "待做");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks.getTodoList().add(tasks01);


        //创建一个每天ToDo04
        tasks01 = new tasks("收顺丰快递-小狗狗", 20, type.taskDateAlways, type.ToDo, "待做");
        tasks01.setStatus(new Random().nextBoolean());//随机设置一个任务完成状态
        tasks.getTodoList().add(tasks01);


        RecyclerView ToDoList;
        ToDoList = (RecyclerView) view.findViewById(R.id.list_todo);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ToDoList.setLayoutManager(linearLayoutManager);
        ToDoList.setNestedScrollingEnabled(false);
        mainTaskListAdapter taskListAdapter = new mainTaskListAdapter(tasks.getTodoList(), getActivity(), view);//创建适配器
        ToDoList.setAdapter(taskListAdapter);//设置适配器
        tasks.initAllCompletedTasks();//刷新tasks完成任务总数
        //---------------------------设置列表显示模式------------------------------

    }


    @Override
    public void onPause() {
        super.onPause();
        ViewHoder.homeView = view;
    }
}











