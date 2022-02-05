package com.albamch.studentsservice.mapper;

import com.albamch.modelcommons.models.students.Student;
import com.albamch.modelcommons.models.users.User;

public class mapper {

    public static User mapStudentToUser (Student student) {

        User user = new User();
        user.setEmail(student.getEmail());
        user.setEnable(false);
        user.set

    }
}
