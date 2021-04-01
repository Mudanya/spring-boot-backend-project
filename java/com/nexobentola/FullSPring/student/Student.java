package com.nexobentola.FullSPring.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


public class Student {
    private final UUID studentId;
    private final String first_name;
    private final String last_name;
    private final String email;
    private final Gender gender;


    public Student(
            @JsonProperty("studentId") UUID studentId,
            @JsonProperty("first_name") String first_name,
            @JsonProperty("last_name") String last_name,
            @JsonProperty("email") String email,
            @JsonProperty("gender") Gender gender) {
        this.studentId = studentId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
    }

    public UUID getStudentId() {
        return studentId;
    }
    @NotBlank
    public String getFirst_name() {
        return first_name;
    }
    @NotBlank
    public String getLast_name() {
        return last_name;
    }
    @NotBlank
    public String getEmail() {
        return email;
    }
    @NonNull
    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }

    enum Gender {
        MALE,FEMALE
    }
}
