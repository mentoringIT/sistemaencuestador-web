package mx.com.mentoringit.web.services;

import mx.com.mentoringit.model.dao.StudentDAO;
import mx.com.mentoringit.model.dto.StudentDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService, Serializable {
	
	public StudentService() {}
	
	private StudentDAO studentDAO;
	private List<StudentDTO> list;
	


	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	
	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public List<StudentDTO> student() {				
		return list = studentDAO.select();
	}

}
