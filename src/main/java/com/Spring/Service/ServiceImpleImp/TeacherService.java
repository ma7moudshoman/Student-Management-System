package com.Spring.Service.ServiceImpleImp;


import java.util.List;

import com.Spring.model.Teacher;

public interface TeacherService {
    public List<Teacher> allTeacher();
    public void deleteTeacher(int id);
    public void addTeacher(Teacher teacher);
    public  Teacher getTeacher(int id);
}
