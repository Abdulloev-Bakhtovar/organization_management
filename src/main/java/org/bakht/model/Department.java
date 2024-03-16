package org.bakht.model;

public class Department {
    private int departmentId;
    private String name;
    private Company company;

    public Department() {
    }

    public Department(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", company=" + company +
                '}';
    }
}
