package hello.hellospring.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Majors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String major_name;
    private int major_number;
    private String category;
    private int recommend_time;
    private int this_time;
    private String professor_name;
    private int division_number;

    public String getMajor_name() {
        return major_name;
    }
    public int getMajor_number() {
        return major_number;
    }
    public String getCategory() {
        return category;
    }
    public int getRecommend_time() {
        return recommend_time;
    }
    public int getThis_time() {
        return this_time;
    }
    public String getProfessor_name() {
        return professor_name;
    }
    public int getDivision_number() {
        return division_number;
    }
    /*
    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }
    public void setMajor_number(int major_number) { this.major_number = major_number; }
    public void setCategory(String category) {
        this.category = category;
    }
     public void setRecommend_time(int recommend_time) {
        this.recommend_time = recommend_time;
    }
    public void setThis_time(int this_time) {
        this.this_time = this_time;
    }
    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }
    public void setDivision_number(int division_number) {
        this.division_number = division_number;
    }*/
}
