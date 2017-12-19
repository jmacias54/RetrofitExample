package com.retrofit.retrofitexample.models;

import java.util.List;

/**
 * Created by Hitss on 19/12/2017.
 */

public class Course {


    public String title;
    public String subtitle;
    public List<Instructor> instructors;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }
}
