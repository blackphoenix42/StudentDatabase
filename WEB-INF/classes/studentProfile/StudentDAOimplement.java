package studentProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import connection.MakeConnection;


public class StudentDAOimplement implements StudentDAO {

	@Override
	public boolean insert(Student s) {
		Connection con = MakeConnection.getDBConnection();
		int id = s.getId();
		String name = s.getName();
		String email = s.getEmail();
		String course = s.getCourse();
		String query = "INSERT INTO studentinfo VALUES(?,?,?,?)";
		try(
				PreparedStatement ps = con.prepareStatement(query);
			){
			System.out.println("DB Connection Established!");
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setString(4, course);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student fetchStudent(int id) {
		Student s = new Student();
		String query = "SELECT * FROM studentinfo WHERE ID=?";
		 Connection con = MakeConnection.getDBConnection();
		 try(
				 PreparedStatement ps = con.prepareStatement(query);
			){
			 ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s.setId(id);
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				return s;
			}
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return s;
	}

	@Override
	public List<Student> fetchAllStudents() {
		List<Student> students = new ArrayList<Student>();
		String query = "SELECT * FROM studentinfo";
		Connection con = MakeConnection.getDBConnection();
		 try(
				 PreparedStatement ps = con.prepareStatement(query);
			){
			 System.out.println("DB Connection Established!");
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 Student s = new Student();
				 s.setId(rs.getInt("id"));
				 s.setName(rs.getString("name"));
				 s.setEmail(rs.getString("email"));
				 s.setCourse(rs.getString("course"));
				 students.add(s);
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		Collections.sort(students, (s1,s2)->s1.getId()-s2.getId());
		return students;
	}

	@Override
	public boolean remove(int id) {
		String query = "DELETE FROM studentinfo WHERE id=?";
		Connection con = MakeConnection.getDBConnection();
		 try(PreparedStatement ps = con.prepareStatement(query);){
			 
			 System.out.println("DB Connection Established!");
			 ps.setInt(1,id);
			 ps.executeUpdate();
			 System.out.println("Student Removed!");
			 return true;
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return false;
	}

	@Override
	public boolean update(Student s,int oldId) {
		
		String query = "UPDATE studentinfo SET name = ?, email=?, course=? WHERE id = ?";
		Connection con = MakeConnection.getDBConnection();
		try(
				PreparedStatement ps = con.prepareStatement(query);
		   ){
			System.out.println("DB Connection Established!");
//			ps.setInt(1, s.getId());
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getCourse());
			ps.setInt(4, oldId);
			ps.executeUpdate();
			System.out.println("Updated Successfully!");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
