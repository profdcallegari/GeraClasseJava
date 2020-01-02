
package com.profdcallegari.geraclassejava;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClasseTest {
    
    public ClasseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCasosBasicos() {
        Classe classe = new Classe("MinhaClasse");
        assertEquals(classe.getIdentificador(), "MinhaClasse");
        assertEquals(classe.getQuantidadeAtributos(), 0);
        assertEquals(classe.gerarInicioClasse(), "public class MinhaClasse {\n");
        assertEquals(classe.gerarFimClasse(), "}\n");
    }

    @Test
    public void testUmAtributoEConstrutor() {
        Classe classe = new Classe("Veiculo");
        classe.adicionarAtributo("placa", 's');
        assertEquals(classe.getIdentificador(), "Veiculo");
        assertEquals(classe.getQuantidadeAtributos(), 1);
        String construtorGerado = classe.gerarConstrutor();
        assertEquals(construtorGerado, "\tpublic Veiculo (String placa) {\n\t\tthis.setPlaca(placa);\n\t}\n");
    }

    
}
