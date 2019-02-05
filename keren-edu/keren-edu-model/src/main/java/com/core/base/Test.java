/**
 * 
 */
package com.core.base;

import java.text.SimpleDateFormat;
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
		
			SimpleDateFormat   sdf = new SimpleDateFormat("d-MMMM-YYYY");
			String newdate=sdf.format(new Date());
			System.out.println("PeriodePaie.formatdate() new date "+newdate);
			
			
		}
	}

