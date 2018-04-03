/**
 * 
 */
package com.keren.kerenpaie.tools.calcul;

/**
 * @author BEKO
 *
 */
public interface ExprExecutor {

	
	
	public Double exprEvaluation(String expression);
	
	public Boolean validate(String expression);
	
	public ExprExecutor nextStep();
}
