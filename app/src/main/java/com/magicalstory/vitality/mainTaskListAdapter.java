package com.magicalstory.vitality;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//传入泛值
public class mainTaskListAdapter extends RecyclerView.Adapter<mainTaskListAdapter.viewHolder> {
    ArrayList<tasks> tasks;//定义任务列表
    Context context;
    View view;//列表项view
    //构造方法，接受参数
    public mainTaskListAdapter(ArrayList<tasks> tasks, Context context,View view) {
        this.tasks = tasks;
        this.view = view;
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        return tasks.get(position).getType();
    }

    //创建viewHolder完毕，返回实例
    @Override
    public mainTaskListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = View.inflate(context, (viewType==type.Task)? R.layout.main_task_item_common:R.layout.main_todo_item_common, null);
        return new viewHolder(view);
    }

    //绑定组件的内容和事件
    @Override
    public void onBindViewHolder(@NonNull final mainTaskListAdapter.viewHolder holder, int position) {

        final com.magicalstory.vitality.tasks task;
        task = tasks.get(position);//获取任务实例对象
        if (task.getType() == type.Task) {
            //任务
            initTaskView(holder, task);//绑定任务itemView
        } else {
            initToDoView(holder,task);//绑定ToDo的itemView
        }



    }

    private void initTaskView(@NonNull final mainTaskListAdapter.viewHolder holder, final tasks task) {
        holder.vitality.setText("+"+task.getVitality());//设置元气值

        //判断并设置任务值
        holder.title_num.setText(String.valueOf(task.getValue()));
        if (task.getValue() == 0) {
            holder.title_num.setVisibility(View.INVISIBLE);
            holder.title_last.setVisibility(View.INVISIBLE);
        } else {
            holder.title_num.setVisibility(View.VISIBLE);
            holder.title_last.setVisibility(View.VISIBLE);
        }

        //设置任务创建时间
        holder.textView_date.setText((task.getTargetType().equals("")) ? "默认" : task.getTargetType());


        //设置任务单位
        holder.title_last.setText(task.getDanwei());

        //设置任务名字
        holder.textView_title.setText(task.getName());

        //设置任务剩余时间
        switch (task.getTaskType()) {
            case type.taskDate://时间段任务
                holder.time2.setText(task.getDaysRest() + "");
                break;
            case type.taskDateAlways://每天循环任务
                holder.time3.setVisibility(View.INVISIBLE);
                holder.time2.setVisibility(View.INVISIBLE);
                holder.time1.setText("每天");
                break;
            default:
                holder.time3.setVisibility(View.INVISIBLE);
                holder.time2.setVisibility(View.INVISIBLE);
                holder.time1.setText("每天");
                break;
        }


        //初始化任务状态按钮ui
        changeTaskButtonUI(holder, task.isStatus());

        //设置item被单击切换item状态
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setStatus(!task.isStatus());//切换状态
                changeTaskButtonUI(holder, task.isStatus());//初始化任务状态按钮ui
            }
        });


        //------------------设置小任务图标点击事件--------------------
        holder.imageView_status_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可直接实现点击事件，也可以回调到activity
                task.setStatus(!task.isStatus());//切换状态
                changeTaskButtonUI(holder, task.isStatus());//初始化任务状态按钮ui
            }
        });

        //------------------设置任务布局点击事件--------------------
        holder.status_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可直接实现点击事件，也可以回调到activity
                task.setStatus(!task.isStatus());//切换状态
                changeTaskButtonUI(holder, task.isStatus());//初始化任务状态按钮ui
            }
        });


    }

    private void initToDoView(@NonNull final mainTaskListAdapter.viewHolder holder, final tasks task) {
        //初始化todo状态按钮ui
        changeToDoButtonUI(holder, task.isStatus());

        //设置todo标题
        holder.textView_title.setText(task.getName());


        //设置item被单击切换item状态
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setStatus(!task.isStatus());//切换状态
                changeToDoButtonUI(holder, task.isStatus());//初始化任务状态按钮ui
            }
        });

        //------------------设置todo图标点击事件--------------------
        holder.imageView_status_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可直接实现点击事件，也可以回调到activity
                task.setStatus(!task.isStatus());//切换状态
                changeToDoButtonUI(holder, task.isStatus());//初始化任务状态按钮ui
            }
        });

        //------------------设置todoa按钮布局点击事件--------------------
        holder.status_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可直接实现点击事件，也可以回调到activity
                task.setStatus(!task.isStatus());//切换状态
                changeToDoButtonUI(holder, task.isStatus());//初始化todo状态按钮ui

            }
        });


    }

    //任务完成与否，切换UI
    public void changeTaskButtonUI(@NonNull final mainTaskListAdapter.viewHolder holder, boolean status) {
        holder.status_button.setSelected(status);
        HomeFragment.initTaskInfo(view);
        if (status) {
            //已完成
            holder.imageView_status_right.setVisibility(View.VISIBLE);
            holder.time2.setTextColor(context.getResources().getColor(R.color.deleted));
            holder.textView_title.setTextColor(context.getResources().getColor(R.color.deleted));
            holder.textView_title.setPaintFlags(holder.textView_title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.title_last.setTextColor(context.getResources().getColor(R.color.deleted));
            holder.title_last.setPaintFlags(holder.textView_title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.title_num.setPaintFlags(holder.textView_title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.title_num.setTextColor(context.getResources().getColor(R.color.deleted));
            holder.vitality.setTextColor(context.getResources().getColor(R.color.appThemeColor));

        } else {
            //未完成
            holder.imageView_status_right.setVisibility(View.INVISIBLE);
            holder.time2.setTextColor(context.getResources().getColor(R.color.appThemeColor));
            holder.textView_title.setTextColor(context.getResources().getColor(R.color.black));
            holder.textView_title.setPaintFlags(holder.textView_title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.title_num.setTextColor(context.getResources().getColor(R.color.task_num_color));
            holder.title_last.setTextColor(context.getResources().getColor(R.color.black));
            holder.title_last.setPaintFlags(holder.textView_title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.title_num.setPaintFlags(holder.textView_title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.vitality.setTextColor(context.getResources().getColor(R.color.Gray));

        }
        com.magicalstory.vitality.tasks.initAllCompletedTasks();

    }

    //ToDo完成与否，切换UI
    public void changeToDoButtonUI(@NonNull final mainTaskListAdapter.viewHolder holder, boolean status) {
        holder.status_button.setSelected(status);
        HomeFragment.initTaskInfo(view);
        if (status) {
            //已完成
            holder.imageView_status_right.setVisibility(View.VISIBLE);
            holder.textView_title.setTextColor(context.getResources().getColor(R.color.deleted));
            holder.textView_title.setPaintFlags(holder.textView_title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        } else {
            //未完成
            holder.imageView_status_right.setVisibility(View.INVISIBLE);
            holder.textView_title.setTextColor(context.getResources().getColor(R.color.black));
            holder.textView_title.setPaintFlags(holder.textView_title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));


        }

    }
    //返回列表项总长  @Override
    public int getItemCount() {
        return tasks.size();

    }


    //viewHolder
    class viewHolder extends RecyclerView.ViewHolder {
        private TextView textView_title;//标题
        private ConstraintLayout layout;//layout
        private TextView textView_date;//创建时间文本
        private ConstraintLayout status_button;//完成任务按钮布局
        private ImageView imageView_status_right;//完成任务中间的小图标
        private TextView title_num;//标题中的数值
        private TextView title_last;//标题后的单位文本
        private TextView vitality;//元气值文本
        private TextView time1;//倒计时1
        private TextView time2;//倒计时数值
        private TextView time3;//倒计时单位:天

        public viewHolder(View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.textView_task_list_title);
            textView_date = itemView.findViewById(R.id.textView_date);
            imageView_status_right = itemView.findViewById(R.id.img_status_icon);
            status_button = itemView.findViewById(R.id.button_status);
            title_num = itemView.findViewById(R.id.title_num);
            title_last = itemView.findViewById(R.id.title_last);
            vitality = itemView.findViewById(R.id.vitality);
            time1 = itemView.findViewById(R.id.textView_time1);
            time2 = itemView.findViewById(R.id.textView_time2);
            layout = itemView.findViewById(R.id.layout);
            time3 = itemView.findViewById(R.id.textView_time3);

        }
    }
}
