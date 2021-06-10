package db.ktx.repository;

import db.ktx.entity.PageType;
import db.ktx.entity.staticPageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagetypeRepository extends JpaRepository<PageType, Integer> {

    PageType findByType(staticPageType type);

}
