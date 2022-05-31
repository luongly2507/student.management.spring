package student.management.spring.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="clazz_student",uniqueConstraints = { @UniqueConstraint(columnNames = { "class_id", "student_id" })})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClazzStudent {
	
	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Clazz
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="class_id")
	private Clazz clazz;

	//bi-directional many-to-one association to Semester
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="semester_id")
	private Semester semester;

	//bi-directional many-to-one association to Student
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	private Student student;

}