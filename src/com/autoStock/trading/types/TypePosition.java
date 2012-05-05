/**
 * 
 */
package com.autoStock.trading.types;

import com.autoStock.position.PositionDefinitions.PositionType;


/**
 * @author Kevin Kowalewski
 *
 */
public class TypePosition {
	public int units;
	public String symbol;
	public String securityType;
	public double price;
	public double lastKnownPrice;
	public PositionType positionType;
	
	public TypePosition(){
		
	}

	public TypePosition(PositionType positionType, int units, String symbol, String securityType, double averagePrice) {
		this.positionType = positionType;
		this.units = units;
		this.symbol = symbol;
		this.securityType = securityType;
		this.price = averagePrice;
	}
}
