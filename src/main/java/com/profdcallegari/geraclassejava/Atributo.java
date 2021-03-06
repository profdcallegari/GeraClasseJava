package com.profdcallegari.geraclassejava;

// Classe Atributo
public class Atributo {
    private String identificador;
    private char tipo;

    public Atributo(String idAtr, char tipoAtr) {
        this.identificador = idAtr.trim();

        // [Refactor] Usar tratamento de Excecoes
        if (!Identificador.isValido(identificador)) {
            System.err.printf("Identificador invalido: '%s'.\n", identificador);
            System.exit(1);
        }
        
        if ("sdfcb".contains(""+tipoAtr))
            this.tipo = tipoAtr;
        else
            this.tipo = '?';
        
    }

    public String getIdentificador() {
        return identificador;
    }
    
    public String getTipoPorExtenso () {
        switch (this.tipo) {
            case 's': return "String";
            case 'd': return "int";
            case 'f': return "double";
            case 'c': return "char";
            case 'b': return "boolean";
        }
        
        return "TipoDesconhecido";
    }
    
    public String gerarDeclaracao () {
        return "\tprivate " + getTipoPorExtenso() + " " + getIdentificador() + ";\n";
    }
    
    /**
     * Obtém identificador alterado contendo a primeira letra como maiúscula.
     * Ex: precoProduto -> PrecoProduto, para ser concatenado em gets e sets.
     * @return o identificador modificado
     */
    public String getIdentificadorModificado () {
        return this.identificador.toUpperCase().charAt(0) + this.identificador.substring(1);
    }
    
    public String gerarMetodoGet () {
        // Padrao: isAtributo para boolean e getAtributo para demais tipos
        String templateGet;
        if (this.tipo == 'b')
            templateGet = "\tpublic TIPORET isNOMEATRMOD () {\n\t\treturn this.NOMEATRIB;\n\t}\n";
        else
            templateGet = "\tpublic TIPORET getNOMEATRMOD () {\n\t\treturn this.NOMEATRIB;\n\t}\n";
        
        String corpoGet = templateGet
                .replace("TIPORET", getTipoPorExtenso())
                .replace("NOMEATRMOD", getIdentificadorModificado())
                .replace("NOMEATRIB", this.identificador);
        
        return corpoGet;
    }
    
    public String gerarMetodoSet () {
        String templateSet = "\tpublic void setNOMEATRMOD (TIPOATR NOMEATRIB) {\n\t\tthis.NOMEATRIB = NOMEATRIB;\n\t}\n";

        String corpoSet = templateSet
                .replace("NOMEATRMOD", getIdentificadorModificado())
                .replace("TIPOATR", this.getTipoPorExtenso())
                .replaceAll("NOMEATRIB", this.identificador);
        
        return corpoSet;
    }
    
    public String gerarTipo_Nome () {
        return this.getTipoPorExtenso() + " " + this.identificador;
    }
    
}
