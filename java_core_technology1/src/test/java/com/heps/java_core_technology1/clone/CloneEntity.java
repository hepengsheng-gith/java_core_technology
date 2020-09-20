package com.heps.java_core_technology1.clone;

public class CloneEntity implements Cloneable{

    private String name;
    private double height;
    private CloneOne cloneOne;



    public CloneEntity(String name,double height){
        this.name = name;
        this.height = height;
        cloneOne= new CloneOne();
    }


    /**
     * 浅拷贝
     * @return
     */
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    /**
     * 深拷贝
     * @return
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {

        CloneEntity cloned = (CloneEntity) super.clone();
        cloned.cloneOne=((CloneOne) cloneOne.clone());
        return cloned;
    }













    @Override
    public String toString() {
        return "CloneEntity{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", cloneOne=" + cloneOne +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public CloneOne getCloneOne() {
        return cloneOne;
    }

    public void setCloneOne(CloneOne cloneOne) {
        this.cloneOne = cloneOne;
    }
}
