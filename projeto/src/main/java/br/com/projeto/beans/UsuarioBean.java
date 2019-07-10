package br.com.projeto.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.projeto.DAO.DaoGeneric;
import br.com.projeto.entidades.Usuario;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String salvar() {
		usuario = daoGeneric.merge(usuario);
		carregarUsuarios();
		return "";
	}

	public String remove() {
		daoGeneric.deletePorId(usuario);
		novo();
		carregarUsuarios();
		return "";
	}

	public String novo() {
		usuario = new Usuario();
		return "";
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	@PostConstruct
	public void carregarUsuarios() {
		usuarios = daoGeneric.getListEntity(Usuario.class);
	}
}
