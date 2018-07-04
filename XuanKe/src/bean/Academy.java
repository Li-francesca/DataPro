package bean;

public class Academy {
    String Anum;
    String Aname;
    String Director;

    public Academy() {
    }

    public Academy(String anum, String aname, String director) {
        Anum = anum;
        Aname = aname;
        Director = director;
    }

    public String getAnum() {
        return Anum;
    }

    public void setAnum(String anum) {
        Anum = anum;
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    @Override
    public String toString() {
        return "Academy{" +
                "Anum='" + Anum + '\'' +
                ", Aname='" + Aname + '\'' +
                ", Director='" + Director + '\'' +
                '}';
    }
}
