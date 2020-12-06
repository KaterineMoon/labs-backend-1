package co.edu.unal.software_engineering.labs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.unal.software_engineering.labs.model.Course;
import co.edu.unal.software_engineering.labs.pojo.CoursePOJO;
import co.edu.unal.software_engineering.labs.service.CourseService;

@SpringBootTest
class CourseTests{
  
@Autowired
CourseService courseService;


@Test
void findByIdTests(){

    Course course = new Course();

    course.setCourseName("Curso de prueba");
    course.setDurationHours(123);

    courseService.save(course);

    Course courseSaved = courseService.findById(1);

    assertNotNull( courseSaved );
    assertNotNull( courseSaved.getCourseName());
    assertNotNull( courseSaved.getDurationHours());

    assertEquals( 1, course.getId());
}

@Test
void saveTests(){



    Course course = new Course();

    course.setCourseName("Curso de prueba");
    course.setDurationHours(123);

    courseService.save(course);

    Course courseSaved = new Course();
    courseSaved = courseService.findById(1);

    assertNotNull( courseSaved );
    assertNotNull( courseSaved.getCourseName());
    assertNotNull( courseSaved.getDurationHours());

    assertEquals( course.getCourseName(), courseSaved.getCourseName() );
    assertEquals( course.getDurationHours(), courseSaved.getDurationHours() );  

}

@Test
void isRightCourseTests(){

    Course course = new Course();

    course.setCourseName("Curso de prueba");
    course.setDurationHours(123);

    assertEquals(true, courseService.isRightCourse(course));

    course.setDurationHours(null);

    assertEquals(false, courseService.isRightCourse(course));

}




@Test
void mapperCourseEntityTests(){

    CoursePOJO pojo = new CoursePOJO();
    pojo.setCourseName("Curso de prueba");
    pojo.setDurationHours(123);
    Course course = courseService.mapperCourseEntity( pojo );

    assertNotNull( course );
    assertNotNull( course.getCourseName());
    assertNotNull( course.getDurationHours());

    assertEquals( course.getCourseName(), pojo.getCourseName() );
    assertEquals( course.getDurationHours(), pojo.getDurationHours() );  
}


}