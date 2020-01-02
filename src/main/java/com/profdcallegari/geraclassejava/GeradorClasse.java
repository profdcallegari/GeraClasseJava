package com.profdcallegari.geraclassejava;

import java.io.*;

public class GeradorClasse {

    public static void gerarClasse(String[] args) {
        // Obtém o nome da classe a gerar
        String nomeClasse = args[0];                    // o primeiro argumento é a classe
        Classe novaClasse = new Classe(nomeClasse);

        // Obtém os atributos (deve existir pelo menos um)
        for (int i = 1; i < args.length; i++) {
            String sAtributo = args[i];                 // tipo:nomeAtributo

            char tipoAtributo = sAtributo.charAt(0);    // deve ser 's', 'c', 'd' ou 'f'
            //char doisPontos = sAtributo.charAt(1);    // pressupoe que o segundo caractere é ':'
            String idAtributo = sAtributo.substring(2); // nome (identificador) do atributo

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
            bw.write(GeraClasseJava.CABECALHO);
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

}