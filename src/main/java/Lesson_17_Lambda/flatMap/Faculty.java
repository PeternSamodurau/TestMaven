package Lesson_17_Lambda.flatMap;

import Lesson_17_Lambda.Student;

import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private List<Student> studentsOnFaculty;

    public Faculty(String name, List<Student> studentsOnFaculty) {
        this.name = name;
        this.studentsOnFaculty = studentsOnFaculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void setStudentsOnFaculty(List<Student> studentsOnFaculty) {
        this.studentsOnFaculty = studentsOnFaculty;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Faculty faculty = (Faculty) object;
        return Objects.equals(name, faculty.name) && Objects.equals(studentsOnFaculty, faculty.studentsOnFaculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentsOnFaculty);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", studentsOnFaculty=" + studentsOnFaculty +
                '}';
    }
}
