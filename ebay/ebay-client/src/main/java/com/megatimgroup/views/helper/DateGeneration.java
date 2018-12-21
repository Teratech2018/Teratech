/**
 * 
 */
package com.megatimgroup.views.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.megatim.common.utilities.IsLeapYear;

/**
 * @author mgt
 *
 */
public class DateGeneration {
	public DateGeneration() {
    }

    public static Map<String, Date> getDate(int mois, int annee) {
        Map<String, Date> map = new HashMap<String, Date>();
        switch (mois) {
            case 0: {
                map.put("DateDebut", convertStringToDate("01/01/" + annee));
                map.put("DateFin", convertStringToDate("31/01/" + annee));
                return map;
            }
            case 1: {
                /**
                 * Tester si l'année est bissextile
                 */
                if (IsLeapYear.IsLeapYear(annee)) {
                    map.put("DateDebut", convertStringToDate("01/02/" + annee));
                    map.put("DateFin", convertStringToDate("29/02/" + annee));

                } else {
                    map.put("DateDebut", convertStringToDate("01/02/" + annee));
                    map.put("DateFin", convertStringToDate("28/02/" + annee));
                }
                return map;

            }
            case 2: {
                map.put("DateDebut", convertStringToDate("01/03/" + annee));
                map.put("DateFin", convertStringToDate("31/03/" + annee));
                return map;

            }
            case 3: {
                map.put("DateDebut", convertStringToDate("01/04/" + annee));
                map.put("DateFin", convertStringToDate("30/04/" + annee));
                return map;

            }
            case 4: {
                map.put("DateDebut", convertStringToDate("01/05/" + annee));
                map.put("DateFin", convertStringToDate("31/05/" + annee));
                return map;

            }
            case 5: {
                map.put("DateDebut", convertStringToDate("01/06/" + annee));
                map.put("DateFin", convertStringToDate("30/06/" + annee));
                return map;

            }
            case 6: {
                map.put("DateDebut", convertStringToDate("01/07/" + annee));
                map.put("DateFin", convertStringToDate("31/07/" + annee));
                return map;

            }
            case 7: {
                map.put("DateDebut", convertStringToDate("01/08/" + annee));
                map.put("DateFin", convertStringToDate("31/08/" + annee));
                return map;

            }
            case 8: {
                map.put("DateDebut", convertStringToDate("01/09/" + annee));
                map.put("DateFin", convertStringToDate("30/09/" + annee));
                return map;

            }
            case 9: {
                map.put("DateDebut", convertStringToDate("01/10/" + annee));
                map.put("DateFin", convertStringToDate("31/10/" + annee));
                return map;

            }
            case 10: {
                map.put("DateDebut", convertStringToDate("01/11/" + annee));
                map.put("DateFin", convertStringToDate("30/11/" + annee));
                return map;

            }
            case 11: {
                map.put("DateDebut", convertStringToDate("01/12/" + annee));
                map.put("DateFin", convertStringToDate("31/12/" + annee));
                return map;

            }
            default:
                return null;
        }
    }

    public static Date convertStringToDate(String dateString) {
        Date date = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = df.parse(dateString);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return date;
    }

}
