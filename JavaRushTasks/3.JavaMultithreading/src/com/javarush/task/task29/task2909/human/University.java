package com.javarush.task.task29.task2909.human;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public void setStudents(ArrayList<Student> students){
        this.students = students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List getStudents(){
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student:students){
            if(student.getAverageGrade()>=averageGrade){
                return student;
            }

        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxAverageGrade=0.0;
        Student studentWithMaxAverageGrade=null;
        for(Student student:students){
            if(maxAverageGrade<student.getAverageGrade()){
                maxAverageGrade=student.getAverageGrade();
                studentWithMaxAverageGrade = student;
            }
        }
        return studentWithMaxAverageGrade;
    }


  public  Student getStudentWithMinAverageGrade(){
      double minAverageGrade=Double.MAX_EXPONENT;
      Student studentWithMimAverageGrade=null;
      for(Student student:students){
          if(minAverageGrade>student.getAverageGrade()){
              minAverageGrade=student.getAverageGrade();
              studentWithMimAverageGrade = student;
          }
      }
      return studentWithMimAverageGrade;
    }

    public void expel(Student student){
      students.remove(student);

    }

    /*6.4. Разделение запроса и модификатора. Раздели метод getStudentWithMinAverageGradeAndExpel
    на Student getStudentWithMinAverageGrade() и void expel(Student student).
    Первый метод должен возвратить студента с минимальным средним балом,
    а второй — отчислить переданного студента (удалять из списка students).*/
}