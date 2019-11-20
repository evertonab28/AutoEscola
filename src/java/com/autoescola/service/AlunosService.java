package com.autoescola.service;

import com.autoescola.model.Aluno;
import com.autoescola.repository.Alunos;
import com.autoescola.util.Transacional;
import java.io.Serializable;
import javax.inject.Inject;

public class AlunosService implements Serializable{
    @Inject
    private Alunos alunos;
    
    @Transacional
    public void salvar(Aluno aluno){
        alunos.salvar(aluno);
    }
    
    @Transacional
    public void excluir(Aluno aluno){
        alunos.excluir(aluno);
    }
}
