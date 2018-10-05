
package com.keren.courrier.core.impl.archivage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.archivage.LiasseDocumentTriManagerLocal;
import com.keren.courrier.core.ifaces.archivage.LiasseDocumentTriManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.LiasseDocumentTriDAOLocal;
import com.keren.courrier.model.archivage.LiasseDocumentTri;
import com.keren.courrier.model.courrier.CourrierTrier;
import com.keren.courrier.model.courrier.FichierLieTri;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "LiasseDocumentTriManager")
public class LiasseDocumentTriManagerImpl
    extends AbstractGenericManager<LiasseDocumentTri, Long>
    implements LiasseDocumentTriManagerLocal, LiasseDocumentTriManagerRemote
{

    @EJB(name = "LiasseDocumentTriDAO")
    protected LiasseDocumentTriDAOLocal dao;

    public LiasseDocumentTriManagerImpl() {
    }

    @Override
    public GenericDAO<LiasseDocumentTri, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
	public List<LiasseDocumentTri> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		List<LiasseDocumentTri> datas = super.filter(predicats, orders, properties, firstResult, maxResult); // To
		List<LiasseDocumentTri> results = new ArrayList<LiasseDocumentTri>();
		for (LiasseDocumentTri LiasseDocument : datas) {
			LiasseDocumentTri data = new LiasseDocumentTri(LiasseDocument);
			results.add(data);
		} // end for(LiasseDocument LiasseDocument:datas){
		return results;
	}

	@Override
	public List<LiasseDocumentTri> findAll() {

		// To change body of generated methods, choose Tools | Templates.
		List<LiasseDocumentTri> datas = super.findAll();
		List<LiasseDocumentTri> results = new ArrayList<LiasseDocumentTri>();
		for (LiasseDocumentTri data : datas) {
			LiasseDocumentTri c = new LiasseDocumentTri(data);
			results.add(c);
		}

		return results;
	}

	@Override
	public LiasseDocumentTri find(String propertyName, Long entityID) {
		// initialisaiton
		LiasseDocumentTri data = super.find(propertyName, entityID); // To change body of
															// generated
															// methods, choose
															// Tools |
															// Templates.
		LiasseDocumentTri result = new LiasseDocumentTri(data);
		for (FichierLieTri aas : data.getPiecesjointes()) {
			result.getPiecesjointes().add(new FichierLieTri(aas));
		}
		
		for (CourrierTrier aas : data.getCourriers()) {
			result.getCourriers().add(new CourrierTrier(aas));
		}

		return result;
	}


	@Override
	public LiasseDocumentTri delete(Long id) {
		// befor delete ligne bordero
		// delete ligne piece jointe
//		LiasseDocument entity = dao.findByPrimaryKey("id", id);
//		daoclone.deleteLiasseDocumentRAD(new LiasseDocumentClone(entity));
//		entity = new LiasseDocument();
//		System.out.println("LiasseDocumentDepartManagerImpl.delete() delet ok ...");
		return new LiasseDocumentTri(null);
	}

}
