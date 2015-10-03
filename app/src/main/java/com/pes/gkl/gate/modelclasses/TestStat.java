package com.pes.gkl.gate.modelclasses;

/**
 * Created by KAI on 25-Sep-15.
 */
public class TestStat
{
    private  String name;
    private  int correctAnswers;
    public  int rating;
    private  int total;

    public TestStat(String name, int correctAnswers, int rating, int total)
    {
        this.name=name;
        this.correctAnswers=correctAnswers;
        this.rating=rating;
        this.total=total;
    }
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("NAME:");
        builder.append(name);
        builder.append("\n");
        builder.append("CORRECT ANSWERS:");
        builder.append(correctAnswers);
        builder.append("\n");
        builder.append("RATING:");
        builder.append(rating);
        builder.append("\n");
        builder.append("TOTAL:");
        builder.append(total);
        builder.append("\n");
        return builder.toString();
    }
}