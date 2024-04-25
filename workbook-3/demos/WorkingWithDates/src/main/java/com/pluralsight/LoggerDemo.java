package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class LoggerDemo {
    public void logMessage(String messages)
    {
        File file = new File("logs/application.log");
        try(
                FileWriter fileWriter = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fileWriter);
        )
        {
        }
        catch(Exception e)
        {

        }
    }
}
