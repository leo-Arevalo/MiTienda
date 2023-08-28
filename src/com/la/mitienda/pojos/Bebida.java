/**
 * 
 */
package com.la.mitienda.pojos;

import java.util.Date;

/**
 * @author Leonardo Arevalo
 *
 */
public class Bebida extends Producto implements Comestible{
	
	private Boolean poseeAlcohol;
	private Float porcentajeAlcohol;
	private Float calorias;
	private Date vencimiento;
	
	


	public Bebida() {
		super();
		
	}
	public Bebida(ProductoId id, String productoName, String descripcion, 
					String proveedor, String marca, Integer stock,
					Float precioUnidad, Float costoUnidad, Boolean disponible, 
					Boolean importado, Float descuento) {
		super(id, productoName, descripcion, proveedor, marca, stock, precioUnidad, costoUnidad, disponible, importado,descuento);
		
	}
	
	public Boolean getComestible() {
		return COMESTIBLE;
	}
	
	
	
	public Boolean getPoseeAlcohol() {
		return poseeAlcohol;
	}
	public void setPoseeAlcohol(Boolean poseeAlcohol) {
		this.poseeAlcohol = poseeAlcohol;
	}
	public Float getPorcentajeAlcohol() {
		return porcentajeAlcohol;
	}
	public void setPorcentajeAlcohol(Float porcentajeAlcohol) {
		this.porcentajeAlcohol = porcentajeAlcohol;
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
		return this.calorias;
	}
	@Override
	public void setCalorias(Float calorias) {
		this.calorias = calorias;
	}
	
	
	public void setPrecioUnidad(Float precioUnidad) throws Exception{
			
		if(COMESTIBLE) {
			if( (costoUnidad > precioUnidad) || (precioUnidad > (costoUnidad + (costoUnidad * 0.2) ) ) ) {
				
				throw new Exception("La ganancia de los productos comestibles no puede ser superior al 20 porciento.");
				
			}else { 
				this.precioUnidad = precioUnidad;
			}
		}	
	}

	public void setDescuento(Float descuento) throws Exception {
		if(descuento > 0.15f) {
			throw new Exception("El descuento de las bebidas no puede ser superior al 15 porciento.");
			
		}else {
			this.descuento = descuento;
		}
	}
	
	
	

	
}//bebidas
