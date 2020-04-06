package com.example.ElasticSrearchImportData;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

import java.util.Objects;

@Document(indexName = "Department", createIndex = false)
public class Department {

    @Id
    private int depNo;
    private String name;


    public Department(int depNo, String name) {
        this.depNo = depNo;
        this.name = name;
    }

    public int getDepNo() {
        return depNo;
    }

    public void setDepNo(int depNo) {
        this.depNo = depNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        if (getDepNo() != that.getDepNo()) return false;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        int result = getDepNo();
        result = 31 * result + getName().hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Department{" +
                "depNo=" + depNo +
                ", name='" + name + '\'' +
                '}';
    }
}
