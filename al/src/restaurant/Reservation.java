package restaurant;

public class Reservation {
	private int diner;
	private String contactName;
	private String contactPhone;
	private String contactEmail;
	
	public Reservation(int diner, String contactName, String contactPhone)
	{
		setDiner(diner);
		setContactName(contactName);
		setContactPhone(contactPhone);	
	}
	
	public Reservation(int diner, String contactName, String contactPhone, String contactEmail)
	{
		this(diner, contactName, contactPhone);
		setContactEmail(contactEmail);
	}
	
	public Reservation()
	{
		this(0,"Joe Doe", "000-000-0000");
	}
	
	public boolean checkReservation(int diner, String contactName, String contactPhone)
	{
		return ((this.diner == diner) && (this.contactName.equals(contactName)) && (this.contactPhone.equals(contactPhone)));
	}

	public int getDiner() {
		return diner;
	}

	public void setDiner(int diner) {
		this.diner = diner;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
}
