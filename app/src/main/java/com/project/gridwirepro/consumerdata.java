package com.project.gridwirepro;

public class consumerdata {
    String phno,address,email,name,consumerid;
    float billamnt,meterreading;
 public consumerdata(){}
    public consumerdata(String phno,String address,String email,Float meterreading,String name,String consumerid,float billamnt) {
        this.phno = phno;
        this.address=address;
        this.email=email;
        this.meterreading=meterreading;
        this.name=name;
        this.consumerid=consumerid;
        this.billamnt=billamnt;
    }

    public float getBillamnt() {
        return billamnt;
    }

    public void setBillamnt(float billamnt) {
        this.billamnt = billamnt;
    }

    public String getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(String consumerid) {
        this.consumerid = consumerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMeterreading() {
        return meterreading;
    }

    public void setMeterreading(float meterreading) {
        this.meterreading = meterreading;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}
