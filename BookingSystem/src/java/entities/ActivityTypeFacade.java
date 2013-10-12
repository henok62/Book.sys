/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mikael
 */
@Stateless
public class ActivityTypeFacade extends AbstractFacade<ActivityType> {
    @PersistenceContext(unitName = "BookingSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivityTypeFacade() {
        super(ActivityType.class);
    }
    
}
