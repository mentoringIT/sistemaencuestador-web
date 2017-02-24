package mx.com.mentoringit.web.services;

import java.util.List;

import mx.com.mentoringit.model.dto.CourseDTO;

public interface ICourseService {
	public List<CourseDTO> course() throws Exception;

}
