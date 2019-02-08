/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DEV_4
 */
public class DateHelper {
	
	
	
	public static Date getDateDay(int nombreday, Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, +nombreday);
		date = cal.getTime();
		return date;
	}
	
	public static Date formatDate(Date date){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = f.parse(f.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.getActualMinimum(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}

	/**
	 * Renvoi le nom du mois correspondant
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthName(Date date) {
		if (date != null) {
			//System.out.println("DateHelper.getMonthName() get date " + date);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			switch (c.get(Calendar.MONTH)) {
			case Calendar.JANUARY:
				return "Janvier";
			case Calendar.FEBRUARY:
				return "Février";
			case Calendar.MARCH:
				return "Mars";
			case Calendar.APRIL:
				return "Avril";
			case Calendar.MAY:
				return "Mai";
			case Calendar.JUNE:
				return "Juin";
			case Calendar.JULY:
				return "Juillet";
			case Calendar.AUGUST:
				return "Août";
			case Calendar.SEPTEMBER:
				return "Septembre";
			case Calendar.OCTOBER:
				return "Octobre";
			case Calendar.NOVEMBER:
				return "Novembre";
			default:
				return "Decembre";
			}
		}
		return "";
	}

	/**
	 * Renvoi le nom du mois correspondant
	 * 
	 * @param date
	 * @return
	 */
	public static String getLastMonthName(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		switch (c.get(Calendar.MONTH)) {
		case Calendar.JANUARY:
			return "Decembre";
		case Calendar.FEBRUARY:
			return "Janvier";
		case Calendar.MARCH:
			return "Février";
		case Calendar.APRIL:
			return "Mars";
		case Calendar.MAY:
			return "Avril";
		case Calendar.JUNE:
			return "Mai";
		case Calendar.JULY:
			return "Juin";
		case Calendar.AUGUST:
			return "Juillet";
		case Calendar.SEPTEMBER:
			return "Août";
		case Calendar.OCTOBER:
			return "Septembre";
		case Calendar.NOVEMBER:
			return "Novembre";
		default:
			return "Janvier";
		}
	}

	/**
	 * Renvoie la date dans
	 * 
	 * @param debut
	 * @param jour
	 * @return
	 */
	public static Date next(Date debut, int jour) {

		if (debut == null)
			return null;

		Calendar c = Calendar.getInstance();
		c.setTime(debut);
		c.add(Calendar.DATE, jour);
		return c.getTime();
	}

	/**
	 * Verifie que une date est comprise entre 2 autres date
	 * 
	 * @param date
	 * @param debut
	 * @param fin
	 * @return
	 */
	public static Boolean between(Date date, Date debut, Date fin) {

		if (convertToString(date, "yyyyMMdd").compareTo(convertToString(debut, "yyyyMMdd")) >= 0
				&& convertToString(date, "yyyyMMdd").compareTo(convertToString(fin, "yyyyMMdd")) <= 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param begin
	 * @param end
	 * @param time
	 * @return
	 */
	public static long times(Date begin, Date end, Date time) {

		Calendar c = Calendar.getInstance();

		c.setTime(end);

		c.set(Calendar.HOUR_OF_DAY, time.getHours());
		c.set(Calendar.MINUTE, time.getMinutes());
		c.set(Calendar.SECOND, time.getSeconds());

		long times = c.getTimeInMillis() - begin.getTime();
		// System.out.println("DateHelper.times(Date begin , Date end , Date
		// time) :::::::::::::::::::::::::::::::::::: "+c.getTime());
		return times;
	}

	/**
	 * 
	 * @param begin
	 * @param end
	 * @param time
	 * @return
	 */
	public static double hours(String begin, String end, Date time) {

		String[] parts = begin.split(":");

		String begin1 = parts[0];
		String begin2 = parts[1];
		//System.out.println("DateHelper.hours() begin "+begin1+"begin 11"+begin2);
		Calendar d = Calendar.getInstance();
		time = new Date();
		d.setTime(time);
		d.set(Calendar.HOUR, Integer.valueOf(begin1));
		d.set(Calendar.MINUTE, Integer.valueOf(begin2));

		String[] ends = end.split(":");

		String end1 = ends[0];
		String end2 = ends[1];
		Calendar e = Calendar.getInstance();
		time = new Date();
		e.setTime(time);
		e.set(Calendar.HOUR, Integer.valueOf(end1));
		e.set(Calendar.MINUTE, Integer.valueOf(end2));

		long times = (e.getTimeInMillis() - d.getTimeInMillis())/1000;
		double hours = (double)times / 3600 ;
		//System.out.println("DateHelper.hours() nombre heure is "+hours);
		return hours;
	}

	/**
	 * Convertion date en String
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String convertToString(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	public static Date dayofWeek(Date date, int day) {

		Date result = null;

		Calendar c = Calendar.getInstance();

		c.setTime(date);

		if (day == Calendar.MONDAY) {
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			result = c.getTime();
		} else if (day == Calendar.TUESDAY) {
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			result = c.getTime();
		} else if (day == Calendar.WEDNESDAY) {
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			result = c.getTime();
		} else if (day == Calendar.THURSDAY) {
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
			result = c.getTime();
		} else if (day == Calendar.FRIDAY) {
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			result = c.getTime();
		} else if (day == Calendar.SATURDAY) {
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			result = c.getTime();
		} else if (day == Calendar.SUNDAY) {
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			result = c.getTime();
		}

		if (result.compareTo(date) < 0)
			return null;
		// System.out.println("SauvegardeCromHelper.computeSavePeriode(Date
		// debut , Date fin, CycleSauvegarde cycle , SemaineSauvegarde semaine ,
		// JourSauvegarde jour) ::::::::::::::
		// "+c.getTime()+"::::::::::::::::::::::: "+date);
		return result;
	}

	/**
	 * 
	 * @param date
	 */
	public static Date nextWeek(Date date) {

		Date result = null;

		Calendar c = Calendar.getInstance();

		c.setTime(date);

		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			result = next(c.getTime(), 6);
		} else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
			result = next(c.getTime(), 5);
		} else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
			result = next(c.getTime(), 4);
		} else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
			result = next(c.getTime(), 3);
		} else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			result = next(c.getTime(), 2);
		} else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			result = next(c.getTime(), 1);
		}
		return result;
	}

	/**
	 * Renvoide le premier jour du mois suivant
	 * 
	 * @param date
	 * @return
	 */
	public static Date nextMonth(Date date) {

		Date result = null;

		Calendar c = Calendar.getInstance();

		c.setTime(date);

		c.add(Calendar.MONTH, 1);

		c.set(Calendar.DAY_OF_MONTH, 1);

		result = c.getTime();

		return result;

	}

	/**
	 * Renvoide le premier jour du mois suivant
	 * 
	 * @param date
	 * @param horizon
	 * @return
	 */
	public static Date nextMonth(Date date, int horizon) {

		if (horizon <= 0) {
			return date;
		}
		Date result = null;

		Calendar c = Calendar.getInstance();

		c.setTime(date);

		c.add(Calendar.MONTH, horizon);

		c.set(Calendar.DAY_OF_MONTH, 1);

		result = c.getTime();

		return result;

	}

	/**
	 * Renvoie le 1er jour de la week semaine du mois a
	 * 
	 * @param date
	 * @param week
	 * @return
	 */
	public static Date week(Date date, int week) {

		if (date == null)
			return null;

		Calendar c = Calendar.getInstance();

		c.setTime(date);

		c.set(Calendar.WEEK_OF_MONTH, week);

		return c.getTime();
	}

	/**
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int numberOfMonth(Date begin, Date end) {
		int number = 0;

		Date debut = begin;
		while (convertToString(debut, "yyyy-MM-dd").compareTo(convertToString(end, "yyyy-MM-dd")) <= 0) {
			number = number + 1;
			debut = nextMonth(debut);
		} // end while(convertToString(debut,
			// "yyyy-MM-dd").compareTo(convertToString(end, "yyyy-MM-dd"))<=0)
		return number;
	}

	/**
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int numberOfDays(Date begin, Date end) {
		int number = 0;

		Date debut = begin;
		while (convertToString(debut, "yyyy-MM-dd").compareTo(convertToString(end, "yyyy-MM-dd")) <= 0) {
			number = number + 1;
			debut = next(debut, 1);
		} // end while(convertToString(debut,
			// "yyyy-MM-dd").compareTo(convertToString(end, "yyyy-MM-dd"))<=0)
		return number;
	}

	/**
	 * 
	 * @param heure
	 * @return
	 */
	public static Double getHours(String heure) {
		Double hours = 0.0;
		int index = 1;
		String[] bsplit = heure.split(":");
		for (String block : bsplit) {
			if (index == 1) {
				hours += Double.parseDouble(block) * 60 * 60;
			} else if (index == 2) {
				hours += Double.parseDouble(block) * 60;
			} else if (index == 3) {
				hours += Double.parseDouble(block);
			}
		} // end for(String block:bsplit){
		return hours;
	}

	/**
	 * Hours format HH:MM:SS
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static Double numberHours(String begin, String end) {
		return getHours(end) - getHours(begin);
	}

	public String anciente(Date embauche) {
		String ancienete = null;
		Date dateFin = new Date();
		int year = dateFin.getYear() - embauche.getYear();
		int month = dateFin.getMonth() - embauche.getMonth();
		int day = dateFin.getDay() - embauche.getDay();

		if (month < 0) {
			year = year - 1;
			month = month + 12;
		}
		if (day < 0) {
			month = month - 1;
			day = day + 30;
		}
		ancienete = year + "  An(s)" + month + " mois" + day + " jour(s)";
		return ancienete;
	}

	public static Date getdateAnniversaire(Date date, int param) {
		Date d1 = null;
		Date d = null;
		try {

			Calendar c = Calendar.getInstance();
			Calendar c1 = Calendar.getInstance();
			c.setTime(date);
			c1.setTime(new Date());
			int day = c.get(Calendar.DATE);
			int month = c.get(Calendar.MONTH);
			int year = c1.get(Calendar.YEAR);
			c.set(Calendar.DAY_OF_MONTH, day);
			c.set(Calendar.MONTH, month);
			c.set(Calendar.YEAR, year);
//			System.out.println("DateHelper.getdateAnniversaire() " + day);
//			System.out.println("DateHelper.getdateAnniversaire() " + month + 1);
//			System.out.println("DateHelper.getdateAnniversaire() " + year);
			// utiliser le calendrier par défaut

			c.add(Calendar.DATE, -param);
			d1 = c.getTime();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			d = df.parse(df.format(d1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println("DateHelper.DateBeforeParam() new date " + d);
		return d;
	}

	public static String getdateAnniversaire(Date date) {
		Date d1 = null;
		String d = "";
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		c.setTime(date);
		c1.setTime(new Date());
		int day = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH);
		int year = c1.get(Calendar.YEAR);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.YEAR, year);
//		System.out.println("DateHelper.getdateAnniversaire() " + day);
//		System.out.println("DateHelper.getdateAnniversaire() " + month + 1);
//		System.out.println("DateHelper.getdateAnniversaire() " + year);
		// utiliser le calendrier par défaut
		d1 = c.getTime();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		d = df.format(d1);
		//System.out.println("DateHelper.DateBeforeParam() new date " + d);
		return d;
	}

	public static String getMonthDay(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
		String d = "";
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();

		d = day + "/" + month;

		return d;
	}

	public static String getYears(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		return year + "";
	}

	// /**
	// *
	// * @param debut
	// * @param fin
	// * @return
	// */
	// public static Map<int> periodeExercice(Date debut , Date fin){
	// List<String> result = new ArrayList<String>();
	// Date begin = debut;
	// while(begin.compareTo(fin)<=0){
	// StringBuffer buffer = new StringBuffer();
	// buffer.append(getMonthName(begin));
	// buffer.append(begin.getYear()+1900);
	// result.add(buffer.toString());
	// begin = nextMonth(begin);
	// }
	// return result ;
	// }
}
