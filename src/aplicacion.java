
import java.util.Date;

import com.la.mitienda.*;
import com.la.mitienda.pojos.*;



public class aplicacion {

	public static void main(String[] args) throws Exception {

		
///////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////     PRODUCTO ID   ///////////////////////////////////			
///////////////////////////////////////////////////////////////////////////////////	
	/*		
		System.out.println("\n\n Primer intento: ");
		try {
		ProductoId.setRangoMax(999);
		ProductoId id1 = new ProductoId();
		id1.setTipoProducto(TipoProducto.AB);
		id1.setNumero(342);
		System.out.println(id1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		System.out.println("\n\n Segundo intento: Se intenta sobrepasar el valor numerico del rango establecido ");
		
		try {
			ProductoId.setRangoMax(999);
			ProductoId id2 = new ProductoId();
			id2.setTipoProducto(TipoProducto.AB);
			id2.setNumero(3420);
			System.out.println(id2);
		}catch(Exception e) {
				System.out.println(e.getMessage());
		}

		System.out.println("\n\n TercerIntento intento: ");
		
		try {
			ProductoId.setRangoMax(999);
			ProductoId id2 = new ProductoId();
			id2.setTipoProducto(TipoProducto.AZ);
			id2.setNumero(002);
			System.out.println(id2);
		}catch(Exception e) {
				System.out.println(e.getMessage());
		}

*/		
///////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////     FIN - PRODUCTO ID   /////////////////////////////			
///////////////////////////////////////////////////////////////////////////////////			
		
		
		
///////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////     PRODUCTO      ///////////////////////////////////			
///////////////////////////////////////////////////////////////////////////////////			
		
		
		//CREAMOS LOS ID DE 4 PRODUCTOS
		
		ProductoId.setRangoMax(999);
		ProductoId id = new ProductoId();
		id.setTipoProducto(TipoProducto.AB);
		id.setNumero(123);
		
		ProductoId id1 = new ProductoId();
		id1.setTipoProducto(TipoProducto.AC);
		id1.setNumero(234);
		
		
		ProductoId id2 = new ProductoId();
		id1.setTipoProducto(TipoProducto.AZ);
		id1.setNumero(444);
		
		ProductoId id3 = new ProductoId();
		id1.setTipoProducto(TipoProducto.AA);
		id1.setNumero(100);
		
		//PRODUCTO
		
		Producto producto = new Producto();
		producto.setId(id3);
		producto.setProductoName("pilas AAA");
		producto.setDescripcion("Pilas");
		producto.setProveedor("Todo pilas");
		producto.setMarca("Electrocucion");
		producto.setStock(4);
		producto.setPrecioUnidad(2000f);
		producto.setCostoUnidad(1500f);
		producto.setDescuento(0.1f);
		producto.setImportado(false);
		producto.setDisponible(false);
		
		//ENVASADO
		
		Envasado envasado = (Envasado) new Producto();
		envasado.setId(id);
		envasado.setProductoName("Porotos");
		envasado.setDescripcion("Porotos enlatados");
		envasado.setProveedor("Juan Pablo el vecino");
		envasado.setMarca("Pura Fibra");
		envasado.setStock(7);
		envasado.setPrecioUnidad(100f);
		envasado.setCostoUnidad(75.5f);
		envasado.setDescuento(0.15f);
		envasado.setImportado(true);
		envasado.setDisponible(true);
		envasado.setVencimiento(new Date(27/05/2034));
		envasado.setCalorias(40f);
		envasado.setEnvase(TipoEnvase.LATA);
		
		
		
		
		//BEBIDA
		
		Bebida bebida =  new Bebida();
		bebida.setId(id);
		bebida.setProductoName("CocaCola");
		bebida.setDescripcion("Cocacola");
		bebida.setProveedor("Pepsico");
		bebida.setMarca("Cocacola");
		bebida.setStock(36);
		bebida.setPrecioUnidad(500f);
		bebida.setCostoUnidad(350.34f);
		bebida.setDescuento(0f);
		bebida.setImportado(false);
		bebida.setDisponible(false);
		bebida.setPoseeAlcohol(false);
		bebida.setPorcentajeAlcohol(0f);
		bebida.setCalorias(23.3f);
		bebida.setVencimiento(new Date(22/04/2025));
		
		
		
		//LIMPIEZA
		
		Limpieza limpieza = new Limpieza();
		limpieza.setId(id2);
		limpieza.setProductoName("Lavandina");
		limpieza.setDescripcion("Lavandina");
		limpieza.setProveedor("TusQUimicos");
		limpieza.setMarca("Ayudin");
		limpieza.setStock(10);
		limpieza.setPrecioUnidad(600f);
		limpieza.setCostoUnidad(433.22f);
		limpieza.setDescuento(0f);
		limpieza.setImportado(true);
		limpieza.setDisponible(false);
		limpieza.setAplicacion(TipoDeUso.MULTIUSO);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
///////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////     FIN - PRODUCTO      /////////////////////////////			
///////////////////////////////////////////////////////////////////////////////////			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//MAIN

}
