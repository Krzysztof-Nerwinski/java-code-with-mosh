package oop;

import oop.inheritance.UIControl;

public class TextBox extends UIControl {
    public String text = "";

    public TextBox() {
        super(true);
        System.out.println("TextBox");
    }

    @Override
    public String toString() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        text = "";
    }
}
