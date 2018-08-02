package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.List;

import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.kerenedu.configuration.CacheMemory;

public class CriteriaFactory {
	
	public static List<Predicat> defaultPredicats(){
		List<Predicat> predicats = new ArrayList<Predicat>();
	RestrictionsContainer container = RestrictionsContainer.newInstance();
	
	String anneScolaire = CacheMemory.getCurrentannee();
	if (anneScolaire != null) {
		container.addEq("anneScolaire", anneScolaire);
	}
	predicats.addAll(container.getPredicats());
	return predicats ;
	}

}
