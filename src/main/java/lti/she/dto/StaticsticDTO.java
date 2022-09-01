package lti.she.dto;

public class StaticsticDTO {
	int ngoCount;
	int coursesCount;
	int hostelCount;
	int userCount;

	public int getNgoCount() {
		return ngoCount;
	}

	public void setNgoCount(int ngoCount) {
		this.ngoCount = ngoCount;
	}

	public int getCoursesCount() {
		return coursesCount;
	}

	public void setCoursesCount(int coursesCount) {
		this.coursesCount = coursesCount;
	}

	public int getHostelCount() {
		return hostelCount;
	}

	public void setHostelCount(int hostelCount) {
		this.hostelCount = hostelCount;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	@Override
	public String toString() {
		return "StaticsticDTO [ngoCount=" + ngoCount + ", CoursesCount=" + coursesCount + ", hostelCount=" + hostelCount
				+ ", userCount=" + userCount + "]";
	}

}
