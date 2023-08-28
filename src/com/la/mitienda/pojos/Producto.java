/**
 * 
 */
package com.la.mitienda.pojos;

import java.util.Optional;

/**
 * @author Leonardo Arevalo
 *
 */
public class Producto implements Descuento {

	
	protected ProductoId id;
	
	protected String productoName;
	protected String descripcion;
	protected String proveedor;
	protected String marca;
	protected Integer stock;
	protected Float precioUnidad;//para la venta al publico
	protected Float costoUnidad;//valor al que se compro
	protected Float descuento;
	protected Boolean importado;
	protected Boolean disponible;//si esta disponible a la venta
	
///////////////////////////////////////////////////////////////////////7	
	public Producto() {
		
	}

	public Producto(ProductoId id, String productoName, String descripcion, 
					String proveedor, String marca,Integer stock,
					Float precioUnidad, Float costoUnidad, Boolean disponible, 
					Boolean importado, Float descuento) {
		super();
		this.id = id;
		this.productoName = productoName;
		this.descripcion = descripcion;
		this.proveedor = proveedor;
		this.marca = marca;
		this.stock = stock;
		this.costoUnidad = costoUnidad;
		this.precioUnidad = precioUnidad;
		this.disponible = disponible;
		this.importado = importado;
		this.descuento = descuento;
		
		aplicarImpuesto();
	}

	public void aplicarImpuesto() {
		if(this.importado) {
			this.precioUnidad = this.precioUnidad + (this.precioUnidad * 0.1f);
		}
	}

	@Override
	public Float getDescuento() {
		return this.descuento;
	}

	@Override
	public void setDescuento(Float descuento) throws Exception {
		Float desc = this.precioUnidad * descuento;
		if(desc < this.costoUnidad) {
			throw new Exception("El descuento registrado para le producto "+ this.id +"no pudo ser aplicado");
		}
		this.descuento = descuento;
		
	}

	@Override
	public Float getPrecioConDescuento() {
		Float descontado = descuento * precioUnidad;
		descontado = precioUnidad - descuento;
		return descontado;
	}

	public ProductoId getId() {
		return id;
	}

	public void setId(ProductoId id) {
		this.id = id;
	}

	public String getProductoName() {
		return productoName;
	}

	public void setProductoName(String productoName) {
		this.productoName = productoName;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Float getPrecioUnidad() {
		return precioUnidad;
	}

	
	public void setPrecioUnidad(Float precioUnidad) throws Exception{
	
				this.precioUnidad = precioUnidad;
		
	}
	public Boolean getPorcentajeGananciaInferior(Float piso) {
		Float porcentaje = ((this.precioUnidad - this.costoUnidad)*100) / this.costoUnidad;
		return ( porcentaje < piso);
	}

	public Float getCostoUnidad() {
		return costoUnidad;
	}

	public void setCostoUnidad(Float costoUnidad) {
		this.costoUnidad = costoUnidad;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	
	public Boolean getImportado() {
		return this.importado;
	}
	public void setImportado(Boolean importado) {
		//PARA LOS PRODUCTOS IMPORTADOS SE APLICARÁ UN IMPUESTO DEL 10% SOBRE EL PRECIO DE VENTA
		if(importado) {
			this.precioUnidad = (float) (this.precioUnidad + (this.precioUnidad * 0.1));
		}else {
			this.importado = importado;
		}
		
	}
	
	
	
	
}
