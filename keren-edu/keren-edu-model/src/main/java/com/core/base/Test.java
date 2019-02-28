/**
 * 
 */
package com.core.base;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.core.tools.DateHelper;

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
			Date date1;
			try {
				date1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2016");
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2019");
				double year =DateHelper.numberOfyear(date1, date2);
				BigDecimal bd = new BigDecimal(year);
				bd = bd.setScale(0, BigDecimal.ROUND_UP);
				Double netarond = bd.doubleValue();
				System.out.println("Test.main() year is "+netarond);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		


			
		}
	}

