package lib.Model;

public class Course {
	private String Cnum;
	private String Cname;
	private String Credit;
	private String Period;
	private String academy;
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

}
