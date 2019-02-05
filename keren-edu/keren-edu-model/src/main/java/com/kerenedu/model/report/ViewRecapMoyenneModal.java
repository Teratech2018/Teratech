package com.kerenedu.model.report;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseSecondaire;
import com.kerenedu.configuration.Cycle;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ViewRecapMoyenneModal extends BaseElement implements Serializable, Comparable<ViewRecapMoyenneModal> {
	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	//@Predicate(label = "Cycle", type = Cycle.class, target = "many-to-one", optional = true, sequence = 1)
	private Cycle cycle;
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Classe", type = ClasseSecondaire.class, target = "many-to-one", search = true, sequence = 2, observable = true)
	protected ClasseSecondaire classe;

	public ViewRecapMoyenneModal() {
	}

	public ViewRecapMoyenneModal(Cycle cycle, ClasseSecondaire classe) {
		this.cycle = cycle;
		this.classe = classe;
	}

	public ViewRecapMoyenneModal(ViewRecapMoyenneModal ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);

		if (ins.classe != null) {
			this.classe = new ClasseSecondaire(ins.classe);
		}

		if (ins.getCycle() != null) {
			this.cycle = new Cycle(ins.cycle);
		}
	}

	public ClasseSecondaire getClasse() {
		return classe;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public void setClasse(ClasseSecondaire classe) {
		this.classe = classe;
	}

	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(Long.valueOf(id));
		return hash;
	}

	public int compareTo(ViewRecapMoyenneModal o) {
		return 0;
	}

	public String getEditTitle() {
		return "Critère de recherche  ";
	}

	public String getListTitle() {
		return "Critère de recherche   ";
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public String getDesignation() {
		return "";
	}
}
