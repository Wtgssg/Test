package com.success.Pojo;

import cn.hutool.core.annotation.Alias;
import cn.hutool.core.date.DateTime;
import org.apache.fesod.sheet.annotation.format.DateTimeFormat;

public class Employee {
    @Alias("ID")
    String Id;
    @Alias("姓名")
    String Name;
    @Alias("部门")
    String Dept;
    @Alias("薪资")
    String Salary;
    @Alias("日期")
    DateTime dateTime;

    public Employee() {
    }

    public Employee(String id, String name, String dept, String salary, DateTime dateTime) {
        Id = id;
        Name = name;
        Dept = dept;
        Salary = salary;
        this.dateTime = dateTime;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Dept='" + Dept + '\'' +
                ", Salary='" + Salary + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
