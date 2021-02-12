package com.concept.abstractFactoryPattern;

public class HouseFactory {


	/**
	 * This method returns the object of type House   
	 * @param houseType
	 * @return
	 */
	public House getHouse(String houseType) {
		
		if(houseType == null) {  
			return null;  
		}

		if("DOMESTIC_HOUSE".equalsIgnoreCase(houseType)) {
			return new DomesticHouse();
		}
		
		else if("COMMERCIAL_HOUSE".equalsIgnoreCase(houseType)){  
			return new CommercialHouse();
		}
		
		else if("INSTITUTIONAL_HOUSE".equalsIgnoreCase(houseType)) {  
			return new InstitutionalHouse();
		}

		return null;  
	}
}