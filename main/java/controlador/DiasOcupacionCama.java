/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author dionisio.barrantes
 */
public class DiasOcupacionCama {
        private int diaId;
	private String MatriculaOcupante;

	public DiasOcupacionCama(int id, String desc){
		this.diaId = id;
		this.MatriculaOcupante = desc;
	}

	public int getDiasOcupacionCamadiaId() {
		return diaId;
	}
	public void setDiasOcupacionCamadiaId(int diaId) {
		this.diaId = diaId;
	}
	public String getDiasOcupacionCamaMatriculaOcupante() {
		return MatriculaOcupante;
	}
	public void setDiasOcupacionCamaMatriculaOcupante(String MatriculaOcupante) {
		this.MatriculaOcupante = MatriculaOcupante;
        }   
}
