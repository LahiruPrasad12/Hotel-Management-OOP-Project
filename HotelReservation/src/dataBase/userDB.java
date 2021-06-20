package dataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bookings.Booking;
import Hotel.Hotel;
import Packages.Packages;
import user.User;

public class userDB {
	

	//userge username and password validation eka mehidi siduve
	public static String validate(String uName,String passw) {
		String result = "fale";
	
		
		try {
			
			//validate user name and password
			Connection connect = DBconnection.getConnection();
			Statement state = connect.createStatement();
			String sql = "select userName from hotel_reservation.user where userName = '"+uName+"' and password = '"+passw+"'";
			ResultSet resSet = state.executeQuery(sql);
			
			System.out.println(uName);
			if(resSet.next()) {
				result = uName;
			}
			else {
				result="false";
			}
		
		
		}catch (Exception e) {
			e.getMessage();
		}
		
		return result;
		
	}//End OF The User Validation part
	
	
	
	
	
	
	//userge view profile function ek mehidi siduve
	public static List<User> ViewDetails (String username){
		ArrayList<User> ar = new ArrayList<User>();
		
		try {
			
			//userge Id ekata anuva siyaluma data retrieve kirima mehidi siduve
			Connection connect = DBconnection.getConnection();
			Statement stm = connect.createStatement();
			String sql = "select * from hotel_reservation.user where userName ='"+username+"'";
			ResultSet res = stm.executeQuery(sql);
			
			if(res.next()) {
				String uname = res.getString(1);
				String fname = res.getString(2);
				String lname = res.getNString(3);
				String phone = res.getString(4);
				String email = res.getString(5);
				String address = res.getString(6);
				String nic = res.getString(7);
				String password = res.getString(8);
				
				User us = new User(uname, fname, lname, phone, email, address, nic, password);
				ar.add(us);
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		return ar;
	}
	
	
	
	
	//userge details update kirima sadaha mema method ek use krai
	public static String updateData(String uname,String fname,String lname,String phone, String mail,String address,String nic,String pass) {
		String rezult = "false";
		System.out.println(nic);
		
		try {
			//userge details update kirima mehidi sidune
			Connection connect = DBconnection.getConnection();
			Statement stat = connect.createStatement();
			String sql = "update hotel_reservation.user set userName='"+uname+"',fname='"+fname+"',lname='"+lname+"',phone='"+phone+"',email='"+mail+"',address='"+address+"',NIC='"+nic+"',password='"+pass+"' where userName = '"+uname+"' ";
			int res = stat.executeUpdate(sql);
			System.out.println(nic);
			if(res>0) {
				rezult = uname;
			}else {
				rezult = "false";
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		
		return rezult;
	}
	
	
	//new user kenek add kirima mehidi siduve
	public static boolean addBusOwner(String fname,String lname,String email,String phone,String address,String NIC,String userName,String password ) {
		boolean result = false;
		
		try {

			
			//add new user details
			Connection connect = DBconnection.getConnection(); 
			Statement stm = connect.createStatement();
			String sql = "insert into hotel_reservation.user values('"+userName+"','"+fname+"','"+lname+"','"+phone+"','"+email+"','"+address+"','"+NIC+"','"+password+"')";
			int res = stm.executeUpdate(sql);
			
			if(res>0) {
				result = true;
			}
			else {
				result = false;
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
		//return state of user registration
		return result;
			
	}//End Of the addBusOwner method...
	
	
	
	
	//account ekk deactivate kirima mema function ek magin sidu karai
	public static boolean deleteAccount(String username) {
		boolean rezult=false;
		
		try {
			//userge account ekk table eken delete kirimat avashya sql quary ek mehidi sidu karai
			Connection connect = DBconnection.getConnection();
			Statement stm = connect.createStatement();
			String sql = "delete from hotel_reservation.user where userName='"+username+"'";
			int res = stm.executeUpdate(sql);
			
			if(res>0) {
				rezult=true;
			}
			else {
				rezult=false;
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		return rezult;
		
	}//End Of the deleteAccount method...
	
	
	
	//book hotel
	public static List<Hotel> viewHotel(){
		ArrayList<Hotel> ar = new ArrayList<>();
		
		try {
			//view all hotel
			Connection connect = DBconnection.getConnection();
			Statement stm = connect.createStatement();
			String sql = "select * from hotel_reservation.hotel";
			ResultSet res = stm.executeQuery(sql);
			
			while(res.next()) {
				String name = res.getString(1);
				String address = res.getString(2);
				String contact = res.getString(3);
				String director = res.getString(4);
				String owner = res.getString(5);
				String rating = res.getString(6);
				String noOfHalls = res.getString(6);
				
				Hotel h = new Hotel(name, address, contact, director, owner, rating, noOfHalls);
				ar.add(h);
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		return ar;
	}
	
	
	
	//View all Packages of relevant Hotel
	public static List<Packages> getPackage(String hotelNam) {
		
		ArrayList<Packages> viewPackage = new ArrayList<>();

		try {
			//view all packages of relevant hotel
			Connection connect = DBconnection.getConnection();
			Statement stm = connect.createStatement();
			String sql = "select * from hotel_packages where hotel_name = '"+hotelNam+"'";
			ResultSet res = stm.executeQuery(sql);
			
			while(res.next()) {
				
				 int packId = res.getInt(1);
				 String packageName = res.getString(2);
				 float buffetPrice = res.getFloat(3);
				 int numberOfMeals = res.getInt(4); 
				 float poolCharges = res.getFloat(5); 
				 float gymCharges = res.getFloat(6);
				 float liquor = res.getFloat(7); 
				 String timeDuration = res.getString(8);
				 String hotelName = res.getString(9);
				
				 Packages pack = new Packages(packId, packageName, buffetPrice, numberOfMeals, poolCharges, gymCharges, liquor, timeDuration, hotelName);
				 viewPackage.add(pack);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return viewPackage;	
	}
	
	
	
	
	//insert booking details
	public static boolean addBookingDetails(String PackageID,String UserName,String Date,int numOfAdults,int numOfChild) {
		boolean result = false;
		
		try {

			
			//add  book details
			Connection connect = DBconnection.getConnection(); 
			Statement stm = connect.createStatement();
			String sql = "insert into hotel_reservation.bookings values('"+PackageID+"','"+Date+"','"+numOfAdults+"','"+numOfChild+"','"+PackageID+"','"+UserName+"')";
			int res = stm.executeUpdate(sql);
			
			if(res>0) {
				result = true;
			}
			else {
				result = false;
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
		//return state of user registration
		return result;
			
	}//End Of the addBusOwner method...
	
	
	
	
	
	//view all booking of one user
	public static List<Booking> viewBookDet(String uName){
		ArrayList<Booking> ar = new ArrayList<Booking>();
		System.out.println(uName);
		try {
			//view all booking of one user
			Connection connect = DBconnection.getConnection(); 
			Statement stm = connect.createStatement();
			String sql = "select * from hotel_reservation.bookings where UserName = '"+uName+"'";
			ResultSet res = stm.executeQuery(sql);
			
			if(res.next()) {
				int bookingID = res.getInt(1);
				 String Date = res.getString(2);
				 int NumOfAdults =  res.getInt(3);
				 int NumOfChild = res.getInt(4); 
				 int PackageID = res.getInt(5); 
				 String UserName = res.getString(6);
				 System.out.println(Date);
				 Booking bk = new Booking(bookingID, Date, NumOfAdults, NumOfChild, PackageID, UserName);
				 ar.add(bk);
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		return ar;
	}
	
	
	
	
	
	//update booking details
	public static boolean updateBooking(int bookID,String date,int NumOfChild,int NumOfAdult){
		boolean rezult= false;
		
		try {
			//update Booking details
			Connection connect = DBconnection.getConnection(); 
			Statement stm = connect.createStatement();
			String sql = "update hotel_reservation.bookings set Date='"+date+"', NumOfAdults='"+NumOfAdult+"', NumOfChild='"+NumOfChild+"' where bookingID = '"+bookID+"'";
			int res = stm.executeUpdate(sql);
			
			if(res>0) {
				rezult = true;
			}
			else {
				rezult = false;
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		return rezult;
	}
	
	
	public static boolean deleteBooking(int bookID) {
		boolean rezult=false;
		
		try {
			//userge account ekk table eken delete kirimat avashya sql quary ek mehidi sidu karai
			Connection connect = DBconnection.getConnection();
			Statement stm = connect.createStatement();
			String sql = "delete from hotel_reservation.bookings where bookingID='"+bookID+"'";
			int res = stm.executeUpdate(sql);
			
			if(res>0) {
				rezult=true;
			}
			else {
				rezult=false;
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		return rezult;
	}

}
