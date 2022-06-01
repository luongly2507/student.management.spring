package student.management.spring.app.data;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import student.management.spring.app.entities.Clazz;
import student.management.spring.app.entities.Grade;
import student.management.spring.app.entities.Regulation;
import student.management.spring.app.entities.Role;
import student.management.spring.app.entities.Semester;
import student.management.spring.app.entities.User;
import student.management.spring.app.repositories.ClazzRepository;
import student.management.spring.app.repositories.GradeRepository;
import student.management.spring.app.repositories.RegulationRepository;
import student.management.spring.app.repositories.RoleRepository;
import student.management.spring.app.repositories.SemesterRepository;
import student.management.spring.app.repositories.UserRepository;

@Transactional
@Component
public class DataInitialize implements CommandLineRunner {

    @Autowired
    SemesterRepository semesterRepository;

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    ClazzRepository clazzRepository;

    @Autowired
    RegulationRepository regulationRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    private void initRole() {
        roleRepository.saveAll(
                        Arrays.asList(
                                        Role.builder()
                                                        .name("ROLE_USER")
                                                        .build(),
                                        Role.builder()
                                                        .name("ROLE_TEACHER")
                                                        .build(),
                                        Role.builder()
                                                        .name("ROLE_PRINCIPAL")
                                                        .build(),
                                        Role.builder()
                                                        .name("ROLE_HR")
                                                        .build()));
}

private void initUser() {
        userRepository.saveAll(
                        Arrays.asList(
                                        User.builder()
                                                        .email("teacherA@gmail.com")
                                                        .password(passwordEncoder.encode("12345678"))
                                                        .fullName("Teacher A")
                                                        .roles(Arrays.asList(roleRepository
                                                                        .findByName("ROLE_TEACHER").get()))
                                                        .build(),
                                        User.builder()
                                                        .email("teacherB@gmail.com")
                                                        .password(passwordEncoder.encode("12345678"))
                                                        .fullName("Teacher B")
                                                        .roles(Arrays.asList(roleRepository
                                                                        .findByName("ROLE_TEACHER").get()))
                                                        .build(),
                                        User.builder()
                                                        .email("hrA@gmail.com")
                                                        .password(passwordEncoder.encode("12345678"))
                                                        .fullName("Human Resource A")
                                                        .roles(Arrays.asList(roleRepository
                                                                        .findByName("ROLE_HR").get()))
                                                        .build(),
                                        User.builder()
                                                        .email("hrB@gmail.com")
                                                        .password(passwordEncoder.encode("12345678"))
                                                        .fullName("Human Resource B")
                                                        .roles(Arrays.asList(roleRepository
                                                                        .findByName("ROLE_HR").get()))
                                                        .build(),
                                        User.builder()
                                                        .email("principalA@gmail.com")
                                                        .password(passwordEncoder.encode("12345678"))
                                                        .fullName("Principal A")
                                                        .roles(Arrays.asList(roleRepository
                                                                        .findByName("ROLE_PRINCIPAL").get()))
                                                        .build()));
}
    private void initSemester() {
        semesterRepository.saveAll(
                Arrays.asList(
                        Semester.builder()
                                .name("Học kì I năm học 2018-2019")
                                .build(),
                        Semester.builder()
                                .name("Học kì II năm học 2018-2019")
                                .build(),
                        Semester.builder()
                                .name("Học kì I năm học 2019-2020")
                                .build(),
                        Semester.builder()
                                .name("Học kì II năm học 2019-2020")
                                .build(),
                        Semester.builder()
                                .name("Học kì I năm học 2020-2021")
                                .build(),
                        Semester.builder()
                                .name("Học kì II năm học 2020-2021")
                                .build(),
                        Semester.builder()
                                .name("Học kì I năm học 2021-2022")
                                .build(),
                        Semester.builder()
                                .name("Học kì II năm học 2021-2022")
                                .build()

                ));
    }

    private void initGrade() {

        gradeRepository.saveAll(
                Arrays.asList(
                        Grade.builder()
                                .name("10")
                                .build(),
                        Grade.builder()
                                .name("11")
                                .build(),
                        Grade.builder()
                                .name("12")
                                .build()

                ));
    }

    private void initClass() {
        clazzRepository.saveAll(
                Arrays.asList(
                        Clazz.builder()
                                .name("A1")
                                .grade(gradeRepository.findByName("10").get())
                                .build(),
                        Clazz.builder()
                                .name("A2")
                                .grade(gradeRepository.findByName("10").get())
                                .build(),
                        Clazz.builder()
                                .name("A3")
                                .grade(gradeRepository.findByName("10").get())
                                .build(),
                        Clazz.builder()
                                .name("A4")
                                .grade(gradeRepository.findByName("10").get())
                                .build(),
                        Clazz.builder()
                                .name("A1")
                                .grade(gradeRepository.findByName("11").get())
                                .build(),
                        Clazz.builder()
                                .name("A2")
                                .grade(gradeRepository.findByName("11").get())
                                .build(),
                        Clazz.builder()
                                .name("A3")
                                .grade(gradeRepository.findByName("11").get())
                                .build(),
                        Clazz.builder()
                                .name("A4")
                                .grade(gradeRepository.findByName("11").get())
                                .build(),
                        Clazz.builder()
                                .name("A1")
                                .grade(gradeRepository.findByName("12").get())
                                .build(),
                        Clazz.builder()
                                .name("A2")
                                .grade(gradeRepository.findByName("12").get())
                                .build(),
                        Clazz.builder()
                                .name("A3")
                                .grade(gradeRepository.findByName("12").get())
                                .build(),
                        Clazz.builder()
                                .name("A4")
                                .grade(gradeRepository.findByName("12").get())
                                .build()

                ));
    }

    public void initRegulation() {
        regulationRepository.saveAll(
                Arrays.asList(
                        Regulation.builder()
                                .name("minAge")
                                .value("15")
                                .build(),
                        Regulation.builder()
                                .name("maxAge")
                                .value("20")
                                .build(),
                        Regulation.builder()
                                .name("passScore")
                                .value("5")
                                .build(),
                        Regulation.builder()
                                .name("classCount")
                                .value("40")
                                .build()

                ));
    }

    @Override
    public void run(String... args) throws Exception {
        initRole();
        initUser();
        initSemester();
        initGrade();
        initClass();
        initRegulation();
    }

}
