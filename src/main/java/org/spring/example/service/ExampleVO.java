package org.spring.example.service;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ExampleVO {

    private int exampleNumber;
    private String exampleId;
    private String exampleName;
    private String exampleTitle;
    private String exampleInfo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date exampleDate;

    public int getExampleNumber() { return exampleNumber; }

    public void setExampleNumber(int exampleNumber) {
        this.exampleNumber = exampleNumber;
    }

    public String getExampleId() { return exampleId; }

    public void setExampleId(String exampleId) {
        this.exampleId = exampleId;
    }

    public String getExampleName() {
        return exampleName;
    }

    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }

    public String getExampleTitle() {
        return exampleTitle;
    }

    public void setExampleTitle(String exampleTitle) {
        this.exampleTitle = exampleTitle;
    }

    public String getExampleInfo() {
        return exampleInfo;
    }

    public void setExampleInfo(String exampleInfo) {
        this.exampleInfo = exampleInfo;
    }

    public Date getExampleDate() {
        return exampleDate;
    }

    public void setExampleDate(Date exampleDate) {
        this.exampleDate = exampleDate;
    }

    @Override
    public String toString() {
        return "ExampleVO { "
                + "exampleNumber=" + exampleNumber
                + ", exampleId=\'" + exampleId + "\'"
                + ", exampleName=\'" + exampleName + "\'"
                + ", exampleTitle=\'" + exampleTitle + "\'"
                + ", exampleInfo=\'" + exampleInfo + "\'"
                + ", exampleDate=" + exampleDate
                + " }";
    }
}