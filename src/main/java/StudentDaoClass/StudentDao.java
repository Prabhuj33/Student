package StudentDaoClass;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Studentdto.Student;

public class StudentDao
{

	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("prabhu").createEntityManager();
	}

	public void saveStudent(Student s) {
		// TODO Auto-generated method stub
		
		EntityManager em=getEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
	}

	public List<Student> getAllStudent() {
		
		
		EntityManager em=getEntityManager();
		Query q=em.createQuery("select s  from Student s ");
		
		List<Student> list=q.getResultList();
		return list;
	}

	public Student findbyStudentId(int id) {
		EntityManager em=getEntityManager();
		Student dbStudent=em.find(Student.class,id);
			return dbStudent;
		
	}

	public Student deleteStudent(int id) {
	EntityManager em=getEntityManager();
	EntityTransaction et=em.getTransaction();
	Student dbStudent=em.find(Student.class,id);
	if(dbStudent!=null)
	{
		et.begin();
		em.remove(dbStudent);
		et.commit();
		return dbStudent;
	}
	else {
		return null;
	}
	}

	
	
	public Student updateStudent(int id, Student student) {

		EntityManager em=getEntityManager();
		EntityTransaction et=em.getTransaction();
		 Student dbStudent=em.find(Student.class,id);
		if(dbStudent!=null)
		{
			et.begin();
			em.merge(student);
			et.commit();
			return student;
	 }
		else 
		{
			return null;
		}
		
	}

	
	
	
}
