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
        holder.textView_title.setText(task.getName());//获取任务名字

        setStatusUI(holder, task.isStatus());//初始化任务状态按钮ui


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


    public void setStatusUI(@NonNull final mainTaskListAdapter.viewHolder holder, boolean status) {
        holder.status_button.setSelected(status);
        if (status) {
            holder.textView_title.setTextColor(context.getResources().getColor(R.color.deleted));
            holder.textView_title.setPaintFlags(holder.textView_title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        } else {
            holder.textView_title.setTextColor(context.getResources().getColor(R.color.black));
            holder.textView_title.setPaintFlags(holder.textView_title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
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
        private TextView textView_title;
        private TextView textView_status;
        private ConstraintLayout status_button;
        private ImageView imageView_status_right;

        public viewHolder(View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.textView_task_list_title);
            textView_status = itemView.findViewById(R.id.textView_status);
            imageView_status_right = itemView.findViewById(R.id.img_status_icon);
            status_button = itemView.findViewById(R.id.button_status);
        }
    }
}
