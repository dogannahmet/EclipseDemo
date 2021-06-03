package com.javacamp.hrms.core.utilities.concretes;


import org.springframework.stereotype.Service;

import com.javacamp.hrms.entities.concretes.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisManagerAdapter {
	public boolean checkIfRealPerson(Candidate candidate){
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result;
		
		try {
			result=client.TCKimlikNoDogrula(
						Long.parseLong(candidate.getIdentityNumber()), 
						candidate.getFirstName().toUpperCase(), 
						candidate.getLastName().toUpperCase(), 
						Integer.parseInt(candidate.getBirthYear()));
				
		return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		
		}
	}
}
