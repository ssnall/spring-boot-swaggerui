package com.exapmle.tjago.controller;

import com.exapmle.tjago.service.PhoneBookService;
import com.exapmle.tjago.domain.Contact;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by snallangi on 9/9/14.
 */
@Api(value = "phoneBook", description = "PhoneBook operations")
@RestController("/phonebook")
@RequestMapping("/phonebook")
public class PhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    @ApiOperation(nickname = "entries", value = "get entries", notes = "Lists all entries", httpMethod = "GET", response = Contact.class, responseContainer = "Set", produces = "application/json")
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getAll() {
        return phoneBookService.getAll();
    }

    @ApiOperation(nickname = "Add contact", value = "Add Contact", notes = "This will add contact to phone book",
            httpMethod = "POST", consumes = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid input supplied")})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Invalid input supplied")
    public void saveContact(@RequestBody Contact contact) {
        phoneBookService.save(contact);
    }


    @RequestMapping(value = "/getContact", method = RequestMethod.GET)
    @ApiOperation(nickname = "getContact", value = "get contact", notes = "returns contact", httpMethod = "GET", response = Contact.class, produces = "application/json")
    public Contact getContact(@RequestParam Long id) {
        return phoneBookService.find(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(nickname = "delete", value = "delete contact", notes = "deletes contact", httpMethod = "DELETE")
    public void delete(@RequestParam Long id) {
        phoneBookService.delete(id);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String handleException(Exception e) {
        return "return error object instead";
    }


}
