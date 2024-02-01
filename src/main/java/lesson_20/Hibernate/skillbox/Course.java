package lesson_20.Hibernate.skillbox;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// создаем класс из базы данных, с полями таблици
@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private int id;

    @Column(columnDefinition = "name")
    private String name;

    @Column(columnDefinition = "duration")
    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;

    @Column(columnDefinition = "description")
    private String description;

    @Column(name = "teacher_id" )
    private int teacherId;

    @Column(name = "students_count")
    private int studentsCount;

    @Column(name = "price")
    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    public Course(){}

    public Course(int id, String name, int duration, CourseType type, String description, int teacherId, int studentsCount, int price, float pricePerHour) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.type = type;
        this.description = description;
        this.teacherId = teacherId;
        this.studentsCount = studentsCount;
        this.price = price;
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", teacherId=" + teacherId +
                ", studentsCount=" + studentsCount +
                ", price=" + price +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
