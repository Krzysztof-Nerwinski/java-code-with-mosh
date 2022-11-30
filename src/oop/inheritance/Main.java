package oop.inheritance;

import oop.TextBox;

public class Main {
    public static void main(String[] args) {
        var control = new UIControl(true);
        control.disable();
        System.out.println(control.isEnabled());

        var box1 = new TextBox();
        var box2 = box1;

        System.out.println(box1.hashCode() == box2.hashCode());
        System.out.println(box1.equals(box2));
        System.out.println(box1.toString());


    }


}
