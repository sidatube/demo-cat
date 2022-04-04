package com.example.demo_cat.entity;

import com.example.demo_cat.annotation.Column;
import com.example.demo_cat.annotation.ForeignKey;
import com.example.demo_cat.annotation.Id;
import com.example.demo_cat.annotation.Table;

@Table(name ="subject_score" )
public class SubjectScore {
    @Id(AutoIncrement = true)
    @Column(name = "id",type = "INT")
    private int id;
    @Column(name = "math",type = "DOUBLE")
    private double math;
    @Column(name = "literature",type = "DOUBLE")
    private double literature;
    @Column(name = "history",type = "DOUBLE")
    private double history;
    @Column(name = "geography",type = "DOUBLE")
    private double geography;
    @Column(name = "chemistry",type = "DOUBLE")
    private double chemistry;
    @ForeignKey(referenceTable = "students",referenceColumn = "id")
    @Column(name = "student_id",type = "INT")
    private int student_id;

    public SubjectScore() {
    }

    public SubjectScore(int id, double math, double literature, double history, double geography, double chemistry, int student_id) {
        this.id = id;
        this.math = math;
        this.literature = literature;
        this.history = history;
        this.geography = geography;
        this.chemistry = chemistry;
        this.student_id = student_id;
    }

    public SubjectScore(double math, double literature, double history, double geography, double chemistry, int student_id) {
        this.math = math;
        this.literature = literature;
        this.history = history;
        this.geography = geography;
        this.chemistry = chemistry;
        this.student_id = student_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getLiterature() {
        return literature;
    }

    public void setLiterature(double literature) {
        this.literature = literature;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }

    public double getGeography() {
        return geography;
    }

    public void setGeography(double geography) {
        this.geography = geography;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
