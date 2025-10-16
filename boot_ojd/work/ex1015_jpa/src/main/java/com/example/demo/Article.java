package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name="article" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name="title", length=100 )
    private String title;

    @Column( name="description", length=4096 )
    private String description;

    @ManyToOne
    @JoinColumn( name="memberId" )
    private Member member;
}









