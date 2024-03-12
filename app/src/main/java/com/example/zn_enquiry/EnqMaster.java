package com.example.zn_enquiry;

public class EnqMaster {
    private String name="",course="",mobile="",totper="",remark="";
    public void setName(String n){
        this.name=n;
    }
    public String getName(){
        return this.name;
    }

    public void setCourse(String n){
        this.course=n;
    }
    public String getCourse(){
        return this.course;
    }

    public void setMobile(String n){
        this.mobile=n;
    }
    public String getMobile(){
        return this.mobile;
    }

    public void setTotPer(String n){
        this.totper=n;
    }
    public String getTotper(){
        return this.totper;
    }

    public void setRemark(String n){
        this.remark=n;
    }
    public String getRemark(){
        return this.remark;
    }
}
