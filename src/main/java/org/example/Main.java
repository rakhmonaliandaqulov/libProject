package org.example;

import org.example.config.Config;
import org.example.dto.LessonDto;
import org.example.repository.LessonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        LessonRepository lessonRepository = (LessonRepository) context.getBean("lessonRepository");

        LessonDto lessonDTO = new LessonDto();
        lessonDTO.setName("Java");
        lessonDTO.setSurname("Javayev");

      //  lessonRepository.create(lessonDTO);
        //lessonRepository.create(lessonDTO);
        //System.out.println(lessonRepository.count());
        //System.out.println(lessonRepository.nameOne());
        //System.out.println(lessonRepository.getLessonById(1));
        //System.out.println(lessonRepository.getLessonNameList());
        //System.out.println(lessonRepository.getLessonByIdTest(1));
        System.out.println(lessonRepository.getStudentBookInfoList());
        System.out.println(lessonRepository.);
    }
}