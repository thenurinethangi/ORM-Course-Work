package com.example.ormcoursework.dao.custom.impl;

import com.example.ormcoursework.config.FactoryConfiguration;
import com.example.ormcoursework.dao.custom.MedicalHistoryDAO;
import com.example.ormcoursework.entity.MedicalHistory;
import com.example.ormcoursework.entity.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MedicalHistoryDAOImpl implements MedicalHistoryDAO {

    @Override
    public String generateNewId() {

        Session session = FactoryConfiguration.getInstance().getSession();

        try{
            MedicalHistory medicalHistory = session.createQuery("from MedicalHistory order by medicalHistoryId desc", MedicalHistory.class).setMaxResults(1).uniqueResultOptional().orElse(null);

            if(medicalHistory==null){
                return "MH-000001";
            }

            String[] str = medicalHistory.getMedicalHistoryId().split("-");
            int idNo = Integer.parseInt(str[1]);
            idNo++;
            String newId = String.format("MH-%06d", idNo);
            return newId;

        } catch (Exception e) {
            e.printStackTrace();
            return "MH-000001";
        }
        finally {
            session.close();
        }
    }


    @Override
    public List<MedicalHistory> getAll() {

        Session session = FactoryConfiguration.getInstance().getSession();

        try{
            return session.createQuery("from MedicalHistory ", MedicalHistory.class).list();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        finally {
            session.close();
        }
    }


    @Override
    public boolean add(MedicalHistory medicalHistory) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.persist(medicalHistory);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean delete(MedicalHistory medicalHistory) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            MedicalHistory medicalHistory1 = session.get(MedicalHistory.class,medicalHistory.getMedicalHistoryId());

            if(medicalHistory1==null){
                return false;
            }

            session.remove(medicalHistory1);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean update(MedicalHistory medicalHistory) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.merge(medicalHistory);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public MedicalHistory search(String id) {
        return null;
    }
}


