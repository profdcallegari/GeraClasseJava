
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
        assertEquals("MinhaClasse", classe.getIdentificador());
        assertEquals(0, classe.getQuantidadeAtributos());
        assertEquals("public class MinhaClasse {\n", classe.gerarInicioClasse());
        assertEquals("}\n", classe.gerarFimClasse());
    }

    @Test
    public void testUmAtributoEConstrutor() {
        Classe classe = new Classe("Veiculo");
        classe.adicionarAtributo("placa", 's');
        assertEquals("Veiculo", classe.getIdentificador());
        assertEquals(1, classe.getQuantidadeAtributos());
        String construtorGerado = classe.gerarConstrutor();
        assertEquals("\tpublic Veiculo (String placa) {\n\t\tthis.setPlaca(placa);\n\t}\n", construtorGerado);
    }

    
}
