/**
 * 
 */
package com.keren.courrier.model.referentiel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author NTW
 * table type correspondants
 */
@Entity
@Table(name="T_TYDOKC")
public class TypeDossier extends BaseElement implements Serializable, Comparable<TypeDossier> {
	

	@Predicate(label="Type Dossier",optional=false,unique = true,search=true )
	private String code ;
	
        @Predicate(label="Désignation",optional=false,search=true)
        private String intitule ;
        
	@Predicate(label="",optional=false,search=true , target = "textarea",group = true,groupName = "group1",groupLabel = "Commentaire" )
	private String commentaire ;

	/**
	 * 
	 */
	public TypeDossier() {
		// TODO Auto-generated constructor stub
	}

        /**
         * 
         * @param code
         * @param intitule
         * @param commentaire
         * @param id
         * @param designation
         * @param moduleName
         * @param comparedid 
         */
        public TypeDossier(String code, String intitule, String commentaire, long id, String designation, String moduleName, long comparedid) {
            super(id, designation, moduleName, comparedid);
            this.code = code;
            this.intitule = intitule;
            this.commentaire = commentaire;
        }
        
        public TypeDossier(TypeDossier entity) {
            super(entity.id, entity.designation, entity.moduleName, entity.compareid);
            this.code = entity.getCode();
            this.intitule = entity.getIntitule();
            this.commentaire = entity.getCommentaire();
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


	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Type de Dossier";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Type de Dossier";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerencourrier";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+intitule;
	}


	@Override
	public int compareTo(TypeDossier o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
