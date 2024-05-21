package com.pluralsight.models;

import com.pluralsight.interfaces.PowerTool;

public class PushMower implements PowerTool {

    @Override
    public void repair() {
        System.out.println("Repairing push mower");
    }
}
