package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class AuthenticationDetailsDaoImpl implements AuthenticationDetailsDao{

	FileReader reader=null;
	Properties prop=null;
	
	
	public AuthenticationDetailsDaoImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}//end of constructor..
	
	@Override
	public boolean addUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertauthentication"))
				){	
			  insert.setString(1, aDetails.getUserName());
			  insert.setString(2, aDetails.getPassword());
			  insert.setString(3, aDetails.getRole());
			int result=insert.executeUpdate(); 
			if(result>0) {
				return true;
			}//end of if
		}//end of try
		catch (Exception e) {
			throw new CustomExceptions("User Name already exists, please select other User names !!");
		}
		return false;
	}//end of method..

	
	
	@Override
	public boolean deleteUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deleteauthentication"))
				){	
			
			delete.setString(1, aDetails.getUserName());
			delete.setString(2, aDetails.getPassword());
			int result=delete.executeUpdate();
			if(result>0) {
				return true;
			}	
		}
		catch (Exception e) {
			throw new CustomExceptions("THE USER NAME AND PASSWORD DID`NT MATCHED ,ENTER VALID LOGIN CREDENTIALS !!");
		}
		 return false;
	}

	@Override
	public boolean modifyUser(AuthenticationDetailsDto aDetails, String newPassword) throws CustomExceptions {
		
		return false;
	}

	@Override
	public AuthenticationDetailsDto viewSingleUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				Statement stmt=conn.createStatement()
				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewsingleauthenticationuserdetails"));
		    while(rs.next()) {
		    	AuthenticationDetailsDto adt=new AuthenticationDetailsDto();
		    	aDetails.setUserName(rs.getString(1));
		    	aDetails.setPassword(rs.getString(2));
		    	aDetails.setRole(rs.getString(3));
		    	return aDetails;
		    }
		}
		catch (Exception e) {
			throw new CustomExceptions("\n There are no Client details present in the database !!\n");
		}
		return null;
	}


	@Override
	public List<AuthenticationDetailsDto> viewAllClients() throws CustomExceptions {
		List<AuthenticationDetailsDto> l1=new ArrayList<AuthenticationDetailsDto>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				Statement stmt=conn.createStatement()
				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallauthenticationclientdetails"));
		    
		    while(rs.next()) {
		    	AuthenticationDetailsDto adt=new AuthenticationDetailsDto();
		    	adt.setUserName(rs.getString(1));
		    	adt.setPassword(rs.getString(2));
		    	adt.setRole(rs.getString(3));
		    	l1.add(adt);
		    }
		}
		catch (Exception e) {
			throw new CustomExceptions("\n There are no Client details present in the database !!\n");
		}
		return l1;
	}

	@Override
	public List<AuthenticationDetailsDto> viewAllScheduers() throws CustomExceptions {
		List<AuthenticationDetailsDto> l1=new ArrayList<AuthenticationDetailsDto>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				Statement stmt=conn.createStatement()
				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallauthenticationschedulerdetails"));
		    while(rs.next()) {
		    	AuthenticationDetailsDto adt=new AuthenticationDetailsDto();
		    	adt.setUserName(rs.getString(1));
		    	adt.setPassword(rs.getString(2));
		    	adt.setRole(rs.getString(3));
		    	l1.add(adt);
		    }
		}
		catch (Exception e) {
			throw new CustomExceptions("\n There are no scheduler details present in the database !!\n");
		}
		return l1;
	}

	@Override
	public AuthenticationDetailsDto checkUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		AuthenticationDetailsDto adt=new AuthenticationDetailsDto(); 
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("viewsingleauthenticationuserdetails"))
				){	
			    pstmt.setString(1, aDetails.getUserName());
			pstmt.setString(2, aDetails.getPassword());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				   adt.setUserName(rs.getString(1));
				   adt.setPassword(rs.getString(2));
				   adt.setRole(rs.getString(3));
			   }   
		}
		catch (Exception e) {
			throw new CustomExceptions("\n There are no Client details present in the database !!\n");
		}
		
		return adt;
	}

	
	
	
	
	
	
	
	
	
	
}
