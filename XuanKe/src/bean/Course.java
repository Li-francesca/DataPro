package bean;

public class Course {
    String Cnum;
    String Cname;
    String Credit;//学分
    String Period;//课时
    String academy;//外键，学院

    public Course() {
    }

    public Course(String cnum, String cname, String credit, String period, String academy) {
        Cnum = cnum;
        Cname = cname;
        Credit = credit;
        Period = period;
        this.academy = academy;
    }

    public String getCnum() {
        return Cnum;
    }

    public void setCnum(String cnum) {
        Cnum = cnum;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCredit() {
        return Credit;
    }

    public void setCredit(String credit) {
        Credit = credit;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Cnum='" + Cnum + '\'' +
                ", Cname='" + Cname + '\'' +
                ", Credit='" + Credit + '\'' +
                ", Period='" + Period + '\'' +
                ", academy='" + academy + '\'' +
                '}';
    }
}
