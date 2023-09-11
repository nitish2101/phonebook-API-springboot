package com.phonebook.phonebookspring.phonebook;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ContactsController {
    private ContactRepository repository;

    public ContactsController(ContactRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/contacts",method = RequestMethod.GET)
    public List<Contact> retrieveAllContacts(){
        return repository.findAll();
    }

    @RequestMapping(value="/contacts/{id}",method = RequestMethod.GET)
    public Contact retrieveContactById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException());
    }

    @RequestMapping(value="/contacts",method=RequestMethod.POST)
    public Contact addNewContact(@RequestBody Contact newContact){
        return repository.save(newContact);
    }

    @RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
    public void deleteQuestionById(@PathVariable Long id){
        repository.deleteById(id);
    }

    @RequestMapping(value="/contacts/{id}",method = RequestMethod.PUT)
    public Contact updateContact(@PathVariable Long id,@RequestBody Contact newContact){
        return repository.findById(id).map(
                contact -> {
                    contact.setPhoneNo(newContact.getPhoneNo());
                    contact.setEmail(newContact.getEmail());
                    contact.setName(newContact.getName());
                    return repository.save(contact);
                })
                .orElseGet(()->{
                    newContact.setId(id);
                    return repository.save(newContact);
        });
    }
}
