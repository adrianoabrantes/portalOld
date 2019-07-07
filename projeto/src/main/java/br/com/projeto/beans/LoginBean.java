package br.com.projeto.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.text.html.HTMLEditorKit.HTMLTextAction;

@ViewScoped
@ManagedBean(name = "loginBean")
public class LoginBean {
	private String usuario;
	private String senha;
	private String mensagem;
	HTMLTextAction textAction;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public HTMLTextAction getTextAction() {
		return textAction;
	}

	public void setTextAction(HTMLTextAction textAction) {
		this.textAction = textAction;
	}

	public String logar() {
		String pagina = "";
		if (this.getUsuario().isEmpty()) {
			this.setMensagem("Campos Usuario nao pode estar vazio!");
		} else if (this.getSenha().isEmpty()) {
			this.setMensagem("Campos Senha nao pode estar vazio!");
		} else {
			pagina = "pagina2";
		}
		return pagina;
	}
}
