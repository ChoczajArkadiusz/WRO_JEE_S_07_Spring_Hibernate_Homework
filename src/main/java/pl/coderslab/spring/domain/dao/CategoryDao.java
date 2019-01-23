package pl.coderslab.spring.domain.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring.domain.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Category entity) {
        if (entity != null) {
            entityManager.persist(entity);
        }
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> loadAll() {
        Query query = entityManager.createQuery("SELECT b FROM Category b");
        return query.getResultList();
    }

    public void update(Category entity) {
        if (entity != null) {
            entityManager.merge(entity);
        }
    }

    public void delete(Category entity) {
        if (entity != null) {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        }
    }


}
