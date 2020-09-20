package com.heps.java_core_technology1.interface_test.compare;

public class Animal implements Comparable{
    double height;

    public Animal(double height){
        this.height = height;
    }
    @Override
    public int compareTo(Object o) {
        if (o instanceof Animal ) {
            Animal animal = (Animal) o;
            return Double.compare(animal.height,this.height);
        }

        if (o instanceof Persion){
            Persion persion = (Persion) o;
            return Double.compare(persion.height,this.height);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "height=" + height +
                '}';
    }
}
