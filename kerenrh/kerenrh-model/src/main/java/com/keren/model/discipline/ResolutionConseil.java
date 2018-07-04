/**
 * 
 */
package com.keren.model.discipline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_RECORH")
public class ResolutionConseil extends BaseElement implements Serializable, Comparable<ResolutionConseil> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1269009666995698326L;
	
	@Predicate(label="Référence",optional=false,unique=true,search=true)
	private String code ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de tenue",type=Date.class,target="date",optional=false,search=true)
	private Date datetenue ;
	
	@ManyToOne
	@JoinColumn(name="CC_ID")
	@Predicate(label="Conseil concerné",type=ConvocationConseil.class,target="many-to-one",optional=false,nullable=false,search=true,observable=true)
	@Filter(value="[{\"fieldName\":\"state\",\"value\":\"convoque\"}]")
	private ConvocationConseil convocation ;
	
	@Predicate(label="Lieu de tenue",search=true)
	private String lieutenue ;
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,cascade=CascadeType.ALL)
	@JoinColumn(name="RC_ID")	
	@Predicate(label="DC",type=LigneResolution.class,target="one-to-many",group=true,groupName="group1",groupLabel="Recommendations")
	@Observer(observable="convocation",source="method:demande")
	private List<LigneResolution> lignes = new ArrayList<LigneResolution>();
	
	

	/**
	 * 
	 */
	public ResolutionConseil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ResolutionConseil(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param datetenue
	 * @param convocation
	 * @param lieutenue
	 * @param lignes
	 */

	public ResolutionConseil(long id, String designation, String moduleName, String code, Date datetenue,
			ConvocationConseil convocation, String lieutenue, List<LigneResolution> lignes) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.datetenue = datetenue;
		this.convocation = convocation;
		this.lieutenue = lieutenue;
		this.lignes = lignes;
	}
	
	/**
	 * 
	 * @param re
	 */
	public ResolutionConseil(ResolutionConseil re) {
		super(re.id, re.designation, re.moduleName,re.compareid);
		this.code = re.code;
		this.datetenue = re.datetenue;
		if(re.convocation!=null){
			convocation = new ConvocationConseil(re.convocation);
		}//end if(re.convocation!=null)
		this.lieutenue = re.lieutenue;		
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDatetenue() {
		return datetenue;
	}

	public void setDatetenue(Date datetenue) {
		this.datetenue = datetenue;
	}

	public ConvocationConseil getConvocation() {
		return convocation;
	}

	public void setConvocation(ConvocationConseil convocation) {
		this.convocation = convocation;
	}

	public String getLieutenue() {
		return lieutenue;
	}

	public void setLieutenue(String lieutenue) {
		this.lieutenue = lieutenue;
	}

	public List<LigneResolution> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneResolution> lignes) {
		this.lignes = lignes;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "RESOLUTION DU CONSEIL";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "RESOLUTIONS DU CONSEIL";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ResolutionConseil arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

}
