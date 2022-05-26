package com.example.geektrust;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateService {
	private Date startDate;
	private String renewalDate;
	private String validateDate;

	DateService(String date, IPlan plan) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			sdf.setLenient(false);
			this.startDate = sdf.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(this.startDate);
			cal.add(Calendar.MONTH, plan.duration());
			cal.add(Calendar.DATE, -10);
			this.renewalDate = new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("INVALID_DATE");
		}
	}

	public String renewalDate() {
		return this.renewalDate;
	}
}
