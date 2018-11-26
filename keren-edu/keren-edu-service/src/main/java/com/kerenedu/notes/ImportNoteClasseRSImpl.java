package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.ImportData;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.mgt.commons.tools.CommonTools;
import com.megatimgroup.mgt.commons.tools.FileHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;












@Path("/importnoteclasse")
public class ImportNoteClasseRSImpl
  extends AbstractGenericService<ImportNoteClasse, Long>
  implements ImportNoteClasseRS
{
//  @Manager(application="kereneducation", name="ImportNoteManagerImpl", interf=ImportNoteManagerRemote.class)
//  protected ImportNoteManagerRemote manager;
  @Manager(application="kereneducation", name="NoteDetailManagerImpl", interf=NoteDetailManagerRemote.class)
  protected NoteDetailManagerRemote managernote;
  @Manager(application="kereneducation", name="MatiereNoteManagerImpl", interf=MatiereNoteManagerRemote.class)
  protected MatiereNoteManagerRemote managermat;
  @Manager(application="kereneducation", name="CoefMatiereManagerImpl", interf=CoefMatiereManagerRemote.class)
  protected CoefMatiereManagerRemote managercoef;
  
  public ImportNoteClasseRSImpl() {}
  
  public MetaData getMetaData(HttpHeaders headers)
  {
    try
    {
      return MetaDataUtil.getMetaData(new ImportNoteClasse(), new HashMap<String, MetaData>(), new ArrayList<String>());
    }
    catch (Exception e) {
      throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
    }
  }
  





  public GenericManager<ImportNoteClasse, Long> getManager()
  {
    return null;
  }
  
  public String getModuleName() {
    return "kereneducation";
  }
  

  public ImportNoteClasse save(HttpHeaders headers, ImportNoteClasse entity)
  {
    ImportData datas = new ImportData();
    Gson gson = new Gson();
    long id = ((Long)gson.fromJson((String)headers.getRequestHeader("userid").get(0), Long.class)).longValue();
    CacheMemory.insert(id, TypeCacheMemory.CLASSE, entity.getClasse());
    CacheMemory.insert(id, TypeCacheMemory.EXAMEN, entity.getExamen());
    
    for (ImportNoteClasseFile file : entity.getFileMatiere()) {
      if ((file.getFilename() != null) || (!file.getFilename().isEmpty())) {
        datas.setFichier(file.getFilename());
        datas.setSeparator(";");
        datas.setFormat("cvs");
        datas.setClassName(NoteDetail.class.getName());
        getNoteStudent(datas, entity, file);
      }
    }
    
    return entity;
  }
  
  private List<NoteDetail> getNoteStudent(ImportData entity, ImportNoteClasse critere, ImportNoteClasseFile noteFile) {
    List<NoteDetail> notes = new ArrayList();
    RestrictionsContainer container = RestrictionsContainer.newInstance();
    String filename = getTemporalDirectory() + File.separator + entity.getFichier();
    File file = new File(filename);
    NoteDetail value = new NoteDetail();
    boolean exists = file.exists();
    try {
      if (exists) {
        Class<?> data = Class.forName(entity.getClassName());
        Map<Long, List<String>> datas = new HashMap();
        if (entity.getFormat().equalsIgnoreCase("cvs")) {
          datas = FileHelper.cvsToJavaConverter(filename, entity.getSeparator());
        } else {
          datas = FileHelper.excelToJavaConverter(filename, entity.getFields().size());
        }
        System.out.println("ImportNoteRSImpl.getNoteStudent() datas" + datas.toString());
        if (datas != null) {
          List entities = mapToJavaObjectNote(NoteDetail.class.getName(), datas);
          List<NoteDetail> dats = new ArrayList();
          if ((entities != null) && (!entities.isEmpty())) {
            container.addEq("examen.id", Long.valueOf(critere.getExamen().getId()));
            container.addEq("classe.id", Long.valueOf(critere.getClasse().getId()));
            container.addEq("matiere.id", Long.valueOf(noteFile.getMatiere().getId()));
            List<MatiereNote> results = managermat.filter(container.getPredicats(), null, new HashSet(), 0, -1);
            System.out.println("ImportNoteClasseRSImpl.getNoteStudent() import data " + results.size());
            if ((results != null) || (!results.isEmpty())) {
              MatiereNote mat = (MatiereNote)results.get(0);
              mat.setNotelisttr(entities);
              managermat.importNote(mat);
            } else {
              throw new KerenExecption("Matiere inexistante !!!");
            }
          }
        }
      }
      else
      {
        throw new KerenExecption("Fichier non renseigner !!!!");
      }
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (InvalidFormatException e) {
      e.printStackTrace();
    }
    catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    catch (InstantiationException e) {
      e.printStackTrace();
    }
    return notes;
  }
  
  protected List<NoteDetail> mapToJavaObjectNote(String classname, Map<Long, List<String>> data) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException {
    List result = new ArrayList();
    List<String> fieldNames = (List)data.get(Long.valueOf(0L));
    for (Iterator i$ = data.keySet().iterator(); i$.hasNext();) { long key = ((Long)i$.next()).longValue();
      if (key > 0L)
      {
        NoteDetail entityClass = (NoteDetail)NoteDetail.class.newInstance();
        
        Field[] fields = entityClass.getClass().getDeclaredFields();
        Map<String, Field> map = new HashMap();
        for (Field field : fields) {
          map.put(field.getName(), field);
        }
        List<String> values = (List)data.get(Long.valueOf(key));
        int index = 0;
        for (String fieldname : fieldNames) {
          fieldname = CommonTools.cvsString(fieldname);
          String[] names6 = fieldname.split("_");
          

          if (names6.length <= 1) {
            Field field = (Field)map.get(fieldname);
            

            if (field != null) {
              affectValue(entityClass, field, (String)values.get(index));
            }
          } else {
            Field field = (Field)map.get(names6[0]);
            if (field != null)
            {
              Object value = CommonTools.getEntity(getManager().getDao().getEntityManager(), names6[0], names6[1], (String)values.get(index), field);
              field.setAccessible(true);
              field.set(entityClass, value);
            }
          }
          index++;
        }
        result.add(entityClass);
      }
    }
    return result;
  }
  
  protected void affectValue(NoteDetail object, Field field, String value) throws IllegalArgumentException, IllegalAccessException { field.setAccessible(true);
    
    if (field.getType().equals(Boolean.class)) {
      field.setBoolean(object, true);
    } else if (field.getType().equals(String.class)) {
      field.set(object, value);
    } else if (field.getType().equals(Integer.class)) {
      field.setInt(object, Integer.valueOf(value).intValue());
    } else if (field.getType().equals(Short.class)) {
      field.setShort(object, Short.valueOf(value).shortValue());
    } else if (field.getType().equals(Float.class)) {
      field.setFloat(object, Float.valueOf(value).floatValue());
    } else if (field.getType().equals(Double.class)) {
      field.set(object, Double.valueOf(value));
    } else if (field.getType().equals(Long.class)) {
      field.setLong(object, Long.valueOf(value).longValue());
    } else if (field.getType().equals(BigDecimal.class)) {
      field.set(object, new BigDecimal(value));
    }
  }
  

  public List<ImportNoteClasseFile> findmatierclasse(HttpHeaders headers)
  {
    Gson gson = new Gson();
    long id = ((Long)gson.fromJson((String)headers.getRequestHeader("id").get(0), Long.class)).longValue();
    List<ImportNoteClasseFile> datas = managercoef.findMatiere(Long.valueOf(id));
    if ((datas == null) || (datas.isEmpty())) {
      throw new KerenExecption("Aucune Matiere pour cette classe");
    }
    return datas;
  }
}