package mx.com.mentoringit.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.mentoringit.model.dao.CourseDAO;
import mx.com.mentoringit.model.dto.CourseDTO;


@Service
public class CourseService implements ICourseService {
	
	private CourseDAO courseDAO;

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List<CourseDTO> course() throws Exception {		
		return courseDAO.select() ;
	}

	

	
}
