package vsu.labs.crypto.entity.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import vsu.labs.crypto.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}