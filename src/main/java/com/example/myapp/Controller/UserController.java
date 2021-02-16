package com.example.myapp.Controller;
import com.example.myapp.DTO.UserDTO;
import com.example.myapp.Entity.User;
import com.example.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("get-all-user")
    public ResponseEntity<List<User>> getAllCompany(){
        List<User> report = userService.getAllUserService();
        return new ResponseEntity<List<User>>(report, HttpStatus.OK);
    }

    @PostMapping("add-new-user")
    public ResponseEntity<UserDTO> addUser(@RequestBody User user){
        UserDTO userDTO= new UserDTO();
        boolean value=userService.addUserService(user);
        if(value){
            userDTO.setErrorMessage("Inserted the data into table");
            
        }else{
            userDTO.setErrorMessage("Couldn't insert data into the table");
            return new ResponseEntity<>(userDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping("get-company-by-code")
    public ResponseEntity<User> getCompanyByCode(@RequestParam("companyCode") String company_code){
        try{
            User search_result = userService.getCompanyByCodeService(company_code);
            return new ResponseEntity<User>(search_result,HttpStatus.OK);

        }catch(Exception e)
        {
            return null;
        }
    }
//    @GetMapping("select_comp_by_merge")
//
//    public List<User> selectCompByMerge(String company_code){
//        try{
//            List<User> search_result = userService.selectParticular(company_code);
//            return search_result;
//
//        }catch(Exception e)
//        {
//            return null;
//        }
//    }




    @PutMapping("update-company")
    public ResponseEntity<UserDTO> updateCompany(@RequestBody User user){
        boolean updationSuccessful = userService.updateUser(user);
        UserDTO userDTO= new UserDTO();
        if(updationSuccessful){
            userDTO.setErrorMessage("Updated the data ");
        }else{
            userDTO.setErrorMessage("Couldn't update data ");
            return new ResponseEntity<>(userDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
        }

        @DeleteMapping("delete-company")
    public ResponseEntity<UserDTO> deleteCompany(@RequestParam String code){

        boolean deletionSuccessful = userService.deleteUserService(code);
        UserDTO userDTO = new UserDTO();

        if(deletionSuccessful)
            userDTO.setErrorMessage("Deleted the record");
        else{
            userDTO.setErrorMessage("Couldn't delete the record");
            return  new ResponseEntity<>(userDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }
    }

