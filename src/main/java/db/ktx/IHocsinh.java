package db.ktx;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IHocsinh extends JpaRepository<Hocsinh, String> {
}
