package Bookings;

public class Booking {
	
	private int bookId; 
	private String date;
	private int NumOfAdults;
	private int NumOfChild;
	private int packageID;
	private String userName;
	
	public Booking(int bookId, String date, int numOfAdults, int numOfChild, int packageID, String userName) {
		super();
		this.bookId = bookId;
		this.date = date;
		NumOfAdults = numOfAdults;
		NumOfChild = numOfChild;
		this.packageID = packageID;
		this.userName = userName;
	}

	public int getBookId() {
		return bookId;
	}

	public String getDate() {
		return date;
	}

	public int getNumOfAdults() {
		return NumOfAdults;
	}

	public int getNumOfChild() {
		return NumOfChild;
	}

	public int getPackageID() {
		return packageID;
	}

	public String getUserName() {
		return userName;
	}
	
	
	
	
}
