package bean;

import java.sql.Date;

public class Student {
    String Snum;
    String Sname;
    String Ssex;
    Date Sbirth;
    String Clnum;  //班级classes外键
    String email;
    String Passwd;
    String Status;

    public Student() {
    }

    public Student(String snum, String sname, String ssex, Date sbirth, String clnum, String email, String passwd, String status) {
        Snum = snum;
        Sname = sname;
        Ssex = ssex;
        Sbirth = sbirth;
        Clnum = clnum;
        this.email = email;
        Passwd = passwd;
        Status = status;
    }

    public String getSnum() {
        return Snum;
    }

    public void setSnum(String snum) {
        Snum = snum;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public Date getSbirth() {
        return Sbirth;
    }

    public void setSbirth(Date sbirth) {
        Sbirth = sbirth;
    }

    public String getClnum() {
        return Clnum;
    }

    public void setClnum(String clnum) {
        Clnum = clnum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String passwd) {
        Passwd = passwd;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Snum='" + Snum + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sbirth=" + Sbirth +
                ", Clnum='" + Clnum + '\'' +
                ", email='" + email + '\'' +
                ", Passwd='" + Passwd + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
