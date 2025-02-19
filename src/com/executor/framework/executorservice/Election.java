package com.executor.framework.executorservice;

import java.util.*;

public class Election
{
    public static void main(String[] args) {
        Voter v1=new Voter("Shrikant",362,22);
        Voter v2=new Voter("Shrikant",362,22);
        Voter v3=new Voter("Shubham Puri",252,26);
        Voter v4=new Voter("Shubham Puri",252,26);
        Voter v5=new Voter("Shrikant",162,22);
        Voter v6=new Voter("Shrikant",162,22);
        Voter v7=new Voter("Shubham Puri",162,26);
        Voter v8=new Voter("Shubham Puri",1,26);
        List<Voter> votersArray= Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8);
        HashSet<Voter> voters=new HashSet<Voter>(votersArray);
        List<Voter> voterList=new ArrayList<Voter>(voters);
        voterList.sort((o1, o2) -> {
            Integer i1=o1.getVoterId();
            Integer i2=o2.getVoterId();
            return i1.compareTo(i2);
        });
        for(Voter voter:voterList)
        {
            System.out.println(voter);
        }

//
//        for(Voter voter:voters)
//        {
//            System.out.println(voter);
//        }
    }
}
