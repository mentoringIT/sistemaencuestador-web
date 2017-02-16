package mx.com.mentoringit.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.web.services.ICourseService;

@ManagedBean
@SessionScoped
public class CourseBean {

	private List<CourseDTO> listaC;
	private ICourseService courseService;

	public CourseBean() {
	}

	public List<CourseDTO> getListaC() {
		selectCourse();
		return listaC;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public void selectCourse() {
		try {
			listaC = this.courseService.course();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
