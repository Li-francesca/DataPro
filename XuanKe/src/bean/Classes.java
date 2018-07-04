package bean;

public class Classes {
    String Clnum;
    String Cname;
    String Dnum;//外键，所在专业编号
    String Grade;//所属年级

    public Classes() {
    }

    public Classes(String clnum, String cname, String dnum, String grade) {
        Clnum = clnum;
        Cname = cname;
        Dnum = dnum;
        Grade = grade;
    }

    public String getClnum() {
        return Clnum;
    }

    public void setClnum(String clnum) {
        Clnum = clnum;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getDnum() {
        return Dnum;
    }

    public void setDnum(String dnum) {
        Dnum = dnum;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "Clnum='" + Clnum + '\'' +
                ", Cname='" + Cname + '\'' +
                ", Dnum='" + Dnum + '\'' +
                ", Grade='" + Grade + '\'' +
                '}';
    }
}
