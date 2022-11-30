package oop.inheritance;

public class UIControl {
    private boolean isEnabled;


    public UIControl(boolean isEnabled) {
        System.out.println("UIControl");
        this.isEnabled = isEnabled;
    }

    public void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
