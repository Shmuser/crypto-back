package vsu.labs.crypto.entity.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vsu.labs.crypto.config.IntegrationTest;
import vsu.labs.crypto.entity.JpaRepository.CourseRepository;
import vsu.labs.crypto.entity.JpaRepository.CourseThemesRepository;
import vsu.labs.crypto.entity.JpaRepository.RoleRepository;
import vsu.labs.crypto.entity.JpaRepository.UserRepository;
import vsu.labs.crypto.entity.security.RoleEntity;
import vsu.labs.crypto.entity.security.UserEntity;
import vsu.labs.crypto.enums.RoleType;

import java.util.ArrayList;
import java.util.List;


public class CourseEntityTest extends IntegrationTest {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseThemesRepository courseThemesRepository;
    @Test
    public void name() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(RoleType.STUDENT);
        RoleEntity roleSaved = roleRepository.save(roleEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setLogin("trololo");
        userEntity.setName("troll");
        userEntity.setPassword("trolololol");
        userEntity.setRoleId(roleSaved.getId());
        userEntity.setSurname("lol");
        UserEntity userSaved = userRepository.save(userEntity);

        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName("first");
        courseEntity.getUsers().add(userEntity);
        CourseEntity courseSaved = courseRepository.save(courseEntity);

        CourseThemesEntity courseThemesEntity = new CourseThemesEntity();
        courseThemesEntity.setName("asdf");
        courseThemesEntity.setReference("asdf");
        courseThemesEntity.setCourse(courseSaved);
        CourseThemesEntity savedCourseThemes = courseThemesRepository.save(courseThemesEntity);

        courseThemesRepository.delete(savedCourseThemes);
        courseRepository.delete(courseSaved);
        userRepository.delete(userSaved);
        roleRepository.delete(roleSaved);


    }
}