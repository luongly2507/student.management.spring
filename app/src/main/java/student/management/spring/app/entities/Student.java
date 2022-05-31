package student.management.spring.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="student")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "NVARCHAR(150)")
	private String address;

	@Column(columnDefinition = "NVARCHAR(100)")
	private String name;

	@Column(columnDefinition = "NVARCHAR(100)")
	private String email;

	@Column(columnDefinition = "NVARCHAR(11)")
	private String phone;

	@Column
	private LocalDate birthDate;

	//bi-directional many-to-one association to ClazzStudent
	@OneToMany(mappedBy="student")
	private Set<ClazzStudent> clazzStudents;

	//bi-directional many-to-one association to Score
	@OneToMany(mappedBy="student")
	private Set<Score> scores;

	public ClazzStudent addClazzStudent(ClazzStudent clazzStudent) {
		getClazzStudents().add(clazzStudent);
		clazzStudent.setStudent(this);
		return clazzStudent;
	}

	public ClazzStudent removeClazzStudent(ClazzStudent clazzStudent) {
		getClazzStudents().remove(clazzStudent);
		clazzStudent.setStudent(null);
		return clazzStudent;
	}


	public Score addScore(Score score) {
		getScores().add(score);
		score.setStudent(this);
		return score;
	}

	public Score removeScore(Score score) {
		getScores().remove(score);
		score.setStudent(null);
		return score;
	}

}