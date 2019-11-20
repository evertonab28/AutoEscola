package com.autoescola.repository;

import com.autoescola.model.Aluno;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCamadaDePersistencia {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoescola");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        //INSTANCIAR OS REPOSITORIOS
        Alunos alunos = new Alunos(em);
        
        //Listar os alunos
        List<Aluno> listaAlunos = alunos.pesquisar("");
        System.out.println(listaAlunos);
        
        //Criar um Aluno
        Aluno a = new Aluno();
        a.setNome("Anakin");
        a.setRG("1234");
        a.setCPF("5678");
        a.setTelefone("3461-6666");
        a.setEmail("ani@mail.com");
        a.setDataNascimento(new Date(1999-12-21));
        a.setEndereco("Rua Jedi, 28");
        
        //Salvar o Aluno
        alunos.salvar(a);
        
        em.getTransaction().commit();
        
        List<Aluno> lista = em.createQuery("from Aluno", Aluno.class).getResultList();
        System.out.println(lista);
        
        em.close();
        emf.close();
    }
}
