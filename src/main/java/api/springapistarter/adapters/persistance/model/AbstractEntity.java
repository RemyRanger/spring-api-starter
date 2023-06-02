package api.springapistarter.adapters.persistance.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

/**
 * Base class to derive entity classes from.
 */
@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@CreatedDate
	@Column(name = "create_at", updatable = false)
	private Instant createAt;

	@LastModifiedDate
	@Column(name = "update_at")
	private Instant updateAt;

}
