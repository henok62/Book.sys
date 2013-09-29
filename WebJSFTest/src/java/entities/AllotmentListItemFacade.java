package entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AllotmentListItemFacade extends AbstractFacade<AllotmentListItem> {
    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AllotmentListItemFacade() {
        super(AllotmentListItem.class);
    }
}
