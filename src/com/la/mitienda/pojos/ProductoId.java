
/**
 * 
 */
package com.la.mitienda.pojos;

import java.util.Objects;
import java.lang.Integer;



/**
 * @author Leonardo Arevalo
 *
 */
public class ProductoId {

	private TipoProducto tipoProducto;
	private Integer numero;
	
	//para poder ampliar el rango de ser necesario
	public static Integer rangoMax; 
	
	
	/////////////////////////////////////////////////////
	
	public ProductoId() {
		
	}
	
	public ProductoId(TipoProducto tipoProducto, Integer id) throws Exception{
		
		if(!checkId(id)) {
			throw new Exception("Error: Id del producto fuera del rango establecido.");
		}else {
			this.numero = id;
			this.tipoProducto = tipoProducto;
		}
	
	}
	
	public static Integer getRangoMax() {
		return rangoMax;
	}
	public static void setRangoMax(Integer max) {
		rangoMax = max;
	}
	
	public TipoProducto getTipoProducto() {
		return this.tipoProducto;
	}
	public void setTipoProducto (TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public Integer getNumero() {
		return this.numero;
	}
	public void setNumero(Integer numero) throws Exception{
		
		if(!checkId(numero)) {
			throw new Exception("Error: Id del producto fuera del rango establecido.");
		}else {
			this.numero = numero;
		
		}
		
	}
	
	/**
	 * Evalua si la parte numerica de la clave compuesta está entre 0 y el rangoMax
	 */
	public Boolean checkId (Integer id) {
		//probar que pasa con this.numero < 0 || this.numero <999 para no usar parametros
		if(id < 0 || id > rangoMax) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String str = this.rangoMax.toString();
		int largo = str.length();
		str = String.format("%0"+largo+"d", numero);
		return tipoProducto.name() + str;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(numero, tipoProducto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoId other = (ProductoId) obj;
		return Objects.equals(numero, other.numero) && tipoProducto == other.tipoProducto;
	}


	
}
