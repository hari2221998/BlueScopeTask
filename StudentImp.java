package studentCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class StudentImp 
{
	

	  public static List<Map<String, Object>> getStudentDataFromDB() {
	        List<Map<String, Object>> studentDataList = new ArrayList<>();
	        
	    	Connection con = null;

	        try  {
	        	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?user=root&password=dinga");

	            String sqlQuery = "SELECT * FROM students";
	            ResultSet resultSet = con.createStatement().executeQuery(sqlQuery);

	            while (resultSet.next()) {
	                Map<String, Object> studentData = new LinkedHashMap<>();
	                studentData.put("NAME ", resultSet.getString(2));
	                studentData.put("CLASS ", resultSet.getString(3));
	                studentData.put("SCHOOL ", resultSet.getString(4));
	                studentData.put("ADDRESS ", resultSet.getString(5));
	                studentDataList.add(studentData);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        finally
	        {
	        	if(con!=null)
	        	{
	        		try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
	        	}
	        }
	        return studentDataList;
	    }

	public static void main(String[] args) 
	{
		 List<Map<String, Object>> studentDataList = getStudentDataFromDB();
	       System.out.println(studentDataList);
		
		

	}




}
