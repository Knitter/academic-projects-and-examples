/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.ipleiria.estg.ia.sudokusolver.solver;

/**
 *
 * @author Knitter
 */
public interface AlgoritmoGeneticoListener {

    /**
     * 
     * @param g
     */
    void runFinished(AlgoritmoGenetico g);
    
    /**
     * 
     * @param gen
     */
    void currentGeneration(int gen);

}
