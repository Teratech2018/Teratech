/**
 * 
 */
package com.kerenedu.tools.reports;

import java.math.BigDecimal;
import java.util.Locale;

import com.ibm.icu.text.RuleBasedNumberFormat;

/**
 * @author Nadege
 *
 */
public class KerenSchoolTools {
	
	public static String getFormatLetter(Double value){
		
		RuleBasedNumberFormat rbnf = new RuleBasedNumberFormat(Locale.FRANCE, RuleBasedNumberFormat.SPELLOUT);

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(0, BigDecimal.ROUND_UP);
		Double netarond = bd.doubleValue();
		String mntEnlettre = rbnf.format(netarond);
		return mntEnlettre;
	}

}
