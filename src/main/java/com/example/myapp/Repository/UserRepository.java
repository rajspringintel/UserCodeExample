package com.example.myapp.Repository;
import com.example.myapp.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Transactional
@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUser(){
        String hqlQuery = "From Company";
        List<User> data = entityManager.createQuery(hqlQuery).getResultList();
        return data;
    }

    public boolean addUser(User user){
        entityManager.persist(user);
        return true;
    }

    public User getCompanyByCode(String code){
        String hqlQuery = "From user as c where c.companyCode=?1";
        User result = (User) entityManager.createQuery(hqlQuery).setParameter(1,code).getSingleResult();
        return result;

    }

//   public List<User> mergeUserComCode(String company_code){
//       String hqlQuery =" select id||''||company_code as User_Comp_code from tuser u";
//       List<User> data = entityManager.createQuery(hqlQuery).getResultList();
//      return  data;
//   }

    public boolean updateUser(User user){

        try{
            User updatedCompany = entityManager.find(User.class,user.getCompanyCode());
            updatedCompany.setEmail_id(user.getEmail_id());
            updatedCompany.setUser_name(user.getUser_name());
            updatedCompany.setFirst_name(user.getFirst_name());
            updatedCompany.setLast_name(user.getLast_name());
            updatedCompany.setPassword(user.getPassword());
            updatedCompany.setCreatedDate(user.getCreatedDate());
            updatedCompany.setCreatedBy(user.getCreatedBy());
            updatedCompany.setUpdatedBy(user.getUpdatedBy());
            updatedCompany.setUpdatedDate(user.getUpdatedDate());
            entityManager.flush();
            return true;
        }catch(Exception e){
            return  false;
        }


    }

    public boolean deleteUser(String code){
        try{
            User U = entityManager.find(User.class,code);

            entityManager.remove(U);

        }catch (Exception e){
            return false;

        }
        return true;
    }

        


}
