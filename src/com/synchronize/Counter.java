package com.synchronize;

public class Counter
{
    private int count;
    public void increment()
    {
        //When we declare method as synchronized or we use synchronized block then at a time only
        //One Thread is allowed to increase count variable value therefore there will not be any
        //Data inconsistency problem

        //If we are not using synchronized method or block then we will not get correct output
        synchronized(this)
        {
            count++;
        }
//        ++count;
    }
    public  int getCount()
    {
        return count;
    }
}
