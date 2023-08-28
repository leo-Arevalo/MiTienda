/**
 * 
 */
package com.la.mitienda.pojos;

import java.util.Date;

/**
 * @author LeO
 *
 */
public interface Comestible {
	
	public static final Boolean COMESTIBLE = true;
	
	public Date getVencimiento();
	public void setVencimiento(Date vencimiento);
	public Float getCalorias();
	public void setCalorias(Float calorias);
	public Boolean getComestible();
}
