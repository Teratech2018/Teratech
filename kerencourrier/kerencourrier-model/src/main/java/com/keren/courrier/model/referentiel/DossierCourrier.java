/**
 * 
 */
package com.keren.courrier.model.referentiel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author NTW table type correspondants
 */
@Entity
@Table(name = "T_DOCOKC")
public class DossierCourrier extends BaseElement implements Serializable, Comparable<DossierCourrier> {

        @Predicate(label = "Dossier",optional = false,unique = true,search = true)
	private String code ;
        
        @Predicate(label = "Confidentiel",type = Boolean.class,target = "checkbox",search = true)
        private Boolean confidentialite = Boolean.FALSE;
        
        @Predicate(label = "Désignation",optional = true,search = true)
        private String intitule ;
        
        @Predicate(label = "Style",optional = false,target = "combobox",values = "Beige;Bleu;Bleu(gras);Gris;Jaune;Marron;Noir;Noir(gras);Orange;Orange(gras);Rose;Rouge;Vert;Violet",search = true)
        private String style ;
        
        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "T_DOCOTYDOKC",joinColumns = @JoinColumn(name = "DOC_ID"),inverseJoinColumns = @JoinColumn(name = "TYDO_ID"))
        @Predicate(label = "Type de dossier",type = TypeDossier.class,target = "many-to-many")
        private List<TypeDossier> typesdossiers = new ArrayList<TypeDossier>() ;       
        
        @ManyToOne
        @JoinColumn(name = "PAR_ID")
        @Predicate(label = "Dossier Parent",type = DossierCourrier.class,target = "one-to-many",search = true)
        private DossierCourrier parent ;        
         
        @Predicate(label = "Nature Dossier",target = "combobox",values = "Conteneur;Detail")
        private String classement ;
        

        public DossierCourrier() {
        }

        public DossierCourrier(String code, String intitule, String style, DossierCourrier parent) {
            this.code = code;
            this.intitule = intitule;
            this.style = style;
            this.parent = parent;
        }

        public DossierCourrier(String code, String intitule, String style, DossierCourrier parent, long id, String designation, String moduleName, long comparedid) {
            super(id, designation, moduleName, comparedid);
            this.code = code;
            this.intitule = intitule;
            this.style = style;
            this.parent = parent;
        }

       public DossierCourrier(DossierCourrier entity) {
            super(entity.id, entity.designation, entity.moduleName, entity.compareid);
            this.code = entity.code;
            this.intitule = entity.intitule;
            this.style = entity.style;
            this.classement = entity.classement;
            if(entity.parent!=null){
                this.parent = new DossierCourrier(entity.parent);
            }
        }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public List<TypeDossier> getTypesdossiers() {
        return typesdossiers;
    }

    public void setTypesdossiers(List<TypeDossier> typesdossiers) {
        this.typesdossiers = typesdossiers;
    }

    public DossierCourrier getParent() {
        return parent;
    }

    public void setParent(DossierCourrier parent) {
        this.parent = parent;
    }

    public Boolean getConfidentialite() {
        return confidentialite;
    }

    public void setConfidentialite(Boolean confidentialite) {
        this.confidentialite = confidentialite;
    }

    public String getClassement() {
        return classement;
    }

    public void setClassement(String classement) {
        this.classement = classement;
    }

   

    @Override
    public String getDesignation() {
        return code+" - "+intitule; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Chemises courriers"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Chemise courrier"; //To change body of generated methods, choose Tools | Templates.
    }
       
       
        
        
        @Override
        public int compareTo(DossierCourrier o) {
            return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
        }
        
    	@Override
    	public boolean isCreateonfield() {
    		return true; // To change body of generated methods, choose Tools |
    						// Templates.
    	}

}
