package com.magicalstory.vitality;

public class tasks {
    private String name;//任务名字
    private boolean status;//任务状态
    private String danwei;//定义单位

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    private int all;//全部任务数
    private int vitality;//任务的元气值
    private int num;//任务的数值
    private int date;//任务的创建日期
    private int type;//任务的类型
    private int days;//总天数
    private int keeyDays;//坚持的天数

    public int getDaysRest() {
        return daysRest;
    }

    public void setDaysRest(int daysRest) {
        this.daysRest = daysRest;
    }

    private int daysRest;//剩余天数





    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
        daysRest = this.days - keeyDays;
    }

    public int getKeeyDays() {
        return keeyDays;
    }

    public void setKeeyDays(int keeyDays) {
        this.keeyDays = keeyDays;
        daysRest = days - this.keeyDays;
    }



    public int getAll() {
        return all;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public void add() {
        all += 1;
    }

    public void sub() {
        all -= 1;
    }

    public void setAll(int num) {
        all = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
