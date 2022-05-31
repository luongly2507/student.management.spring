package student.management.spring.app.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="subject")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject{
	@Id
	@Column(unique=true, nullable=false)
	private int id;
	
	@Column(columnDefinition = "NVARCHAR(50)")
	private String name;

	//bi-directional many-to-one association to Score
	@OneToMany(mappedBy="subject")
	private Set<Score> scores;

	//bi-directional many-to-one association to Grade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="grade_id")
	private Grade grade;

	public Score addScore(Score score) {
		getScores().add(score);
		score.setSubject(this);
		return score;
	}

	public Score removeScore(Score score) {
		getScores().remove(score);
		score.setSubject(null);
		return score;
	}


}