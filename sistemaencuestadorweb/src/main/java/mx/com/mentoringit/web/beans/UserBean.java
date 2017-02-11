package mx.com.mentoringit.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import mx.com.mentoringit.model.dto.UserDTO;
import mx.com.mentoringit.web.services.IUserService;


@ManagedBean
@RequestScoped
public class UserBean implements IUserBean{

	private IUserService userService;
	private String username;
	private String password;
	private FacesContext facesContext;
	private FacesMessage facesMessage;
	private HttpServletRequest httpServletRequest;
	
	public UserBean() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		facesContext = FacesContext.getCurrentInstance();
		
		httpServletRequest = (HttpServletRequest)facesContext.getExternalContext().getRequest();
	}
	
	@Override
	public String userLogin() {
		
		String result = "";
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(username);
			
			userDTO.setPassword(password);
			
			UserDTO usuarioValido = userService.userLogin(userDTO);
			facesContext = FacesContext.getCurrentInstance();
			httpServletRequest = (HttpServletRequest)facesContext.getExternalContext().getRequest();
			httpServletRequest.getSession().setAttribute("sessionUsario", usuarioValido);
			
			result ="login";
			
		} catch (Exception e) {
			setFacesMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña invalidos", null));
			facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, facesMessage);
			e.printStackTrace();
			result = "index";
			
		}
		return result;
	}

	public IUserService getUserService() {
		return userService;
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FacesMessage getFacesMessage() {
		return facesMessage;
	}

	public void setFacesMessage(FacesMessage facesMessage) {
		this.facesMessage = facesMessage;
	}

}