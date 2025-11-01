package in.glorious.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.glorious.model.Student;
import in.glorious.repo.StudentRepo;

@Service
public class StudentService {
    @Autowired 
    private StudentRepo studentRepo;

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
}
