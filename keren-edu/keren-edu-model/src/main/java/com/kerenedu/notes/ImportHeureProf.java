package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.solde.PeriodePaie;
import com.megatim.common.annotations.Predicate;

public class ImportHeureProf extends BaseElement implements Serializable, Comparable<ImportHeureProf> {

	@ManyToOne
	@JoinColumn(name = "PERIODE_ID")
	@Predicate(label = "Periode", type = PeriodePaie.class, target = "many-to-one", search = true, sequence = 1, optional = false, observable = true)
	protected PeriodePaie periode;

	@Predicate(label = "Fichier lié", target = "file", search = true, sequence = 5)
	private String filename;
	
	@Predicate(label = "", type = Long.class, search = true, sequence = 6)
	private String className;
	

	public ImportHeureProf(PeriodePaie periode) {
		this.periode = periode;
	}

	public ImportHeureProf(ImportHeureProf entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);

		this.periode = new PeriodePaie(entity.periode);
		this.filename=entity.filename;
		this.className=entity.className;
	}

	public ImportHeureProf() {
	}

	public int compareTo(ImportHeureProf o) {
		return 0;
	}

	public String getEditTitle() {
		return "Imorter les notes  ";
	}

	public String getListTitle() {
		return "Importer les notes";
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public PeriodePaie getPeriode() {
		return periode;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}

	

}
