package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
//import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://spring.io/guides/gs/accessing-data-mysql
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

@RestController          //It handles incoming HTTP requests and send response back to the caller.
@RequestMapping(path = "/api/ious")

public class IOUController {

    @Autowired      //enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
    public IOUService iouService; // - in instance of the service interface

    public IOUController(IOUService iouService) { // - constructor that accepts an instance of the service interface
        this.iouService = iouService;
    }
    // @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces =
    // "application json ")

    // GET /api/ious Get all IOUs
    @GetMapping
    public List<IOU> getAllIOUs() {

        return iouService.getAllIOUs();
    }

    // GET /api/ious/{id} Get an IOU by id - GET = Read - performed after
    // creating(Post) an id -
    @GetMapping("/{id}")

    public ResponseEntity<IOU> getIOU(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(iouService.getIOU(id), HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST /api/ious Add an IOU - Post = Create - The first thing to do - C in CRUD
    @PostMapping

    public ResponseEntity<IOU> createIOU(@RequestBody IOU iou) {
        IOU createdIOU = iouService.createIOU(iou);
       // System.out.println(createdIOU.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIOU);
    }

    // PUT /api/ious/{id} Replace an IOU by Id - PUT = update/ rplace an id after
    // creating(Post) it.
    @PutMapping("/{id}")

    public ResponseEntity<IOU> updatedIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU) { // replacing the content  of the old IOU to new one                                                 // 
        try {
            IOU updatediou = iouService.updateIOU(id, updatedIOU);
            return ResponseEntity.status(HttpStatus.OK).body(updatediou);
        } catch (NoSuchElementException errorNoSuchElementException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // DELETE /api/ious/{id} Delete an IOU by id - Delete = Delete
    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteIOU(@PathVariable UUID id) {
        try {
            iouService.getIOU(id);
            iouService.deleteIOU(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException | NoSuchElementException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
//https://www.baeldung.com/exception-handling-for-rest-with-spring
// https://www.tutorialspoint.com/postman/postman_put_requests.htm
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/package-summary.html
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/package-summary.htm
// https://www.javatpoint.com/restful-web-services-delete-resource
// Set the appropriate accessibility modifiers for all members and annotate the
// class as a RestController.
