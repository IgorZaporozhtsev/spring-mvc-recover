package com.zeecoder.repository;

import com.zeecoder.model.Account;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AccountDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Account> getAll(){
        return entityManager.createQuery("select a from Account a", Account.class).getResultList();
    }

    public void add(Account account) {
        entityManager.merge(account);
    }

    public Account getOne(Long id) {
        return entityManager.find(Account.class, id);
    }

    public void update(Account account) {
        entityManager.merge(account);
    }

    public void delete(Long id) {
        Account derivedAccount = entityManager.getReference(Account.class, id);
        entityManager.remove(derivedAccount);
    }
}
