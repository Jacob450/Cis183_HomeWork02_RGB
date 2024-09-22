package com.example.cis183_homework02_rgb;

public class MyColor {
    int red;
    int green;
    int blue;

    public String getHex(){
        return String.format("#%02X%02X%02X", red, green, blue);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
