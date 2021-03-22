package com.example.lecture3;

public class AddSubject {

    String subject;
    String professor;


    public AddSubject(String subject, String professor) {
        this.subject = subject;
        this.professor = professor;

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

}
