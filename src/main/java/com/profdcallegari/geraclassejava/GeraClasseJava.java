package com.profdcallegari.geraclassejava;

/**
 * GeraClasseJava
 * Atenção: esta versão ainda não trata todas as entradas incorretas.
 * Estilo simplificado para uso por estudantes.
 * @version 0.1
 * @author Daniel Callegari (PUCRS)
 */
public class GeraClasseJava {
    
    private static final String NOME_PROJETO = "GeraClasseJava";
    private static final String NUM_VERSAO = "0.1";
    private static final String ASSINATURA = "Daniel Callegari, Jan 2020";
    public  static final String CABECALHO = NOME_PROJETO + " " + NUM_VERSAO + " - " + ASSINATURA;

    public static void main(String[] args) {

        final boolean demoMode = false;

        if (demoMode) { // Executando versao de demonstracao

            args = "Funcionario s:nome d:anoNasc f:salario c:sexo b:ativo".split(" ");
            GeradorClasse.gerarClasse(args);

        } else { // Executando versao final

            // Mostrar instrucoes? (caso chamado sem argumentos suficientes)
            if (args.length <= 1) {
                mostrarAjuda();
            } else {
                GeradorClasse.gerarClasse(args);
            }

        }
        
    }

    private static void mostrarAjuda() {
        System.out.println(CABECALHO);
        System.out.println("Gera o codigo-fonte de uma classe Java com getters & setters.");
        System.out.println("Uso:\n\tGeraClasseJava NomeClasse tipo:nomeAtributo1 [tipo:nomeAtributo2 ...]");
        System.out.println("\tTipos: s=String, d=int, f=double, c=char, b=boolean");
        System.out.println("Exemplo:\n\tjava -jar GeraClasseJava.jar Funcionario s:nome d:anoNasc f:salario c:sexo");
        System.out.println();
    }
  
}
