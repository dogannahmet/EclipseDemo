package com.javacamp.hrms.core.utilities.concretes;


import org.springframework.stereotype.Service;

import com.javacamp.hrms.entities.concretes.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisManagerAdapter {
	public boolean checkIfRealPerson(Candidate candidate){
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result=true;
		try {
			result=client.TCKimlikNoDogrula(
						Long.valueOf(candidate.getIdentityNumber()), 
						candidate.getFirstName(), 
						candidate.getLastName(), 
						Integer.parseInt(candidate.getBirthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
}
