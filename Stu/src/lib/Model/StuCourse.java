package lib.Model;

import java.sql.Date;

public class StuCourse {
	private String Snum;
	private String Cnum;
	private String Grade;
	private String Tnum;
	private Date Ynum;
	private int Term;
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
	
}
