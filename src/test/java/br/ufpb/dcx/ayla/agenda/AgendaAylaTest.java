package br.ufpb.dcx.ayla.agenda;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaAylaTest {

    @Test
    public void testaCadastro(){
        AgendaAyla agenda=new AgendaAyla();
        boolean ContatoCadastrado=agenda.cadastraContato("samuel",11,9);
        assertFalse(ContatoCadastrado==false);
        assertTrue(ContatoCadastrado==true);
    }

    @Test
    public void testaPesquisa(){
        AgendaAyla agenda=new AgendaAyla();
        Collection<Contato>contatosAchados=agenda.pesquisaAniversariantes(11,9);
        assertTrue(contatosAchados.size()==0);
        agenda.cadastraContato("samuel",11,9);
        agenda.cadastraContato("roberto",11,9);
        contatosAchados=agenda.pesquisaAniversariantes(11,9);
        assertTrue(contatosAchados.size()==2);
        Contato samuel=new Contato("samuel",11,9);
        assertTrue(contatosAchados.contains(samuel));
        Contato roberto=new Contato("roberto",11,9);
        assertTrue(contatosAchados.contains(roberto));
    }

    @Test
    public void testaRemosao() throws ContatoInexistenteException {
        AgendaAyla agenda=new AgendaAyla();
        agenda.cadastraContato("rebeca",31,12);
        try{
            boolean remosao= agenda.removeContato("rebeca");
            assertTrue(remosao);
        }catch (ContatoInexistenteException e){
            fail("não deveria ter lansado esta exeção");
        }
    }
}
