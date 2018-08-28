package db;

import models.paddocks.Paddock;
import models.visitors.Visit;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBVisit {
    private static Session session;

    public static void addPaddockToVisit(Visit visit, Paddock paddock) {
        visit.addPaddockToVisit(paddock);
        paddock.addVisitToPaddock(visit);
        DBHelper.update(visit);
    }

    public static List<Paddock> getAllPaddocksForVisit(Visit visit) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Paddock> paddocks = null;
        Criteria cr = session.createCriteria(Paddock.class);
        cr.createAlias("visits", "visit");
        cr.add(Restrictions.eq("visit.id", visit.getId()));
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        paddocks = cr.list();
        return paddocks;
    }
}
