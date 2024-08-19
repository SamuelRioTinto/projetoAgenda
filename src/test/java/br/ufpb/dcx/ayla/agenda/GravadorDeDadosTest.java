package br.ufpb.dcx.ayla.agenda;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class GravadorDeDadosTest {

    @Test
    public void testaGravasao() throws IOException {
        File arquivoContatos=new File(GravadorDeDados.ARQUIVO_CONTATOS);
        if(arquivoContatos.exists()){
            arquivoContatos.delete();
        }
        GravadorDeDados gravadorDeDados=new GravadorDeDados();
        File arquivo=new File(GravadorDeDados.ARQUIVO_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap<String,Contato>contatosMap=new HashMap<>();
        contatosMap.put("samuel",new Contato("samuel",11,9));
        gravadorDeDados.salvarContatos(contatosMap);
        assertTrue(arquivo.exists());
        arquivo.delete();
    }

    @Test
    public void testaRecuperao() throws IOException {
        File arquivoContatos=new File(GravadorDeDados.ARQUIVO_CONTATOS);
        if(arquivoContatos.exists()){
            arquivoContatos.delete();
        }
        GravadorDeDados gravadorDeDados=new GravadorDeDados();
        File arquivo=new File(GravadorDeDados.ARQUIVO_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap<String,Contato>contatosMap=new HashMap<>();
        contatosMap.put("samuel",new Contato("samuel",11,9));
        gravadorDeDados.salvarContatos(contatosMap);
        assertTrue(arquivo.exists());
        HashMap<String,Contato>contatosRecuperados=gravadorDeDados.recuperarContatos();
        Contato contato1=contatosRecuperados.get("samuel");
        assertEquals(11,contato1.getDiaAniversario());
        assertEquals(9,contato1.getMesAniversario());
        assertEquals("samuel",contato1.getNome());
        arquivo.delete();
    }
}
