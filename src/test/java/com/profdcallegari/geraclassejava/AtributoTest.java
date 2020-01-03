
package com.profdcallegari.geraclassejava;

import org.junit.Test;
import static org.junit.Assert.*;

public class AtributoTest {

    @Test
    public void testCasosBasicos() {
        final Atributo atributo = new Atributo("meuAtributoComNomeExtenso", 's');
        assertEquals("String", atributo.getTipoPorExtenso());
        assertEquals("meuAtributoComNomeExtenso", atributo.getIdentificador());
        assertEquals("MeuAtributoComNomeExtenso", atributo.getIdentificadorModificado());
        assertEquals("String meuAtributoComNomeExtenso", atributo.gerarTipo_Nome());
    }
      
    @Test
    public void testCaseString() {
        final Atributo atributo = new Atributo("meuAtributo", 's');
        assertEquals("meuAtributo", atributo.getIdentificador());
        assertEquals("String", atributo.getTipoPorExtenso());
        assertEquals("\tprivate String meuAtributo;\n", atributo.gerarDeclaracao());
        assertEquals("\tpublic String getMeuAtributo () {\n\t\treturn this.meuAtributo;\n\t}\n", atributo.gerarMetodoGet());
        assertEquals("\tpublic void setMeuAtributo (String meuAtributo) {\n\t\tthis.meuAtributo = meuAtributo;\n\t}\n", atributo.gerarMetodoSet());
    }

    @Test
    public void testCaseChar() {
        final Atributo atributo = new Atributo("atributoCaractere", 'c');
        assertEquals("char", atributo.getTipoPorExtenso());
        assertEquals("\tprivate char atributoCaractere;\n", atributo.gerarDeclaracao());
        assertEquals("\tpublic void setAtributoCaractere (char atributoCaractere) {\n\t\tthis.atributoCaractere = atributoCaractere;\n\t}\n", atributo.gerarMetodoSet());
    }

    @Test
    public void testCaseInt() {
        final Atributo atributo = new Atributo("idade", 'd');
        assertEquals("int", atributo.getTipoPorExtenso());
        assertEquals("\tprivate int idade;\n", atributo.gerarDeclaracao());
        assertEquals("\tpublic void setIdade (int idade) {\n\t\tthis.idade = idade;\n\t}\n", atributo.gerarMetodoSet());
    }

    @Test
    public void testCaseDouble() {
        final Atributo atributo = new Atributo("precoFinal", 'f');
        assertEquals("double", atributo.getTipoPorExtenso());
        assertEquals("\tprivate double precoFinal;\n", atributo.gerarDeclaracao());
        assertEquals("\tpublic void setPrecoFinal (double precoFinal) {\n\t\tthis.precoFinal = precoFinal;\n\t}\n", atributo.gerarMetodoSet());
    }

    @Test
    public void testCaseBoolean() {
        final Atributo atributo = new Atributo("ativo", 'b');
        assertEquals("boolean", atributo.getTipoPorExtenso());
        assertEquals("\tprivate boolean ativo;\n", atributo.gerarDeclaracao());
        assertEquals("\tpublic boolean isAtivo () {\n\t\treturn this.ativo;\n\t}\n", atributo.gerarMetodoGet());
        assertEquals("\tpublic void setAtivo (boolean ativo) {\n\t\tthis.ativo = ativo;\n\t}\n", atributo.gerarMetodoSet());
    }

    @Test
    public void testCaseTipoInvalido() {
        final Atributo atributo = new Atributo("atrTipoInvalido", 'x');
        assertEquals("TipoDesconhecido", atributo.getTipoPorExtenso()); // Comportamento padrao
        assertEquals("\tprivate TipoDesconhecido atrTipoInvalido;\n", atributo.gerarDeclaracao());
    }

}
