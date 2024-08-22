package br.ufpb.dcx.ayla.agenda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContatoTest {

    @Test
    public void testaContrutor(){
        Contato contato1=new Contato("samuel",11,9);
        assertEquals("samuel",contato1.getNome());
        assertEquals(11,contato1.getDiaAniversario());
        assertEquals(9,contato1.getMesAniversario());
    }

}
