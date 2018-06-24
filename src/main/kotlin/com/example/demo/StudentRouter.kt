package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Student(@Id @GeneratedValue(strategy = GenerationType.AUTO)
              val id: Long? = null, var name: String? = null, var department: String? = null)


interface StudentRepository : JpaRepository<Student, Long>


@RestController
@RequestMapping("/student")
class USerCotroller(val studentRepository: StudentRepository) {


    @GetMapping("/getAllStudents")
    fun getAll(): MutableList<Student> {
        return studentRepository.findAll()
    }

    @PostMapping("/saveStudent")
    fun saveStudent(@RequestBody student: Student): Student {
        return studentRepository.save(student)
    }
}




