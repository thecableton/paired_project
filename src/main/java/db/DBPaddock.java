package db;

import models.dinosaurs.Dinosaur;
import models.enums.AgeType;
import models.enums.DietaryType;
import models.enums.HungerLevelType;
import models.paddocks.Paddock;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class DBPaddock {

    private static Session session;


    public static Double getAverageStomachLevelByPaddock(Paddock paddock) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Dinosaur.class);
        cr.add(Restrictions.eq("paddock", paddock));
        cr.setProjection(Projections.avg("stomach"));
        Double averageStomachLevel = (Double) cr.uniqueResult();
        return averageStomachLevel;
    }

    public static Double getAverageStrengthByPaddock(Paddock paddock) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Dinosaur.class);
        cr.add(Restrictions.eq("paddock", paddock));
        cr.setProjection(Projections.avg("defaultStrength"));
        Double averageStrength = (Double) cr.uniqueResult();
        return averageStrength;
    }

    public static List<Paddock> filterByCanVisit(){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Paddock.class);
        cr.add(Restrictions.eq("accessibleToVisitors", true));
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Paddock> result = cr.list();
        return result;
    }





}
