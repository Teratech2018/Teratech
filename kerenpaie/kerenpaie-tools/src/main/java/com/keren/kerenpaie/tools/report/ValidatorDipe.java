/**
 * 
 */
package com.keren.kerenpaie.tools.report;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
public class ValidatorDipe<T extends Object> {


	public  T validate(T _cible,char begin) {

		try {
			Field[] cibleFields = getObjectDeclaredFields(_cible.getClass());// _cible.getClass().getDeclaredFields();//
			// Declaration du dico des champs cible
			Map<String, Field> cibleFieldsMap = new HashMap<String, Field>();
			for (Field _field : cibleFields) {
				cibleFieldsMap.put(_field.getName(), _field);
			}

			for (Field field : cibleFields) {
				if (field.isAnnotationPresent(Predicate.class)) {
					Predicate annot = field.getAnnotation(Predicate.class);
					String fieldName = field.getName();
					System.out.println("ValidatorDipe.validator() ===== fieldName is " + fieldName);
					int value = 0;

					if (annot.length() != 0) {
						value = annot.length();
						System.out.println("ValidatorDipe.validator() value de la notation " + value);
					}
					// champ a completer si length pas equal
					Field _newField = cibleFieldsMap.get(fieldName);
					// obtenir la value saisir
					_newField.setAccessible(true);
					String lengtvalue = null;
					System.out.println("ValidatorDipe.validator() valeu a comparer===yyy " + _newField);
					if(_newField!=null){
					lengtvalue = _newField.get(_cible).toString();
					}

					System.out.println("ValidatorDipe.validator() valeu a comparer===X " + lengtvalue);
					// comparaison
					if (lengtvalue!=null||lengtvalue.length() < value) {
						// obtenir la difference
						int diff = value - lengtvalue.length();
						System.out.println("ValidatorDipe.validator() diff=====" + diff);
						StringBuilder builder = new StringBuilder();
						for (int i = 0; i < diff; i++) {
							builder.append(begin);

						}
						System.out.println("ValidatorDipe.validator() vide =====" + builder);

						StringBuilder chainefinal = builder.append(lengtvalue);
						System.out.println("ValidatorDipe.validator() chaine result =====" + chainefinal);

						_newField.set(_cible, chainefinal.toString());
						
						String v = _newField.get(_cible).toString();
						System.out.println("ValidatorDipe.validator() valeu a final ===X " + v);
					}

				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _cible;
	}
	

	public  List<T> validator(List<T> list,char begin) throws IllegalAccessException {
		System.out.println("ValidatorDipe.validator() taile Debut " + list.size());
		List<T> listItem = new ArrayList<T>();

		for (T item : list) {
			T itemnew = validate(item, begin);
			listItem.add(itemnew);
		}
		System.out.println("ValidatorDipe.validator() taile fin " + listItem.size());
		return listItem;
	}


	/**
	 *
	 * @param _source
	 * @return
	 */
	public static Field[] getObjectDeclaredFields(Class _source) {

		List<Field> _fields = new ArrayList<Field>();

		Field[] fields = null;

		Class superclass = _source.getSuperclass();

		if (superclass != null && !superclass.equals(JComponent.class)) {

			fields = getObjectDeclaredFields(superclass);

			for (Field _field : fields) {
				if (_field != null) {
					_fields.add(_field);
				}
			}
		}
		fields = _source.getDeclaredFields();

		for (Field _field : fields) {
			if (_field != null) {
				_fields.add(_field);
			}
		}

		// System.out.println("Liste des champs is
		// ::::::::::::::::::::::::::::::::::: "+_fields);
		Field[] _filedss = new Field[_fields.size()];

		int index = 0;
		for (Field _field : _fields) {
			_filedss[index] = _field;

			index++;
		}

		return _filedss;
	}

}
