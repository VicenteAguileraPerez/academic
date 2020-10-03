package utility.helpers;

import java.util.ArrayList;

import org.json.JSONObject;

public class VerifiedInformationHelper 
{
	
	
	public JSONObject verifyData(JSONObject jsonObject)
	{
		
		JSONHelper jsonHelper = new JSONHelper();
		StringHelper stringHelper = new StringHelper();
		boolean boolcontrol = false,boolname= false,boollast= false,boolcareer= false,boolage= false
				,boolbirthday= false,booladdress= false,boolcity= false,boolstate= false,boolemail= false;
		ArrayList<String> keys = jsonHelper.returnKey(jsonObject);
		
		//[birthday, control-number, career, address, notes, last, city, name, state, age, email]
		//System.out.println(keys);
		
		String control_number = jsonObject.getString(keys.get(1));
		String name = jsonObject.getString(keys.get(7));
		String last = jsonObject.getString(keys.get(5));
		String career = jsonObject.getString(keys.get(2));
		String age = jsonObject.getString(keys.get(9));
		String birthday = jsonObject.getString(keys.get(0));
		String address = jsonObject.getString(keys.get(3));
		String city = jsonObject.getString(keys.get(6));
		String state = jsonObject.getString(keys.get(8));
		String email = jsonObject.getString(keys.get(10));
		String notes = jsonObject.getString(keys.get(4));	
			
	
		if(control_number.length()==8)
		{
			boolcontrol = true;
		}
		if(name.length()<=50)
		{
			name=  stringHelper.CapitalLetterEachWordStatic(name);
			System.out.println("name"+name);
			jsonObject.put("name",name);
			
			boolname=true;
		}
		if(last.length()<=80)
		{
			last= stringHelper.CapitalLetterEachWordStatic(last);
			System.out.println("last"+last);
			jsonObject.put("last", last);
			boollast=true;
		}
		if(career.length()==3)
		{
			career =career.toUpperCase();
			System.out.println("carrera"+career);
			jsonObject.put("career", career);
			boolcareer=true;
		}
		if(stringHelper.justNumbers(age, 3))
		{
			boolage=true;
		}
		
		if(stringHelper.date(birthday))
		{
			boolbirthday=true;
		}
		if(address.length()<=150)
		{
			address = stringHelper.firstCapitalLetter(address);
			jsonObject.put("address", address);
			booladdress=true;
		}
		if(stringHelper.email(email))
		{
			boolemail=true;
			
		}
		if(!notes.isBlank())
		{
			notes = stringHelper.firstCapitalLetter(notes);
			jsonObject.put("notes", notes);
		}
		if(!city.isBlank())
		{
			city = stringHelper.firstCapitalLetter(city);
			
			jsonObject.put("city", city);
			boolcity=true;
		}
		if(!state.isBlank())
		{
			state = stringHelper.firstCapitalLetter(state);
			jsonObject.put("state", state);
			boolstate=true;
		}
		
		if( boolcontrol && boolname && boollast && boolcareer && boolage && boolbirthday && booladdress && boolcity && boolstate && boolemail) 
		{
			
			return jsonObject;
		}
		else {
			return null;
		}
		
	}

}
