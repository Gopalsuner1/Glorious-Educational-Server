package in.glorious.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
@Builder
public class Student {
    @Id
    private String id;

    private String studentId;
    private String studentName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String studentClass;
    private String scholar;
    private String fatherQualification;
    private String fatherOccupation;
    private String income;
    private String motherQualification;
    private String motherOccupation;
    private String presentAddress;
    private String phoneNumber;
    private String phoneNumber2;
    private String dateOfBirth;
 
    private String addmissionDate;
    private String gender;
    private String category;
    private String caste;
    private String religion;
    private String group;
    private String busNumber;
    private String busStop;
    private String lastSchool;
    private String aadharNumber;
    private String childSSS;
    private String familySSS;
    private String accountOf;
    private String accountNumber;
    private String bankName;
    private String ifscCode;
    private String addmissionClass;
    private String fatherDateOfBirth;
    private String motherDateOfBirth;

    private String nameInAadhar;
    private String scholarStatus;
}