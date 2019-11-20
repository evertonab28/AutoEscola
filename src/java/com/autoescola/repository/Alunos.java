package com.autoescola.repository;

import com.autoescola.model.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Alunos implements Serializable{
    private EntityManager em;

    public Alunos() {
    }

    public Alunos(EntityManager em) {
        this.em = em;
    }
    
    public Aluno porId(Long id){
        return em.find(Aluno.class, id);
    }
    
    public List<Aluno> pesquisar(String nome){
        String sql = "from Aluno where nome like :nome";
        TypedQuery<Aluno> query = em.createQuery(sql, Aluno.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();               
    }
    
    public Aluno salvar(Aluno aluno){
        return em.merge(aluno);
    }
    
    public void excluir(Aluno aluno){
        aluno = porId(aluno.getId());
        em.remove(aluno);
    }
}
