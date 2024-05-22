package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class FixedList <T>{
    List<T> items = new ArrayList<>();
    int maxSize;

    public FixedList(int maxSize)
    {
        this.maxSize = maxSize;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T item)
    {
        int listSize = getItems().size();
        if(listSize < getMaxSize())
        {
            items.add(item);
        }
    }

    public List<T> getItems()
    {
        return items;
    }
}
