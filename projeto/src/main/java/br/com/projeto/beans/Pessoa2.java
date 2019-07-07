package br.com.projeto.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

@ViewScoped
@ManagedBean(name = "pessoaBean2")
public class Pessoa2 extends PessoaBean {
	private List<String> pessoas = new ArrayList<String>();
	private HtmlCommandButton commandButton;

	public List<String> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<String> pessoas) {
		this.pessoas = pessoas;
	}

	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}

	public String addPessoa() {
		pessoas.add(this.getNome() + " " + this.getSobrenome() + " " + this.getIdade());
		if (pessoas.size() > 3)
			commandButton.setDisabled(true);
		return "";
	}
}
