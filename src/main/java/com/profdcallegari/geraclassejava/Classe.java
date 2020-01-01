package com.profdcallegari.geraclassejava;

import java.util.ArrayList;
import java.util.List;


public class Classe {
    private String identificador;
    private List<Atributo> atributos;

    public Classe(String identificador) {
        if (identificador != null && identificador.length() > 0)
            this.identificador = identificador.trim();
        else
            this.identificador = "NOMECLASSE";
        
        atributos = new ArrayList<>();
    }

    public String getIdentificador() {
        return identificador;
    }
    
    public int getQuantidadeAtributos () {
        return atributos.size();
    }
    
    public String getNomeArquivoJava() {
        return identificador + ".java";
    }
    
    public void adicionarAtributo (String idAtr, char tipoAtr) {
        Atributo atributo = new Atributo(idAtr, tipoAtr);
        atributos.add(atributo);
    }
      
    public String gerarInicioClasse () {
        String template = "public class NOMECLASSE {\n";
        return template.replace("NOMECLASSE", getIdentificador());
    }
    
    public String gerarFimClasse () {
        return "}\n";
    }
    
    public String gerarDeclaracaoAtributos () {
        StringBuilder strAtr = new StringBuilder();
        
        strAtr.append("\n");

        for (Atributo atributo : atributos) {
            strAtr.append(atributo.gerarDeclaracao());
        }

        strAtr.append("\n");
        
        return strAtr.toString();
    }
    
    public String gerarConstrutor () {
        StringBuilder strConstrutor = new StringBuilder();
        
        strConstrutor.append("\tpublic ");
        strConstrutor.append(this.getIdentificador());
        strConstrutor.append(" (");
        
        // lista de atributos separados por vírgula
        // percorre com for indexado para controlar as vírgulas entre os atributos
        int nroAtributos = this.atributos.size();
        for (int i = 0; i < nroAtributos; i++) {
            Atributo atributo = this.atributos.get(i);
            
            strConstrutor.append(atributo.gerarTipo_Nome());
            
            if (i < nroAtributos-1) { // evita a última vírgula
                strConstrutor.append(", ");
            }
        }
        
        strConstrutor.append(") {");
        strConstrutor.append("\n");
        
        // chamar os metodos set dentro do construtor
        for (Atributo atributo : atributos) {
            strConstrutor.append("\t\tthis.set");
            strConstrutor.append(atributo.getIdentificadorModificado());
            strConstrutor.append("(");
            strConstrutor.append(atributo.getIdentificador());
            strConstrutor.append(");\n");
        }
        
        strConstrutor.append("\t}\n");
        
        return strConstrutor.toString();
    }
    
     public String gerarMetodosGetSet () {
        StringBuilder strMetodos = new StringBuilder();
    
        strMetodos.append("\n");

        // Primeiro os metodos Get
        for (Atributo atributo : atributos) {
            strMetodos.append(atributo.gerarMetodoGet());
            strMetodos.append("\n");
        }
        
        // Depois os metodos Set
        for (Atributo atributo : atributos) {
            strMetodos.append(atributo.gerarMetodoSet());
            strMetodos.append("\n");
        }

        return strMetodos.toString();
     }
}
