package FakeMernisService;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisService {
	
	public boolean ValidatePersonal(long nationalId, String firstName, String lastName, String yearOfBirth)
	{
		System.out.println(firstName + " " + lastName + " gerçek kişidir." );
		return true;
	}
}
