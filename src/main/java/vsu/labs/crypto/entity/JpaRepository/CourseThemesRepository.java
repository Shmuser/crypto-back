package vsu.labs.crypto.entity.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import vsu.labs.crypto.entity.test.CourseThemesEntity;

public interface CourseThemesRepository extends JpaRepository<CourseThemesEntity, Long> {
}