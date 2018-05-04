package com.keren.kerenpaie.jaxrs.impl.rapports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPopupMenu.Separator;

import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.rapports.ViewDipePaie;
import com.keren.kerenpaie.tools.report.DipeItem;
import com.keren.kerenpaie.tools.report.DipeItemDeb;
import com.keren.kerenpaie.tools.report.DipeItemFin;
import com.keren.kerenpaie.tools.report.LineFormatter;
import com.keren.kerenpaie.tools.report.ReportHelper;
import com.keren.kerenpaie.tools.report.ValidatorDipe;

public class DipeGenerator {

	private static String fileName;
	public static final String extension = ".txt";
	private static char separator ='0';

	private static Date date;

	/**
	 * Geeration du fichier
	 * 
	 * @param datas
	 * @throws IOException
	 */
	private static File transformDM(List<DipeItem> datas, PeriodePaie periode) throws IOException {
		fileName = ReportHelper.templateURL;
		date = new Date();
		StringBuilder builder = new StringBuilder(fileName);
		builder.append(File.separatorChar).append(fileNameDipeMensuel(periode));

		System.out.println(
				"========================================================================= " + builder.toString());
		File file = new File(builder.toString());

		// Creation du fichier
		file.createNewFile();

		// Creation d'un
		FileWriter writer = new FileWriter(file);
		// Creation d'un tempon de sortie
		BufferedWriter buffer = new BufferedWriter(writer);

		// Creation d'un line formatter
		LineFormatter formatter = new LineFormatter();
		// Ecriture en tete

		// Traitement des données
		for (DipeItem item : datas) {

			buffer.write(formatter.format(item.toStringDipeMensuel()));
			buffer.newLine();
		}
		// Mise a jour du fichier
		// buffer.write(formatter.format(Integer.toString(datas.size())));
		// buffer.newLine();
		// Cloture du tempon
		buffer.close();
		// Cloture du flux
		writer.close();
		return file;
	}
	
	/**
	 * Geeration du fichier
	 * 
	 * @param datas
	 * @throws IOException
	 */
	private static void transformDipeDeb(List<DipeItemDeb> datas, PeriodePaie periode) throws IOException {
		fileName = ReportHelper.templateURL;
		date = new Date();
		StringBuilder builder = new StringBuilder(fileName);
		builder.append(File.separatorChar).append(fileNameDipeMensuel(periode));

		System.out.println(
				"========================================================================= " + builder.toString());
		File file = new File(builder.toString());

		// Creation du fichier
		file.createNewFile();

		// Creation d'un
		FileWriter writer = new FileWriter(file);
		// Creation d'un tempon de sortie
		BufferedWriter buffer = new BufferedWriter(writer);

		// Creation d'un line formatter
		LineFormatter formatter = new LineFormatter();
		// Ecriture en tete

		// Traitement des données
		for (DipeItemDeb item : datas) {

			buffer.write(formatter.format(item.toStringDipeDebut()));
			buffer.newLine();
		}
		// Mise a jour du fichier
		// buffer.write(formatter.format(Integer.toString(datas.size())));
		// buffer.newLine();
		// Cloture du tempon
		buffer.close();
		// Cloture du flux
		writer.close();
	}

	private static void transformDipeFin(List<DipeItemFin> datas, PeriodePaie periode) throws IOException {
		fileName = ReportHelper.templateURL;
		date = new Date();
		StringBuilder builder = new StringBuilder(fileName);
		builder.append(File.separatorChar).append(fileNameDipeMensuel(periode));

		System.out.println(
				"========================================================================= " + builder.toString());
		File file = new File(builder.toString());

		// Creation du fichier
		file.createNewFile();

		// Creation d'un
		FileWriter writer = new FileWriter(file);
		// Creation d'un tempon de sortie
		BufferedWriter buffer = new BufferedWriter(writer);

		// Creation d'un line formatter
		LineFormatter formatter = new LineFormatter();
		// Ecriture en tete

		// Traitement des données
		for (DipeItemFin item : datas) {

			buffer.write(formatter.format(item.toStringDipeFin()));
			buffer.newLine();
		}
		// Mise a jour du fichier
		// buffer.write(formatter.format(Integer.toString(datas.size())));
		// buffer.newLine();
		// Cloture du tempon
		buffer.close();
		// Cloture du flux
		writer.close();
	}

	
	public static File process(List<ViewDipePaie> list, ViewDipePaie entity) {
		File file = null ;
		try {
			
			if(entity.getDipe().equals("0")){
				List<DipeItem> dpItems = new ArrayList<DipeItem>();
				ValidatorDipe<DipeItem> validatorClass = new ValidatorDipe<DipeItem>();
				// conversion des données en dipeItem
				dpItems = DipeHelper.convertFromDItem(list);
				// Validation des Item
				dpItems = validatorClass.validator(dpItems, separator);
				System.out.println("DipeGenerator.process() validation OK ");
				// generations des données dans e fichiers
				file=transformDM(dpItems, entity.getPeriode());
			}
			if(entity.getDipe().equals("1")){
				List<DipeItemDeb> dpItems = new ArrayList<DipeItemDeb>();
				ValidatorDipe<DipeItemDeb> validatorClass = new ValidatorDipe<DipeItemDeb>();
				// conversion des données en dipeItem
				dpItems = DipeHelper.convertFromDItemDeb(list);
				// Validation des Item
				dpItems = validatorClass.validator(dpItems, separator);
				System.out.println("DipeGenerator.process() validation OK ");
				// generations des données dans e fichiers
				transformDipeDeb(dpItems, entity.getPeriode());
			}
			
			if(entity.getDipe().equals("2")){
				List<DipeItemFin> dpItems = new ArrayList<DipeItemFin>();
				ValidatorDipe<DipeItemFin> validatorClass = new ValidatorDipe<DipeItemFin>();
				// conversion des données en dipeItem
				dpItems = DipeHelper.convertFromDItemFin(list);
				// Validation des Item
				dpItems = validatorClass.validator(dpItems, separator);
				System.out.println("DipeGenerator.process() validation OK ");
				// generations des données dans e fichiers
				transformDipeFin(dpItems, entity.getPeriode());
			}
			
		
		} catch (IOException e) {
			Logger.getLogger(DipeGenerator.class.getName()).log(Level.SEVERE, null, e);
		} catch (IllegalAccessException il) {
			Logger.getLogger(DipeGenerator.class.getName()).log(Level.SEVERE, null, il);
		}
		return file;

	}

	/**
	 * 
	 * @return
	 */
	private static String fileNameDipeMensuel(PeriodePaie pediode) {

		StringBuilder builder = new StringBuilder();

		builder.append(DipeHelper.jourMois(pediode.getDfin())).append("DIPE".toString()).append(extension);

		return builder.toString();
	}


}
