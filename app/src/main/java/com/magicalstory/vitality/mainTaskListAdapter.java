package com.magicalstory.vitality;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
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
        Log.d("测试", view.toString());
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mainTaskListAdapter.viewHolder holder, int position) {
        com.magicalstory.vitality.tasks task;
        task = tasks.get(position);//获取任务实例对象
        holder.textView_title.setText(task.getName());//获取任务名字
    }

    //返回列表项总长度
    @Override
    public int getItemCount() {
        return tasks.size();

    }

    //viewHolder
    class viewHolder extends RecyclerView.ViewHolder {
        private TextView textView_title;
        private ImageView imageView_icon;
        private ConstraintLayout imageView_icon_background;
        private TextView textView_status;

        public viewHolder(View itemView) {
            super(itemView);
            //itemView来源:  view = View.inflate(context, R.layout.main_task_item_common, null);
            imageView_icon = itemView.findViewById(R.id.imageView_task_icon);
            imageView_icon_background = itemView.findViewById(R.id.task_list_icon_background);
            textView_title = itemView.findViewById(R.id.textView_title);
            textView_status = itemView.findViewById(R.id.textView_status);

            if (textView_title == null) {
                Log.d("viewHolder", "对象为空");
            } else {
                Log.d("viewHolder", "对象不为空");
            }
        }
    }
}
