package com.wfg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfg.entity.Student;
import com.wfg.service.StudentService;
import com.wfg.utils.Result;

@RestController
@RequestMapping("/student")
// 允许所有源的请求（生产环境中建议指定具体的源）
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students/all")
    public Result<List<Student>> getStudentsALL() {
        // 只返回未删除的学生
        return Result.success(studentService.getStudentsByIsDelete(0));
    }

    // 删除单个学生
    @GetMapping("students/name/{sno}")
    public Result<String> getStudentName(@PathVariable("sno") String sno){
        Student student = studentService.selectBySno(sno);

        System.out.println("sno;"+sno);
        System.out.println("name:"+student.getSname());
        return Result.success(student.getSname());

    }




    @DeleteMapping("/students/{sno}")
    public Result<Student> deleteStudent(@PathVariable("sno") String sno){

        System.out.println();
        System.out.println("用户要删除"+sno);
        int result = studentService.deleteStudent(sno);
        System.out.println();
        return Result.success();
    }



    @PutMapping("/students/{sno}")
    public Result<Student> updateStudent(@PathVariable("sno") String sno,@RequestBody Student student){

        System.out.println("update---"+sno);
        System.out.println("-----传来的学生数据为："+student);

        int result=studentService.updateStudentBySno(student);

        return Result.success();
    }



    @GetMapping("students/{sno}")
    public Result<Student> getOneStudent(@PathVariable("sno") String sno) {
        Student student = studentService.selectBySno(sno);
        System.out.println("student"+student);
        return Result.success(student);
    }

    @GetMapping("/infoList")
    public Result<List<Student>> getStudentInfoList(){
       List<Student>  studentList =    studentService.getStudentInfoList();
        System.out.println("student:----"+studentList);
        System.out.println("后端访问到了");
        System.out.println(Result.success(studentList));
       return  Result.success(studentList);
    }

    @GetMapping("/students")
    public Result<List<Student>> getStudents(){

        List<Student> students = studentService.getStudentInfoList();
        students.forEach(student -> student.setPhotoUrl(null));
        return Result.success(students);
    }

    @PostMapping("/students")
    public Result addStudent(@RequestBody Student student){
        System.out.println(student);
        // 先判断学号是否存在
        Student stu =  studentService.selectBySno(student.getSno());
        if (stu!=null){
            System.out.println("用户不存在");
        }
        studentService.addOneStudent(student);

        return Result.success();
    }

    @GetMapping("/hello")
    public String hello(){
        return "dfgkdfl";
    }



}
