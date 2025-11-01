package in.glorious.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.glorious.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student,String> {

    
} 