package com.autoescola.util;

import java.io.Serializable;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransacionalInterceptor implements Serializable{

    @Inject
    private EntityManager em; //Injetando o EntityManager

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction et = em.getTransaction();
        boolean criador = false;

        try {
            if (!et.isActive()) {
                //truque para fazer rollback no que já passou
                //caso contrario seria confirmado até operações sem transação
                et.begin();
                et.rollback();

                //Inicia a transação
                et.begin();
                criador = true;
            }

            return context.proceed();
        } catch (Exception e) {
            if (et != null && criador) {
                et.rollback();
            }
            throw e;
        } finally {
            if (et != null && et.isActive() && criador) {
                et.commit();
            }
        }
    }
}