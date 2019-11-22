package com.autoescola.bean;

import com.autoescola.model.Aluno;
import com.autoescola.repository.Alunos;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class AlunoBean implements Serializable {

    @Inject
    private Alunos alunos;
    private List<Aluno> listaDeAlunos;
    
    public void todosOsAlunos(){
        listaDeAlunos = alunos.pesquisar("");        
    }
    
    public List<Aluno> getListaDeAlunos(){
        return listaDeAlunos;
    }
}
