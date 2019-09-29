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

    //构造方法，接受参数
    public mainTaskListAdapter(ArrayList<tasks> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }


    //创建viewHolder完毕，返回实例
    @Override
    public mainTaskListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = View.inflate(context, R.layout.main_task_item_common, null);
        return new viewHolder(view);
    }

    //绑定组件的内容和事件
    @Override
    public void onBindViewHolder(@NonNull final mainTaskListAdapter.viewHolder holder, int position) {
        final com.magicalstory.vitality.tasks task;
        task = tasks.get(position);//获取任务实例对象
        //holder.textView_title.setText(task.getName());//获取任务名字

        holder.vitality.setText("+" + task.getVitality());//设置元气值

        //判断并设置任务值
        holder.title_num.setText(task.getNum() + "");
        if (task.getNum() == 0) {
            holder.title_num.setVisibility(View.INVISIBLE);
            holder.title_last.setVisibility(View.INVISIBLE);
        } else {
            holder.title_num.setVisibility(View.VISIBLE);
            holder.title_last.setVisibility(View.VISIBLE);
        }

        //设置任务创建时间
        holder.textView_date.setText((task.getDate() == 0) ? "刚刚" : task.getDate() + "");


        //设置任务单位
        holder.title_last.setText(task.getDanwei());

        //设置任务名字
        holder.textView_title.setText(task.getName());

        //设置任务剩余时间
        switch (task.getType()) {
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
        setStatusUI(holder, task.isStatus());


        //------------------设置小任务图标点击事件--------------------
        holder.imageView_status_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可直接实现点击事件，也可以回调到activity
                task.setStatus(!task.isStatus());//切换状态
                setStatusUI(holder, task.isStatus());//初始化任务状态按钮ui
            }
        });

        //------------------设置任务布局点击事件--------------------
        holder.status_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可直接实现点击事件，也可以回调到activity
                task.setStatus(!task.isStatus());//切换状态
                setStatusUI(holder, task.isStatus());//初始化任务状态按钮ui
            }
        });


    }


    //任务完成与否，切换UI
    public void setStatusUI(@NonNull final mainTaskListAdapter.viewHolder holder, boolean status) {
        holder.status_button.setSelected(status);
        if (status) {
            //已完成
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
            holder.time2.setTextColor(context.getResources().getColor(R.color.appThemeColor));
            holder.textView_title.setTextColor(context.getResources().getColor(R.color.black));
            holder.textView_title.setPaintFlags(holder.textView_title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.title_num.setTextColor(context.getResources().getColor(R.color.task_num_color));
            holder.title_last.setTextColor(context.getResources().getColor(R.color.black));
            holder.title_last.setPaintFlags(holder.textView_title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.title_num.setPaintFlags(holder.textView_title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.vitality.setTextColor(context.getResources().getColor(R.color.Gray));

        }
    }

    //返回列表项总长度
    @Override
    public int getItemCount() {
        return tasks.size();

    }

    interface onClickListener {

    }

    //viewHolder
    class viewHolder extends RecyclerView.ViewHolder {
        private TextView textView_title;//标题
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
            time3 = itemView.findViewById(R.id.textView_time3);

        }
    }
}
