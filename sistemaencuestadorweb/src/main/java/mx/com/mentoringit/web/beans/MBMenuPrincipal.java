package mx.com.mentoringit.web.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import mx.com.mentoringit.model.dto.UserDTO;

@ManagedBean (name = "MBPrincipal")
@ViewScoped
public class MBMenuPrincipal {

	private String usuario;
	
	public MBMenuPrincipal () throws IOException   {
		try {
			FacesContext contex = FacesContext.getCurrentInstance();
			HttpServletRequest httpServletRequest = (HttpServletRequest)contex.getExternalContext().getRequest();
			UserDTO usuariodto = (UserDTO)httpServletRequest.getSession().getAttribute("sessionUsario");
			setUsuario(usuariodto.getUsername());
			
		} catch (Exception e) {
			ExternalContext externalcontex= FacesContext.getCurrentInstance().getExternalContext();
			externalcontex.redirect("index.xhtml");
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
