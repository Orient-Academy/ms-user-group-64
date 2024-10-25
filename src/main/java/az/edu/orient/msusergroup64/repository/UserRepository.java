package az.edu.orient.msusergroup64.repository;

import az.edu.orient.msusergroup64.entity.UserEntity;
import az.edu.orient.msusergroup64.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
    UserEntity findByIdAndStatus(Long id, Status status);
    List<UserEntity> findAllByStatus(Status status);
}
