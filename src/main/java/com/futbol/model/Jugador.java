package com.futbol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    @Column(nullable = false, length = 60)
    private String nombre;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^[0-9+\\-\\s]{7,15}$", message = "Teléfono inválido (7-15 dígitos)")
    @Column(nullable = false, length = 15)
    private String telefono;

    public Jugador() {}

    public Jugador(String nombre, String telefono) {
        this.nombre   = nombre;
        this.telefono = telefono;
    }

    public Long getId()                      { return id; }
    public void setId(Long id)               { this.id = id; }

    public String getNombre()                { return nombre; }
    public void setNombre(String nombre)     { this.nombre = nombre; }

    public String getTelefono()              { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}