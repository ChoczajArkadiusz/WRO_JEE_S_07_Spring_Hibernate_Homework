package pl.coderslab.spring.domain.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring.domain.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveAuthor(Author entity) {
        if (entity != null) {
            entityManager.persist(entity);
        }
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> loadAll() {
        Query query = entityManager.createQuery("SELECT b FROM Author b");
        return query.getResultList();
    }

    public void update(Author entity) {
        if (entity != null) {
            entityManager.merge(entity);
        }
    }

    public void delete(Author entity) {
        if (entity != null) {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        }
    }


}
