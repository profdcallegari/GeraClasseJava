package com.profdcallegari.geraclassejava;

import java.io.*;

/**
 * GeraClasseJava
 * Atenção: esta versão ainda não trata entradas incorretas.
 * @version 0.1
 * @author Daniel Callegari
 */
public class GeraClasseJava {
    
    private static final String NOME_PROJETO = "GeraClasseJava";
    private static final String NUM_VERSAO = "0.1";
    private static final String ASSINATURA = "Daniel Callegari, Jan 2020";
    private static final String CABECALHO = NOME_PROJETO + " " + NUM_VERSAO + " - " + ASSINATURA;

    public static void main(String[] args) {
        // Mostar instrucoes? (caso chamado sem nenhum parâmetro)
        if (args.length <= 1) mostrarAjudaESair();

        // Para teste
//        args = new String[5];
//        args[0] = "Funcionario";
//        args[1] = "s:nome";
//        args[2] = "d:anoNasc";
//        args[3] = "f:salario";
//        args[4] = "c:sexo";

        // Obtém o nome da classe a gerar
        String nomeClasse = args[0];
        Classe novaClasse = new Classe(nomeClasse);

        // Obtém os atributos (se existirem)
        for (int i = 1; i < args.length; i++) {
            String sAtributo = args[i]; // tipo:nomeAtributo

            char tipoAtributo = sAtributo.charAt(0);
            //char doisPontos = sAtributo.charAt(1);
            String idAtributo = sAtributo.substring(2);

            novaClasse.adicionarAtributo(idAtributo, tipoAtributo);
        }
        
        gerarArquivoClasse(novaClasse);
        
    }
    
    private static void gerarArquivoClasse(Classe classe) {
        
        try {
            File fout = new File(classe.getNomeArquivoJava());
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            // Gerar cabecalho
            bw.write("// Arquivo gerado automaticamente por\n// ");
            bw.write(CABECALHO);
            bw.write("\n\n");
            
            // Gerar inicio da classe
            bw.write(classe.gerarInicioClasse());
            
            // Gerar atributos
            bw.write(classe.gerarDeclaracaoAtributos());
            
            // Gerar construtor
            bw.write(classe.gerarConstrutor());
            
            // Gerar metodos
            bw.write(classe.gerarMetodosGetSet());
            
            // Gerar fim da classe
            bw.write(classe.gerarFimClasse());
            
            bw.newLine();
            bw.close();
            System.out.println("Arquivo " + classe.getNomeArquivoJava() + " gerado.");
        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo " + classe.getNomeArquivoJava());
        }
        
    }


    private static void mostrarAjudaESair() {
        System.out.println(CABECALHO);
        System.out.println("Gera o codigo-fonte de uma classe Java com getters & setters.");
        System.out.println("Uso:\n\tGeraClasseJava NomeClasse tipo:nomeAtributo1 [tipo:nomeAtributo2 ...]");
        System.out.println("\tTipos: s=String, d=int, f=double, c=char");
        System.out.println("Exemplo:\n\tjava -jar GeraClasseJava.jar Funcionario s:nome d:anoNasc f:salario c:sexo");
        System.out.println();
        System.exit(0);
    }

  
}
