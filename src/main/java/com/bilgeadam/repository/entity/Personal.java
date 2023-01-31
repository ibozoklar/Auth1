package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_personal")
@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String photo;
    String name;
    String secondName;
    String surname;
    Date birthOfDate;
    String placeOfBirth;
    Long nationalId;
    Date startDate;
    String occupation;
    String department;
    String password;

    @Column(unique = true)
    String email;

    String address;
    String telephone;


    UserType userType;

}
