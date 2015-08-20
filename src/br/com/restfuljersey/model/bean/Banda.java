package br.com.restfuljersey.model.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Banda {
	private String name;
	private int anoDeFormacao;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAnoDeFormacao() {
		return anoDeFormacao;
	}
	public void setAnoDeFormacao(int anoDeFormacao) {
		this.anoDeFormacao = anoDeFormacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
