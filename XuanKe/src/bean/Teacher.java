package bean;

import java.sql.Date;

public class Teacher {
    String Tnum;
    String Tname;
    String Tsex;
    String Title;//职称
    String Tphone;
    String Email;
    Date Tbirth;
    String academy;  //学院外键
    String Passwd;

    public Teacher() {
    }

    public Teacher(String tnum, String tname, String tsex, String title, String tphone, String email, Date tbirth, String academy, String passwd) {
        Tnum = tnum;
        Tname = tname;
        Tsex = tsex;
        Title = title;
        Tphone = tphone;
        Email = email;
        Tbirth = tbirth;
        this.academy = academy;
        Passwd = passwd;
    }

    public String getTnum() {
        return Tnum;
    }

    public void setTnum(String tnum) {
        Tnum = tnum;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTsex() {
        return Tsex;
    }

    public void setTsex(String tsex) {
        Tsex = tsex;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTphone() {
        return Tphone;
    }

    public void setTphone(String tphone) {
        Tphone = tphone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getTbirth() {
        return Tbirth;
    }

    public void setTbirth(Date tbirth) {
        Tbirth = tbirth;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String passwd) {
        Passwd = passwd;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Tnum='" + Tnum + '\'' +
                ", Tname='" + Tname + '\'' +
                ", Tsex='" + Tsex + '\'' +
                ", Title='" + Title + '\'' +
                ", Tphone='" + Tphone + '\'' +
                ", Email='" + Email + '\'' +
                ", Tbirth=" + Tbirth +
                ", academy='" + academy + '\'' +
                ", Passwd='" + Passwd + '\'' +
                '}';
    }
}

