/**
 * 
 */
package de.oderkerk.tools.lkz.rest;

import de.oderkerk.tools.lkz.entity.LKZEntity;
import de.oderkerk.tools.lkz.entity.rest.responses.LKZResponse;

/**
 * Helper for transfering data between different structures
 * 
 * @author Odin
 * @version 11-2020
 */
public class DataStructureConverter {

	/**
	 * Fill new Repsonse from LKZEntity
	 * @param entity with source data
	 * @return LKZResponse with data from entity
	 */
	public static LKZResponse convertFromLKZEntityToLKZResponse(LKZEntity entity) {
		LKZResponse response = new LKZResponse();
		response.setLaendername(entity.getLaendername());
		
		return new LKZResponse(entity.getLaendername(), entity.getDestatisBEVCodeGebiet(),
				entity.getDestatisBEVCodeStaatsang(), entity.getDestatisBEVCodeStaat(), entity.getIso316612(),
				entity.getIso316613(), entity.getIso31661num(),  entity.getIcao(),
				entity.getDestatisAussenhandelsCode(), entity.getKfzKennzeichen(),
				entity.getLaenderzusatzAdressFeldPost(),entity.getDBankLKZ2(), entity.getDBankLKZnum(),
				entity.getDBankLandkuerzel(), entity.getDBankwaehrungcode(),"DatenQuelle: https://www.destatis.de Stand 12.11.2020");
	}
}
