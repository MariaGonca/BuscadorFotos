package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


/**
 * The Class Image.
 */
@Entity
@Table(name = "images")
public class Image implements Serializable {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idImage;

	/** The title. */
	@Column(name = "title", nullable = false)
	@NotBlank
	private String title;

	/** The url. */
	@Column(name = "url", nullable = false)
	@NotBlank
	private String url;

	/** The description. */
	@Column(name = "description")
	private String description;

	/** The tags. */
	@Column(name = "tags")
	private String tags;

	/**
	 * Instantiates a new image.
	 *
	 * @param title       the title
	 * @param url         the url
	 * @param description the description
	 * @param tags        the tags
	 */
	public Image(String title, String url, String description, String tags) {
		super();
		this.title = title;
		this.url = url;
		this.description = description;
		this.tags = tags;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getIdImage() {
		return idImage;
	}

	/**
	 * Sets the id.
	 *
	 * @param iD the new id
	 */
	public void setIdImage(Long iD) {
		this.idImage = iD;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * Sets the tags.
	 *
	 * @param tags the new tags
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * Instantiates a new image.
	 */
	public Image() {

	}
}