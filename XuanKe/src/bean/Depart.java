package bean;

public class Depart {
    String Dnum;
    String Dname;
    String director;//外键，教师
    String Anum;//所在学院编号

    public Depart() {
    }

    public Depart(String dnum, String dname, String director, String anum) {
        Dnum = dnum;
        Dname = dname;
        this.director = director;
        Anum = anum;
    }

    public String getDnum() {
        return Dnum;
    }

    public void setDnum(String dnum) {
        Dnum = dnum;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAnum() {
        return Anum;
    }

    public void setAnum(String anum) {
        Anum = anum;
    }

    @Override
    public String toString() {
        return "Depart{" +
                "Dnum='" + Dnum + '\'' +
                ", Dname='" + Dname + '\'' +
                ", director='" + director + '\'' +
                ", Anum='" + Anum + '\'' +
                '}';
    }
}
