package vsu.labs.crypto.entity.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import vsu.labs.crypto.entity.test.MarkEntity;

public interface MarkRepository extends JpaRepository<MarkEntity,Long> {
}
