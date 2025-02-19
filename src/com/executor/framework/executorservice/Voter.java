package com.executor.framework.executorservice;

public class Voter
{
    private  String name;
    private int voterId;
    private int age;

    public Voter(String name, int voterId, int age) {
        this.name = name;
        this.voterId = voterId;
        this.age = age;
    }

    public Voter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Voter) {
            Voter voter = (Voter)obj;
            return this.voterId==voter.voterId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.voterId;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Voter Id: " + voterId + ", Age: " + age;
    }
}
