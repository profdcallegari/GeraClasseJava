# GeraClasseJava
Um gerador bastante simplificado de classes java via linha de comando.
Gera o código-fonte de uma classe Java com construtor, getters & setters.

## Versões
GeraClasseJava 0.1 - Daniel Callegari, Jan 2020

## Uso:
	GeraClasseJava NomeClasse tipo:nomeAtributo1 [tipo:nomeAtributo2 ...]
	Tipos: s=String, d=int, f=double, c=char, b=boolean
    Pelo menos um atributo deve ser especificado.

## Exemplo:
	java -jar GeraClasseJava.jar Funcionario s:nome d:anoNasc f:salario c:sexo
  
irá produzir o arquivo Funcionario.java com o seguinte conteúdo:

```java
// Arquivo gerado automaticamente por
// GeraClasseJava 0.1 - Daniel Callegari, Jan 2020

public class Funcionario {

	private String nome;
	private int anoNasc;
	private double salario;
	private char sexo;

	public Funcionario (String nome, int anoNasc, double salario, char sexo) {
		this.setNome(nome);
		this.setAnoNasc(anoNasc);
		this.setSalario(salario);
		this.setSexo(sexo);
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

	public char getSexo () {
		return this.sexo;
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

	public void setSexo (char sexo) {
		this.sexo = sexo;
	}

}
```

