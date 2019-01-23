package pl.coderslab.spring.domain.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring.domain.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

@Component
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article entity) {
        if (entity != null) {
            entity.setCreated(new Timestamp(System.currentTimeMillis()));
            entityManager.persist(entity);
        }
    }

    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }

    public List<Article> loadAll() {
        Query query = entityManager.createQuery("SELECT b FROM Article b");
        return query.getResultList();
    }

    public List<Article> loadNewest(int quantity) {
        Query query = entityManager.createQuery("SELECT b FROM Article b ORDER BY b.created DESC");
        return query.setMaxResults(quantity).getResultList();
    }

    public void update(Article entity) {
        if (entity != null) {
            entity.setUpdated(new Timestamp(System.currentTimeMillis()));
            entityManager.merge(entity);
        }
    }

    public void delete(Article entity) {
        if (entity != null) {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        }
    }


}
