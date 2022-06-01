package student.management.spring.app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clazz")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clazz {
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "NVARCHAR(50)")
	private String name;

	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_id")
	private Grade grade;

	@OneToMany(mappedBy = "clazz")
	private Set<ClazzStudent> clazzStudents;

	public ClazzStudent addClazzStudent(ClazzStudent clazzStudent) {
		getClazzStudents().add(clazzStudent);
		clazzStudent.setClazz(this);

		return clazzStudent;
	}

	public ClazzStudent removeClazzStudent(ClazzStudent clazzStudent) {
		getClazzStudents().remove(clazzStudent);
		clazzStudent.setClazz(null);

		return clazzStudent;
	}

}