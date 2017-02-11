package mx.com.mentoringit.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.IStudentService;

@ManagedBean
@SessionScoped
public class StudentBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<StudentDTO> listaA;
	private IStudentService studentService;
	
	public StudentBean() {}
	
	public List<StudentDTO> getListaA() {
		return listaA = this.studentService.student();
	}


	public void setListaA(List<StudentDTO> listaA) {
		this.listaA = listaA;
	}


	public IStudentService getStudentService() {
		return studentService;
	}


	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

}
