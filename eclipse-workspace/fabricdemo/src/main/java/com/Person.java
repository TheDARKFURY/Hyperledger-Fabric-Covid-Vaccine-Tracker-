package com;



import com.owlike.genson.annotation.JsonProperty;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import java.util.Objects;
 
@DataType()
public final class Person {

	@Property()
	private final String name;
 	
	@Property()
	private final String age;

	@Property()
	private final String gender;
		 
	@Property()
	private final String identity;
	 
	@Property()
	private final String vaccineName;
	
	@Property()
	private final String date1;
	
	@Property()
	private final String vaccineDose;
 

	

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getIdentity() {
		return identity;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public String getDate1() {
		return date1;
	}

	public String getVaccineDose() {
		return vaccineDose;
	}





	public Person(@JsonProperty("name") final String name , 
			@JsonProperty("age") final String age ,
			@JsonProperty("gender") final String gender, 
			@JsonProperty("identity") final String identity , 
			@JsonProperty("vaccineName") final String vaccineName,
			@JsonProperty("date1") final String date1 , 
			@JsonProperty("vaccineDose") final String vaccineDose) 
	{
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.identity = identity;
		this.vaccineName = vaccineName;
		this.date1 = date1;
		this.vaccineDose = vaccineDose;
	
	}
 
	

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
 
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
 
		Person other = (Person) obj;

		return Objects.deepEquals(new String[] { getName(),getAge(), getGender(), getIdentity(), getVaccineName(), getDate1(), getVaccineDose()},
	
			new String[] { other.getName(), other.getAge() ,other.getGender(), other.getIdentity(), other.getVaccineName(), other.getDate1(),getVaccineDose()});
		
		
	}
 
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getAge(), getGender(), getIdentity(),getVaccineName(),getDate1(),getVaccineDose());
	}
 
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " [name="+name +" age=" + age + ", gender=" + gender
				+ ", identity=" + identity + ", vaccineName=" + vaccineName + " , date1="+ date1 + ",vaccineDose=" +vaccineDose+ "]";
	}
 
}

	


