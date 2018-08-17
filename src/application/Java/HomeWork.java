package application.Java;

import java.util.Date;

public class HomeWork implements ICourseWork {

	String name;
	Date dateDue;
	Course course;
	String task;
	HomeWorkType homeWorkType;
	
	public HomeWork(String name, Date dueDate, Course course, String task, HomeWorkType type) {
		this.name = name;
		this.dateDue = dueDate;
		this.course = course;
		this.task = task;
		this.homeWorkType = type;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Date getDueDate() {
		return dateDue;
	}

	@Override
	public Course getCourse() {
		return course;
	}
	public HomeWorkType getHWType() {
		return homeWorkType;
	}
	public String getTask() {
		return task;
	}

}
