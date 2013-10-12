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
public class TourFacade extends AbstractFacade<Tour> {
    @PersistenceContext(unitName = "BookingSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TourFacade() {
        super(Tour.class);
    }
    
}
