package com.ps.listselectmaster.bean;

/**
 * Created : 2018/5/5 14:15
 * Description :
 * Author : gengbaolong
 */

public class UserInfo {

    private String name;
    private String number;

    private boolean isSelectFlag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isSelectFlag() {
        return isSelectFlag;
    }

    public void setSelectFlag(boolean selectFlag) {
        isSelectFlag = selectFlag;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", isSelectFlag=" + isSelectFlag +
                '}';
    }
}
