package student.management.spring.app.entities;

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
@Table(name="grade")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Grade {
	
	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "NVARCHAR(50)")
	private String name;

	//bi-directional many-to-one association to Clazz
	@OneToMany(mappedBy="grade")
	private Set<Clazz> clazzs;

	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="grade")
	private Set<Subject> subjects;


	public Clazz addClazz(Clazz clazz) {
		getClazzs().add(clazz);
		clazz.setGrade(this);
		return clazz;
	}

	public Clazz removeClazz(Clazz clazz) {
		getClazzs().remove(clazz);
		clazz.setGrade(null);
		return clazz;
	}

	public Subject addSubject(Subject subject) {
		getSubjects().add(subject);
		subject.setGrade(this);
		return subject;
	}

	public Subject removeSubject(Subject subject) {
		getSubjects().remove(subject);
		subject.setGrade(null);
		return subject;
	}

}