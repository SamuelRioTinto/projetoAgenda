package br.ufpb.dcx.ayla.agenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgendaAyla implements Agenda{

    private HashMap<String,Contato> contatos;
    private GravadorDeDados gravador;

    public AgendaAyla(){
        this.contatos=new HashMap<>();
        this.gravador=new GravadorDeDados();
    }

    public boolean cadastraContato(String nome,int dia,int mes){
        Contato contato=this.contatos.get(nome);
        if(contato!=null){
            return false;
        }else {
            Contato contatoACasdastrar=new Contato(nome, dia, mes);
            this.contatos.put(contatoACasdastrar.getNome(),contatoACasdastrar);
            return true;
        }

    }

    public Collection<Contato>pesquisaAniversariantes(int dia,int mes) {
        Collection<Contato> colesaoDeAniversarientes = new ArrayList<>();
        for (Contato a : this.contatos.values()) {
            if (a.getDiaAniversario()==dia && a.getMesAniversario()==mes){
                colesaoDeAniversarientes.add(a);
            }
        }
        return colesaoDeAniversarientes;
    }

    public boolean removeContato(String nome)throws ContatoInexistenteException{
        Contato contatoAchado=this.contatos.get(nome);
        if(contatoAchado!=null){
            contatos.remove(contatoAchado);
            return true;
        }else if(contatoAchado==null){
            throw new ContatoInexistenteException("o contato de nome:" + nome +" não existe");
        }
        return false;
    }

    public void salvarDados()throws IOException{
        gravador.salvarContatos(this.contatos);
    }

    public void recuperarDados()throws IOException{
        this.contatos=gravador.recuperarContatos();
    }

}
