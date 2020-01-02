
package com.profdcallegari.geraclassejava;

import org.junit.Test;
import static org.junit.Assert.*;

public class AtributoTest {

    @Test
    public void testCasosBasicos() {
        final Atributo atributo = new Atributo("meuAtributoComNomeExtenso", 's');
        assertEquals(atributo.getTipoPorExtenso(), "String");
        assertEquals(atributo.getIdentificador(), "meuAtributoComNomeExtenso");
        assertEquals(atributo.getIdentificadorModificado(), "MeuAtributoComNomeExtenso");
        assertEquals(atributo.gerarTipo_Nome(), "String meuAtributoComNomeExtenso");
    }
      
    @Test
    public void testCaseString() {
        final Atributo atributo = new Atributo("meuAtributo", 's');
        assertEquals(atributo.getIdentificador(), "meuAtributo");
        assertEquals(atributo.getTipoPorExtenso(), "String");
        assertEquals(atributo.gerarDeclaracao(), "\tprivate String meuAtributo;\n");
        assertEquals(atributo.gerarMetodoGet(), "\tpublic String getMeuAtributo () {\n\t\treturn this.meuAtributo;\n\t}\n");
        assertEquals(atributo.gerarMetodoSet(), "\tpublic void setMeuAtributo (String meuAtributo) {\n\t\tthis.meuAtributo = meuAtributo;\n\t}\n");
    }

    @Test
    public void testCaseChar() {
        final Atributo atributo = new Atributo("atributoCaractere", 'c');
        assertEquals(atributo.getTipoPorExtenso(), "char");
        assertEquals(atributo.gerarDeclaracao(), "\tprivate char atributoCaractere;\n");
        assertEquals(atributo.gerarMetodoSet(), "\tpublic void setAtributoCaractere (char atributoCaractere) {\n\t\tthis.atributoCaractere = atributoCaractere;\n\t}\n");
    }

    @Test
    public void testCaseInt() {
        final Atributo atributo = new Atributo("idade", 'd');
        assertEquals(atributo.getTipoPorExtenso(), "int");
        assertEquals(atributo.gerarDeclaracao(), "\tprivate int idade;\n");
        assertEquals(atributo.gerarMetodoSet(), "\tpublic void setIdade (int idade) {\n\t\tthis.idade = idade;\n\t}\n");
    }

    @Test
    public void testCaseDouble() {
        final Atributo atributo = new Atributo("precoFinal", 'f');
        assertEquals(atributo.getTipoPorExtenso(), "double");
        assertEquals(atributo.gerarDeclaracao(), "\tprivate double precoFinal;\n");
        assertEquals(atributo.gerarMetodoSet(), "\tpublic void setPrecoFinal (double precoFinal) {\n\t\tthis.precoFinal = precoFinal;\n\t}\n");
    }

    @Test
    public void testCaseBoolean() {
        final Atributo atributo = new Atributo("ativo", 'b');
        assertEquals(atributo.getTipoPorExtenso(), "boolean");
        assertEquals(atributo.gerarDeclaracao(), "\tprivate boolean ativo;\n");
        assertEquals(atributo.gerarMetodoGet(), "\tpublic boolean isAtivo () {\n\t\treturn this.ativo;\n\t}\n");
        assertEquals(atributo.gerarMetodoSet(), "\tpublic void setAtivo (boolean ativo) {\n\t\tthis.ativo = ativo;\n\t}\n");
    }

    @Test
    public void testCaseTipoInvalido() {
        final Atributo atributo = new Atributo("atrTipoInvalido", 'x');
        assertEquals(atributo.getTipoPorExtenso(), "TipoDesconhecido"); // Comportamento padrao
        assertEquals(atributo.gerarDeclaracao(), "\tprivate TipoDesconhecido atrTipoInvalido;\n");
    }

}
