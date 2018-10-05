/**
 * 
 */
package com.keren.courrier.model.others;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "SEQ_CI")
public class CinterneSeqGenerator extends BaseElement
		implements Serializable, Comparable<CinterneSeqGenerator> {

	@Column(name = "CODE")
	private String code;

	@Column(name = "VAL_SEQ")
	private long sequence = 0L;
	
	@Column(name = "ANNEE")
	private long annee = 0L;


	@Override
	public int compareTo(CinterneSeqGenerator o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CinterneSeqGenerator(String code, long sequence) {
		super();
		this.code = code;
		this.sequence = sequence;
		
	}
	
	public CinterneSeqGenerator(CinterneSeqGenerator entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.code = entity.code;
		this.sequence = entity.sequence;
		this.annee=entity.annee;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public long getAnnee() {
		return annee;
	}

	public void setAnnee(long annee) {
		this.annee = annee;
	}





}
