package br.com.projeto.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String usuario;
	private String senha;
	private String confirmarSenha;
	private String mensagem;

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		if (usuario.isEmpty()) {
			mensagem = "Campo usuario nao pode estar em branco!";

		} else {
			this.usuario = usuario;
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String validarCampos() {
		mensagem = "Campo nao pode estar vazio!";

		if (!(this.getUsuario().isEmpty() || this.getSenha().isEmpty() || this.getConfirmarSenha().isEmpty())) {
			if (!this.getSenha().equals(this.getConfirmarSenha())) {
				mensagem = "Campo senha e confirmar senha nao confere!";

			} else {
				mensagem = "Usuario cadastrado!";
			}
		} else {
			mensagem = "pagina2";
		}

		return mensagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
