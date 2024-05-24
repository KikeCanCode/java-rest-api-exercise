package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;


@Service
public class IOUService {

public IOURepository iouRepository; 

    public IOUService(IOURepository iouRepository) {
        this.iouRepository = iouRepository;
}

    /**
     * Retrieve a list of all IOUs.
     *
     * @return A list of all IOUs.
     */

    public List<IOU> getAllIOUs() {
        return iouRepository.findAll();
    }

    /**
     * Retrieve an IOU by its ID.
     *
     * @param id The ID of the IOU to retrieve.
     * @return The IOU with the specified ID, or null if not found.
     */
    public IOU getIOU(UUID id) throws NoSuchElementException {
        return iouRepository.findById(id).orElseThrow();
    }

    /**
     * Create a new IOU.
     *
     * @param iou The IOU object to create.
     * @return The created IOU.
     */
    public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException {
        return iouRepository.save(iou);  // A catch exception will be done in the controller. HttpStatus
    }
    
    /**
     * Update an existing IOU by its ID.
     *
     * @param id         The ID of the IOU to update.
     * @param updatedIOU The updated IOU object.
     * @return The updated IOU, or null if the ID is not found.
     */
   public IOU updateIOU(UUID id, IOU updatedIOU) throws NoSuchElementException { // id reminds the same but replaced the value with the new ones
   
    IOU iou = iouRepository.findById(id).orElseThrow(); // A throw exception here, will be catch in controller - HttpStatus-not found
        iou.setBorrower(updatedIOU.getBorrower()); 
        iou.setLender(updatedIOU.getLender()); 
        iou.setAmount(updatedIOU.getAmount());
        iou.setDateTime(updatedIOU.getDateTime());
        iouRepository.save(iou); // saved updated iou
        return iou; // retunr the updated iou object
    
   }

    /**
     * Delete an IOU by its ID.
     *
     * @param id The ID of the IOU to delete.
     */
    public void deleteIOU(UUID id) { // If I added a throw exception here, it will be catch in the controller - so it's good
        iouRepository.deleteById(id);
        
    }
}