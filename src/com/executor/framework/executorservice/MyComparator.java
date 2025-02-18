package com.executor.framework.executorservice;

import java.util.Comparator;

public class MyComparator implements Comparator<Voter>
{
    @Override
    public int compare(Voter o1, Voter o2) {
        Integer i1=o1.getVoterId();
        Integer i2=o2.getVoterId();
        return i1.compareTo(i2);
    }
}
