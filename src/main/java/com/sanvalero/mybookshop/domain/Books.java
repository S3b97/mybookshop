package com.sanvalero.mybookshop.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Books {

@Schema(description = "Identificador del libro", example = "1", required = true)
@Id
@GeneratedValue
private long id;

@Schema(description = "Titulo del libro", example = "Flores azul", required = true)
@Column
private String title;

@Schema(description = "Categoria del libro", example = "Historia")
@Column
private String category;

@Schema(description = "numero de paginas", example = "250")
@Column
private int numPages;

@Schema(description = "Año de publicacion", example = "1990-08-10")
@Column
private LocalDate dateOfPublication;

@Schema(description = "Precio del libro", example = "5.50")
@Column
private float price;

@Schema(description = "Disponibilidad del libro", example = "No")
@Column
private boolean available;

}
