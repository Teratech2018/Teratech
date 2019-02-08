/**
 * 
 */
package com.core.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Nadege
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			SimpleDateFormat   sdf = new SimpleDateFormat("YYYY-MM-dd");
			String newdate=sdf.format(new Date());
			System.out.println("PeriodePaie.formatdate() new date "+newdate);
			Calendar xx=Calendar.getInstance();	
			xx.add(Calendar.DAY_OF_MONTH,0);
			xx.add(Calendar.MONTH, 2);
			int jour = xx.get(Calendar.DAY_OF_MONTH);
			int mois = xx.get(Calendar.MONTH);
			int annee = xx.get(Calendar.YEAR);
			System.out.println("Test.main()"+jour +"mois "+mois+"annee"+annee);
			
			xx.set(Calendar.DAY_OF_MONTH, jour);
			xx.set(Calendar.MONTH, mois-1);
			xx.set(Calendar.YEAR, annee);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String newdate1=formatter.format(xx.getTime());
			Date d;
			try {
				d = formatter.parse(newdate1);
				System.out.println("Test.main() new date is "+d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			
		}
	}

