package model;
import java.util.Date;

public class Author implements Comparable<Author> {
	
	private String lastname;
	private String firstname;
	private Date birthDate;
	
	public Author() {
		
	}
	
	public Author(String last, String first) {
		this.firstname = first;
		this.lastname = last;
	}
	
	public String getLastname() {
		return lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String toString() {
		return this.lastname+", "+this.firstname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	@Override
	public int compareTo(Author arg0) {
			if (this.lastname.equals(arg0.lastname)) {
				return this.firstname.compareTo(arg0.firstname);
			} else {
				return this.lastname.compareTo(arg0.lastname);
			}
			
		
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
