/**
 * 
 */
package com.la.mitienda.pojos;

import java.util.Date;

/**
 * @author Leonardo Arevalo
 *
 */
public class Envasado extends Producto implements Comestible{


	private Date vencimiento;
	private Float calorias;
	private TipoEnvase envase;

	
	public Boolean getComestible() {
		return COMESTIBLE;
	}
	
	public TipoEnvase getEnvase() {
		return envase;
	}

	public void setEnvase(TipoEnvase envase) {
		this.envase = envase;
	}

	@Override
	public Date getVencimiento() {
		return vencimiento;
	}

	@Override
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	@Override
	public Float getCalorias() {
		return calorias;
	}

	@Override
	public void setCalorias(Float calorias) {
		this.calorias = calorias;
	}
	
	

	
	public void setDescuento(Float descuento) throws Exception {
		if(descuento > 0.2f) {
			throw new Exception("El descuento de los envasados no puede ser superior al 20 porciento.");
			
		}else {
			this.descuento = descuento;
		}
	}
	
}
