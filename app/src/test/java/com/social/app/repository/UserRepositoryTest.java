package com.social.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.social.app.entity.User;
import java.util.List;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void shouldBeAudited() {
        User user = getTestUser();
        testEntityManager.persistAndFlush(user);

        user.setPassword("tset");
        testEntityManager.merge(user);

        // This line is critical here to commit transaction and trigger audit logs
        testEntityManager.getEntityManager().getTransaction().commit();

        // With propagation = NOT_SUPPORTED this doesn't work: testEntityManager.getEntityManager()
        AuditReader auditReader = AuditReaderFactory.get(testEntityManager.getEntityManager());
        List revisions = auditReader.createQuery()
            .forRevisionsOfEntity(User.class, true)
            .add(AuditEntity.id().eq(user.getId()))
            .getResultList();

        assertEquals(1, revisions.size());
    }

    private User getTestUser() {
        User user = new User();
        user.setPhone("test");
        user.setPassword("test");
        return user;
    }

}
