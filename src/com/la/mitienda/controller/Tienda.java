/**
 * 
 */
package com.la.mitienda.controller;

import com.la.mitienda.pojos.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Leonardo Arevalo
 *
 */
public class Tienda {
	
	private Integer tiendaId;
	private String nombreTienda;
	private Integer productosMax;
	private Integer stockActual;
	private Float caja;
	private Float total;

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	private Map<ProductoId, Producto> productos = new HashMap<>();
	
//////////////////////////////////////////////////////////////////////////////////////

	public Tienda() { 
		this.productosMax = 10000;
		this.stockActual = 0;
		this.caja = 0f;
	
	}
	
	public Tienda(Integer tiendaId, String nombreTienda, Integer productosMax, Float caja) {
		this.tiendaId = tiendaId;
		this.nombreTienda = nombreTienda;
		this.productosMax = productosMax;
		this.stockActual = 0;
		this.caja = caja;
	}

	public Integer getTiendaId() {
		return this.tiendaId;
	}
	public void setTiendaId(Integer id) {
		this.tiendaId = id;
	}
	
	public String getNombreTienda() {
		return this.nombreTienda;
	}
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	public Integer getProductosMax() {
		return this.productosMax;
	}
	public void setProductosMax(Integer productosMax) {
		this.productosMax = productosMax;
	}
	public Integer getStockActual() {
		return this.stockActual;
	}
	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}
	public Float getCaja() {
		return this.caja;
	}
	public void setCaja(Float caja) {
		this.caja = caja;
	}

	public Map<ProductoId, Producto> getProductos() {
		return productos;
	}

	public void setProductos(Map<ProductoId, Producto> productos) {
		this.productos = productos;
	}

	///////////////////////////////////////////////////////////////////////////
	////////////////       AGREGAR PRODUCTO        ////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	public void agregarProducto(Producto producto, Integer cantidad) throws Exception {
		
		
		if( (this.caja - (producto.getCostoUnidad() * cantidad)) < 0 ) {//si el monto de la caja no es suficiente
			throw new Exception("\n\n El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja.");
		}else if(cantidad + this.stockActual > productosMax) {//si la cantidad de productos supera el maximo
			
			throw new Exception("\n\n El numero de productos no puede superar el stock máximo: Stock actual - "+ stockActual );
		}

		if (producto.getId().getTipoProducto() == TipoProducto.AB) {
			try {
				if(guardarCompra(producto, cantidad)) {
					System.out.println("Producto/s agregado/s correctamente");
				}else {
					System.out.println("Error al intetar almacenar la compra");//no se debería ejecutar
				}
			}catch(Exception e) {
				throw new Exception("Error: no se pudo almacenar el producto.");
			}
			
			
		}else if(producto.getId().getTipoProducto() == TipoProducto.AC) {
			
			try {
					
				if(guardarCompra(producto, cantidad)) {
					System.out.println("Producto/s agregado/s correctamente");
				}else {
					System.out.println("Error al intetar almacenar la compra");//no se debería ejecutar
				}
			}catch(Exception e) {
				throw new Exception("Error: no se pudo almacenar el producto.");
			}
			
			
			
			
		}else if(producto.getId().getTipoProducto() == TipoProducto.AZ) {
			
			try {
			
				if(guardarCompra(producto, cantidad)) {
					System.out.println("Producto/s agregado/s correctamente");
				}else {
					System.out.println("Error al intetar almacenar la compra");//no se debería ejecutar
				}
			}catch(Exception e) {
				throw new Exception("Error: no se pudo almacenar el producto.");
			}
			

		
			
		}else if(producto.getId().getTipoProducto() == TipoProducto.AA) {
			
			try {
			
				if(guardarCompra(producto, cantidad)) {
					System.out.println("Producto/s agregado/s correctamente");
				}else {
					System.out.println("Error al intetar almacenar la compra");//no se debería ejecutar
				}
			}catch(Exception e) {
				throw new Exception("Error: no se pudo almacenar el producto.");
			}
			
		}else {
			throw new Exception("Error: No es posible identificar a que tipo de producto pertenece");
		}
			
	}//fin de agregarProducto
	
	////////////////    GUARDAR COMPRA        ////////////////////////////
	
	public Boolean guardarCompra(Producto producto, Integer cantidad) throws Exception {
		
		Boolean seGuardo = false;
		try {
			//todos los productos estarán disponibles
			producto.setDisponible(true);
			//actualizamos el valor de la caja
			this.caja = this.caja - (producto.getCostoUnidad() * cantidad);
			//agregamos el numero de productos agregados al stockActual
			this.productosMax = this.stockActual + cantidad; 
			//finalmente agregamos el producto	
			productos.put(producto.getId(), producto);
			seGuardo = true;
		}catch(Exception e) {
				throw new Exception("Error: no se pudo almacenar el producto.");
			}
		return seGuardo;
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////
	////////////////          VENDER               ////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * 
	 * Detalle contiene el producto que se venderá y su correspondiente cantidad
	 * @param detalles
	 * @return
	 * @throws Exception
	 */
	public List<String> ventaProductos(List<Detalle> detalles) throws Exception {
		
		Float promedio = 0f;
		int nroArticulos = 0;
		List<String> respuesta = new ArrayList<String>();
		String str = "";
		Float cajaProvisoria = 0f;
		total = 0f;
		
		try {

			if (detalles.size() > 3) {
				throw new Exception(
						"\n \n En esta version solo es posible vender 3 tipos de productos diferentes como máximo.");
			}
			for (Detalle detalle : detalles) {
				
				cajaProvisoria = 0f;
				
				if (detalle.getCantidad() > 10) {//si sobrepasa el limite
					throw new Exception(
							"\n \n No es posible continuar con la operación. Sobrepasa el numero permitido por articulo");
					
				} else {// comprobar unidades en stock del producto sea suficiente para la venta

					// con el producto.id nos fijamos en el map si esta disponible
					Producto producto = detalle.getProducto();
					if (productos.containsKey(producto.getId())) {

						Producto productoMap = productos.get(producto.getId());
						// si el producto está disponible
						if (productoMap.getDisponible()) {// si el producto esta disponible
	
								if (productoMap.getStock() < detalle.getCantidad()) {// si stock es menor que el pedido
										// asignar el mensaje de producto agotado
										respuesta.add(new String("Hay productos con stock disponibles menor al solicitado"));
		
										if (productoMap.getDescuento() > 0f) {// si tiene oferta y stock es menor que el pedido
		
											cajaProvisoria = productoMap.getPrecioConDescuento() * productoMap.getStock();
		
											respuesta.add(new String("\n\n" + productoMap.getId() + " "
													+ productoMap.getDescripcion() + " " + productoMap.getStock() + " x $"
													+ productoMap.getPrecioConDescuento()));
		
										} else {// si no tiene oferta pero stock es menor que el pedido
		
											cajaProvisoria = productoMap.getPrecioUnidad() * productoMap.getStock();
		
											respuesta.add(new String("\n\n" + productoMap.getId() + " "
													+ productoMap.getDescripcion() + " " + productoMap.getStock()
													+ " x $" + productoMap.getPrecioUnidad()));
											
										}
		
										// setear stock a cero y disponible false
										productoMap.setStock(0);
										productoMap.setDisponible(false);
	
								} else {// si la cantidad del producto no es menor que la pedida
	
										if (productoMap.getDescuento() > 0f) {// si tiene oferta
		
											// asignar precioUnidad con descuento por productoMap.getStock()
											cajaProvisoria = productoMap.getPrecioConDescuento() * detalle.getCantidad();
		
											respuesta.add(new String("\n\n" + productoMap.getId() + " "
														+ productoMap.getDescripcion() + " " + detalle.getCantidad() + " x $"
														+ productoMap.getPrecioConDescuento()));
		
										} else {// si no tiene oferta
		
											cajaProvisoria = productoMap.getPrecioUnidad() * detalle.getCantidad();
		
											respuesta.add(new String("\n\n" + productoMap.getId() + " "
													+ productoMap.getDescripcion() + " " + detalle.getCantidad()
													+ " x $" + productoMap.getPrecioUnidad()));
										}
										// restamos stock por el dato de pedido
										productoMap.setStock(productoMap.getStock() - detalle.getCantidad());
		
										// Si el stock era justo lo que pedia el detalle
										if (productoMap.getStock() == 0) {
											productoMap.setDisponible(false);
										}
		
								}
								
						} else {// si el producto no se encuentra disponible
							respuesta.add("\n \n El producto " + producto.getId() + " " + producto.getDescripcion()
									+ " no se encuentra disponible");
						}

					} else {
						// si el producto no está en el map no es que no esta disponible... No existe
						str = "\n \n El producto " + producto.getId() + " " + producto.getDescripcion() + " no existe";

					}


				}
				
				// CAJAPROVISORIA SUMAR A CAJA
				total = total + cajaProvisoria;
				
			} // DEL FOR
			
			
			// registramos el monto total en la caja
			caja = caja + total;

			respuesta.add("\n\n\n----------------------------------------------------");
			respuesta.add("\n    TOTAL VENTA:                                 $ " + total);

		} catch (Exception e) {
			throw new Exception(" No fue posible registrar la venta ");
		}
		
		return respuesta;
	}//ventaProductos
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	/////////////////  OBTENER COMESTIBLES CON MENOR DESCUENTO   //////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////

		
	

		public List<String> obtenerComestiblesConMenorDescuento(Float porcentaje_descuento){

			List<String> respuesta = new ArrayList<String>();
			for (Map.Entry<ProductoId, Producto> producto : productos.entrySet()) {
				

				Producto noImportado = producto.getValue();
				
				if((noImportado instanceof Bebida) || (noImportado instanceof Envasado)) {
					
					if( !noImportado.getImportado() && (noImportado.getDescuento() < porcentaje_descuento)) {
						
						String str = noImportado.getDescripcion();
						respuesta.add(str.toUpperCase());
						
					}
					
				}
								
	         
	
	        }//del for
			Collections.sort(respuesta);
			
			return respuesta;
		}
///////////////////////////////////////////////////////////////////////////////////////////
//////////////     LISTAR PRODUCTOS CON UTILIDADES INFERIORES    //////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
		
		public List<String> listarProductosConUtilidadesInferiores(Float porcentaje_utilidad){

			List<String> respuesta = new ArrayList<String>();
			for (Map.Entry<ProductoId, Producto> producto : productos.entrySet()) {
				String str = new String();
				if(producto.getValue().getPorcentajeGananciaInferior(porcentaje_utilidad)) {
					 str = producto.getValue().getId()+" "+producto.getValue().getDescripcion()+" "+producto.getValue().getStock();
				}
				respuesta.add(str);
			}
			return respuesta;
	
		}
		
	
}
