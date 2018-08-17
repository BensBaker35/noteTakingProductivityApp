package application.Java;

import java.io.Serializable;
import java.util.List;

public class CourseSchedule implements Serializable {
	
	private List<Days> days;
	private String startTime;
	private String endTime;
	
	public CourseSchedule(List<Days> days, String startTime, String endTime) {
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public List<Days> getDays(){
		return days;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public static Days convertToDays(String str) {
		switch(str) {
		case "Monday":
			return Days.MONDAY;
		case "Tuesday":
			return Days.TUESDAY;
		case "Wedensday":
			return Days.WEDENSDAY;
		case "Thursday":
			return Days.THURSDAY;
		case "Friday":
			return Days.FRIDAY;
		case "Saturday":
			return Days.SATURDAY;
		case "Sunday":
			return Days.SUNDAY;
		default:
				return Days.SUNDAY;
		}
	}
}
