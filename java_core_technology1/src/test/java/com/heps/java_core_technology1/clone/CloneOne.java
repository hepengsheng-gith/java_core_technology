package com.heps.java_core_technology1.clone;

public class CloneOne implements Cloneable{

    private String cloneName ="克隆一号";


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    @Override
    public String toString() {
        return "CloneOne{" +
                "cloneName='" + cloneName + '\'' +
                '}';
    }
}
