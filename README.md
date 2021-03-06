# GeraClasseJava [![Build Status](https://travis-ci.org/profdcallegari/GeraClasseJava.svg?branch=master)](https://travis-ci.org/profdcallegari/GeraClasseJava) [![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/dashboard?id=profdcallegari_GeraClasseJava)
Um gerador bastante simplificado de classes java via linha de comando.
Gera o código-fonte de uma classe Java com construtor, getters & setters.

## Versões
GeraClasseJava 0.1 - Daniel Callegari, Jan 2020

## Uso:
	GeraClasseJava NomeClasse tipo:nomeAtributo1 [tipo:nomeAtributo2 ...]
	Tipos: s=String, d=int, f=double, c=char, b=boolean
    Pelo menos um atributo deve ser especificado.

## Exemplo:
	java -jar GeraClasseJava.jar Funcionario s:nome d:anoNasc f:salario
  
irá produzir o arquivo **Funcionario.java** com o seguinte conteúdo:

```java
public class Funcionario {

	private String nome;
	private int anoNasc;
	private double salario;

	public Funcionario (String nome, int anoNasc, double salario) {
		this.setNome(nome);
		this.setAnoNasc(anoNasc);
		this.setSalario(salario);
	}

	public String getNome () {
		return this.nome;
	}

	public int getAnoNasc () {
		return this.anoNasc;
	}

	public double getSalario () {
		return this.salario;
	}

	public void setNome (String nome) {
		this.nome = nome;
	}

	public void setAnoNasc (int anoNasc) {
		this.anoNasc = anoNasc;
	}

	public void setSalario (double salario) {
		this.salario = salario;
	}

}
```
