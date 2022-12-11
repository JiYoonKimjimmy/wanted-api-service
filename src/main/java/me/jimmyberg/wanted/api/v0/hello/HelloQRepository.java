package me.jimmyberg.wanted.api.v0.hello;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface HelloQRepository {

    List<Hello> findAllByText(String text);

    class HelloQRepositoryImpl implements HelloQRepository {

        @Autowired
        private JPAQueryFactory queryFactory;

        @Override
        public List<Hello> findAllByText(String text) {
            QHello entity = QHello.hello;
            return queryFactory
                    .selectFrom(entity)
                    .where(entity.text.eq(text))
                    .fetch();
        }

    }

}
