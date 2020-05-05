package com.profdcallegari.geraclassejava;

import org.junit.Test;
import static org.junit.Assert.*;

public class IdentificadorTest {

    @Test
    public void deveAceitarIds () {
        final String[] validos = {
            "id",
            "a1",
            "_var",
            "MAIUSC",
            "camelCase"
        };

        for (String id : validos) {
            assertTrue(Identificador.isValido(id));
        }
    }

    @Test
    public void deveRejeitarIds () {
        final String[] invalidos = {
            "1",
            "99nome",
            "final",
            "double",
            "String",
            "true",
            "int",
            "null"
        };

        for (String nonid : invalidos) {
            assertFalse(Identificador.isValido(nonid));
        }
    }

}