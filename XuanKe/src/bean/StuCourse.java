package bean;

import java.sql.Date;

public class StuCourse {
    String Snum; //学生学号；
    String Cnum;//课程编号；
    String Grade;//成绩
    String Tnum;//教师编号
    Date Ynum;//开课学期
    int Term;//开课年度

    public StuCourse() {
    }

    public StuCourse(String snum, String cnum, String grade, String tnum, Date ynum, int term) {
        Snum = snum;
        Cnum = cnum;
        Grade = grade;
        Tnum = tnum;
        Ynum = ynum;
        Term = term;
    }

    public String getSnum() {
        return Snum;
    }

    public void setSnum(String snum) {
        Snum = snum;
    }

    public String getCnum() {
        return Cnum;
    }

    public void setCnum(String cnum) {
        Cnum = cnum;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getTnum() {
        return Tnum;
    }

    public void setTnum(String tnum) {
        Tnum = tnum;
    }

    public Date getYnum() {
        return Ynum;
    }

    public void setYnum(Date ynum) {
        Ynum = ynum;
    }

    public int getTerm() {
        return Term;
    }

    public void setTerm(int term) {
        Term = term;
    }

    @Override
    public String toString() {
        return "StuCourse{" +
                "Snum='" + Snum + '\'' +
                ", Cnum='" + Cnum + '\'' +
                ", Grade='" + Grade + '\'' +
                ", Tnum='" + Tnum + '\'' +
                ", Ynum=" + Ynum +
                ", Term=" + Term +
                '}';
    }
}
