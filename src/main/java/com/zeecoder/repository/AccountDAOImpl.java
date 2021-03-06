package com.zeecoder.repository;

import com.zeecoder.model.Account;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Account> getAll(){
        return entityManager.createQuery("select a from Account a", Account.class).getResultList();
    }

    public void add(Account account) {
        try {
            entityManager.persist(account);
        } catch (ConstraintViolationException ex){
            System.out.println("This name is already used, please choose another one!");
        }
    }

    public Account getOne(Long id) {
        return entityManager.find(Account.class, id);
    }

    public void update(Account account) {
        entityManager.unwrap(Session.class).update(account);
    }

    public void delete(Long id) {
        Account derivedAccount = entityManager.getReference(Account.class, id);
        entityManager.remove(derivedAccount);
    }

    @Override
    public Account findByName(String nickname) {
        return (Account) entityManager.createQuery("select a from Account a where a.nickname = :nickname")
                .setParameter("nickname", nickname)
                .getSingleResult();

    }
}
