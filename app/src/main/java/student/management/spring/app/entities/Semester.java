package student.management.spring.app.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="semester")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Semester implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(columnDefinition = "NVARCHAR(50)")
	private String name;

	//bi-directional many-to-one association to ClazzStudent
	@OneToMany(mappedBy="semester")
	private Set<ClazzStudent> clazzStudents;

	//bi-directional many-to-one association to Score
	@OneToMany(mappedBy="semester")
	private Set<Score> scores;

	public ClazzStudent addClazzStudent(ClazzStudent clazzStudent) {
		getClazzStudents().add(clazzStudent);
		clazzStudent.setSemester(this);
		return clazzStudent;
	}

	public ClazzStudent removeClazzStudent(ClazzStudent clazzStudent) {
		getClazzStudents().remove(clazzStudent);
		clazzStudent.setSemester(null);
		return clazzStudent;
	}
	
	public Score addScore(Score score) {
		getScores().add(score);
		score.setSemester(this);
		return score;
	}

	public Score removeScore(Score score) {
		getScores().remove(score);
		score.setSemester(null);
		return score;
	}

}