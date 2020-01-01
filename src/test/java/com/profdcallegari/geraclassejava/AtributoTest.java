
package com.profdcallegari.geraclassejava;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AtributoTest {
    
    private Atributo meuAtributoString = new Atributo("meuAtributo", 's');
    private Atributo meuAtributoChar = new Atributo("MeuAtributo", 'c');
    private Atributo meuAtributoInt = new Atributo("idade", 'd');
    private Atributo meuAtributoDouble = new Atributo("salarioAtualDescontado", 'f');
    
    @Test
    public void testCaseStrings() {
        Atributo instance = new Atributo("meuAtributo", 's');
        assertEquals(instance.getIdentificador(), "meuAtributo");
        assertEquals(instance.getTipoPorExtenso(), "String");
        assertEquals(instance.gerarDeclaracao(), "\tprivate String meuAtributo;\n");
        assertEquals(instance.gerarMetodoGet(), "\tpublic String getMeuAtributo () {\n\t\treturn this.meuAtributo;\n\t}\n");
        assertEquals(instance.gerarMetodoSet(), "\tpublic void setMeuAtributo (String meuAtributo) {\n\t\tthis.meuAtributo = meuAtributo;\n\t}\n");
        
    }

}
