package com.example.lecture3;

public class Subject {

    String subject;
    String professor;
    String time;

    public Subject(String subject, String professor, String time) {
        this.subject = subject;
        this.professor = professor;
        this.time = time;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
