package com.pluralsight;

public class House {
    private String insideColor;
    private String outsideColor;

    public House(String insideColor, String outsideColor)
    {
        this.insideColor = insideColor;
        this.outsideColor = outsideColor;
    }

    public String getInsideColor(){
        return insideColor;
    }

    public String getOutsideColor(){
        return outsideColor;
    }

    public void paintOutside(String color){
        outsideColor = color;
    }
}
