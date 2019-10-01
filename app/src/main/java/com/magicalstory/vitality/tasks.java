package com.magicalstory.vitality;

import java.util.ArrayList;

public class tasks {
    /*
     *该类为任务类
     *
     * */
    static String TAG = "任务类";
    static String id;//任务标识ID
    private static int allTaskNum;//任务总数
    private static int completedTaskNum;//已完成任务
    private static int vitalityToday;//今天元气值
    private String name;//任务名字
    private String targetType;//定义任务的类型:如健康，学习，健身...
    private boolean status;//任务状态
    private String danwei;//定义单位
    private int taskType;//任务类型:如时间段任务，每天任务...
    private int vitality;//任务的元气值
    private int date;//任务的创建日期
    private int type;//类型，分为任务和todo
    private int days;//总天数
    private int keeyDays;//坚持的天数
    private int daysRest;//剩余天数
    private int allToDoNum;//todo总数
    private int value;//任务的值
    private static ArrayList<tasks> taskList=new ArrayList<>();//任务数组
    private static ArrayList<tasks> todoList=new ArrayList<>();//todo数组
//构造函数
    tasks(String name, int vitality, int taskType, int type,String targetType) {
        this.type = type;//类型:todo或者任务
        this.targetType = targetType;//目标类型
        this.taskType = taskType;//任务类型
        this.vitality = vitality;//该任务的元气值
        this.name = name;//任务名字
        id = name + "@type=" + type + "@vitality=" + vitality;//初始化id

        if (type == com.magicalstory.vitality.type.Task) {
            allTaskNum += 1;
        }else {
            allToDoNum += 1;
        }
    }


    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public static ArrayList<tasks> getTodoList() {
        return todoList;
    }

    public int getAllToDoNum() {
        return allToDoNum;
    }

    public void setAllToDoNum(int allToDoNum) {
        this.allToDoNum = allToDoNum;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        tasks.id = id;
    }

    public static ArrayList<tasks> getTaskList() {
        return taskList;
    }

    public static void setTaskList(ArrayList<tasks> taskList) {
        tasks.taskList = taskList;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    static int getAllTaskNum() {
        return allTaskNum;
    }

    public static void setAllTaskNum(int allTaskNum) {
        tasks.allTaskNum = allTaskNum;
    }

    static int getCompletedTaskNum() {
        return completedTaskNum;
    }

    public static void setCompletedTaskNum(int completedTaskNum) {
        tasks.completedTaskNum = completedTaskNum;
    }

    static int getVitalityToday() {
        return vitalityToday;
    }

    public static void setVitalityToday(int vitalityToday) {
        tasks.vitalityToday = vitalityToday;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }


    String getDanwei() {
        return danwei;
    }

    void setDanwei(String danwei) {
        this.danwei = danwei;
    }


    int getDaysRest() {
        return daysRest;
    }

    public void setDaysRest(int daysRest) {
        this.daysRest = daysRest;
    }

    public int getDays() {
        return days;
    }

    void setDays(int days) {
        this.days = days;
        daysRest = this.days - keeyDays;
    }

    public int getKeeyDays() {
        return keeyDays;
    }

    void setKeeyDays(int keeyDays) {
        this.keeyDays = keeyDays;
        daysRest = days - this.keeyDays;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    int getDate() {
        return date;
    }

    void setDate(int date) {
        this.date = date;
    }

    int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    boolean isStatus() {
        return status;
    }

    void setStatus(boolean status) {

        this.status = status;
        if (status) {
            vitalityToday += this.getVitality();
        } else {
            vitalityToday -= this.getVitality();
        }


    }

    static void initAllCompletedTasks() {
        //判断状态，循环任务列表找出已经完成的任务总数
        int num=0;
        vitalityToday = 0;
        for (int n = 0; n<taskList.size();n++) {
            tasks task=taskList.get(n);
            if (task.isStatus() == true) {
                vitalityToday += task.getVitality();
                num++;
            }
        }
        completedTaskNum = num;
    }


}
