/**
 * 
 */
package com.la.mitienda.pojos;

/**
 * @author Leonardo Arevalo
 *
 */
public class Limpieza extends Producto {

	
	TipoDeUso aplicacion;
	
	
////////////////////////////////////////////////////
	
	
	public TipoDeUso getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(TipoDeUso aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	public void setPrecioUnidad(Float precioUnidad) throws Exception{
		
		if((this.id.getTipoProducto() == TipoProducto.AZ) && (aplicacion == TipoDeUso.ROPA || aplicacion == TipoDeUso.MULTIUSO)){
		
			if( precioUnidad > (costoUnidad + (costoUnidad * 0.25))){
				throw new Exception("La ganancia de los prod. limpieza de ropa o multiuso debe ser menor al 25 porciento.");
			}else {
				this.precioUnidad = precioUnidad;
			}
			
		}else if((this.id.getTipoProducto() == TipoProducto.AZ) 
				
			&& ( (  (costoUnidad + (costoUnidad * 0.1) ) > precioUnidad) 
						
			|| (precioUnidad > (costoUnidad + (costoUnidad * 0.25) )))  ) {
			
				throw new Exception("La ganancia de los prod. limpieza debe estar entre 10 y 25 porciento.");	
			}else {
				this.precioUnidad = precioUnidad;
			}
			
			
	}
	public void setDescuento(Float descuento) throws Exception {
		if(descuento > 0.25f) {
			throw new Exception("El descuento de los productos de limpieza no puede ser superior al 25 porciento.");
		}else {
			this.descuento = descuento;
		}
	}
	
		

	
	
	

}
