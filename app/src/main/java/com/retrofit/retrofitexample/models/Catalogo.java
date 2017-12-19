package com.retrofit.retrofitexample.models;

import java.util.List;

/**
 * Created by Hitss on 19/12/2017.
 */

public class Catalogo {

    public List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
