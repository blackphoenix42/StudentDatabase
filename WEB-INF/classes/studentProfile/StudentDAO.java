package studentProfile;

import java.util.List;

public interface StudentDAO {
	boolean insert(Student s);
	List<Student> fetchAllStudents();
	Student fetchStudent(int id);
	boolean remove(int id);
	boolean update(Student s,int oldId);
}
