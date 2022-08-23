package com.oraclejava.day1;

// 지원자 클래스
// 사람, 노트북
public class Volunteer {
    private Person person;
    private String notebook;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNotebook() {
        return notebook;
    }

    public void setNotebook(String notebook) {
        this.notebook = notebook;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "person=" + person +
                ", notebook='" + notebook + '\'' +
                "}'";
    }
}
