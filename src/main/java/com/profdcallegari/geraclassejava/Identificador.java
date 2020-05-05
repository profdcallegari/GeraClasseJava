package com.profdcallegari.geraclassejava;

/**
 * Por enquanto, serve apenas para impedir o uso de palavras-chave reservadas ou proibidas em Java.
 * Depois, refatorar demais classes para utilizar a nova classe Identificador.
 */
public class Identificador {
    private static final String[] idsInvalidos = {
        "abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package",
        "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements",
        "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof",
        "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface",
        "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native",
        "super", "while", "true", "false", "null", "var", "String"
    };

    // Lógica simplificada (porém incompleta): basta não ser uma palavra reservada nem iniciar com um dígito
    public static boolean isValido (String id) {
        // Não pode ser nulo
        if (id==null)
            return false;
        
        // Não pode ser string vazia
        if (id.length() == 0)
            return false;

        // Não pode iniciar com um dígito
        char primeiroChar = id.charAt(0);
        if (primeiroChar >= '0' && primeiroChar <= '9')
            return false;

        // Não pode estar na lista de ids inválidos
        for (String idInvalido : idsInvalidos) {
            if (id.equals(idInvalido))
                return false;
        }

        // Embora a lógica ainda esteja incompleta, vamos assumir que o id é válido por enquanto.
        return true;
    }
}