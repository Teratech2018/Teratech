package com.kerenedu.model.report;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public class ViewMatiereClasseModal extends BaseElement implements Serializable, Comparable<ViewMatiereClasseModal> {

	
	@ManyToOne
	@JoinColumn(name = "SECTION_ID")
	@Predicate(label = "Section", type = SectionE.class, target = "many-to-one", optional = false, sequence = 1)
	private SectionE section;
	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Classe", type = Classe.class, target = "many-to-one", search = true, sequence = 2)
	@Filter("[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe;

	public ViewMatiereClasseModal() {
	}

	public ViewMatiereClasseModal(SectionE section, Classe classe) {
		this.section = section;
		this.classe = classe;
	}

	public ViewMatiereClasseModal(ViewMatiereClasseModal ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);

		if (ins.classe != null) {
			this.classe = new Classe(ins.classe);
		}

		if (ins.getSection() != null) {
			this.section = ins.section;
		}
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(Long.valueOf(id));
		return hash;
	}

	public int compareTo(ViewMatiereClasseModal o) {
		return 0;
	}

	public String getEditTitle() {
		return "Sélectionnez la Classe ";
	}

	public String getListTitle() {
		return "Sélectionnez la Classe ";
	}

	public SectionE getSection() {
		return section;
	}

	public void setSection(SectionE section) {
		this.section = section;
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public String getDesignation() {
		return "";
	}
}
