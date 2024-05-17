package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/* Implement the Controller
Create an IOUController class with the following members:

IOUService iouService - in instance of the service interface
IOUController(IOUService iouService) - constructor that accepts an instance of the service interface
Add additional methods that defines endpoints for the following operations:

Method	URL	Description
GET	/api/ious	Get all IOUs
GET	/api/ious/{id}	Get an IOU by id
POST	/api/ious	Add an IOU
PUT	/api/ious/{id}	Replace an IOU by Id
DELETE	/api/ious/{id}	Delete an IOU by id
Set the appropriate accessibility modifiers for all members and annotate the class as a RestController.*/
@RestController
@RequestMapping("api/iou")

public class IOUController {
 @Autowired
    public IOUService iouService; //- in instance of the service interface

    public IOUController(IOUService iouService){ //- constructor that accepts an instance of the service interface
        this.iouService = iouService;
}
//GET	/api/ious	Get all IOUs
@GetMapping("/api/ious")//, produces = "application/json")

public List<IOU> getAllIOUs() {

    return iouService.getAllIOUs();
}
//GET	/api/ious/{id}	Get an IOU by id
@GetMapping("/api/ious/{id}")//, produces = "application/json")
    
public IOU getIOUById(@PathVariable int id){

    return iouService.findById(id);
     

}
//POST	/api/ious	Add an IOU
@PostMapping("/api/ious")
//public  @ResponseBody String addAnIou (@RequestParam UUID id, @RequestParam String email) {

public  @ResponseBody Integer addAnIou (@RequestParam UUID id) {
    
    IOU addAnIou = new IOU();
        addAnIou.setId(id);
        //addAnIou.setEmail(email);
        iouService.save(addAnIou);
        //return addAnIou(name, email);
        return addAnIou(id);
}


//PUT	/api/ious/{id}	Replace an IOU by Id

//DELETE	/api/ious/{id}	Delete an IOU by id
//Set the appropriate accessibility modifiers for all members and annotate the class as a RestController.*/



    /*@RequestMapping("/{id}", method = requestMthod.GET, produces = "application json ")

public IOU getIou(@PathVariable int id) {
    return findIouById(id);
}*/

}
