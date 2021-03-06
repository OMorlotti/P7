package xyz.morlotti.virtualbookcase.webapi.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import xyz.morlotti.virtualbookcase.webapi.models.BookDescription;
import xyz.morlotti.virtualbookcase.webapi.exceptions.APINotFoundException;
import xyz.morlotti.virtualbookcase.webapi.services.interfaces.BookDescriptionService;

@RestController
public class BookDescriptionController
{
	@Autowired
	BookDescriptionService bookDescriptionService;

	@RequestMapping(value = "/bookDescriptions", method = RequestMethod.GET)
	public Iterable<BookDescription> listBookDescriptions()
	{
		return bookDescriptionService.listBookDescriptions();
	}

	@RequestMapping(value = "/bookDescription/{id}", method = RequestMethod.GET)
	public BookDescription getBookDescription(@PathVariable("id") int id)
	{
		Optional<BookDescription> optional = bookDescriptionService.getBookDescription(id);

		if(optional.isEmpty())
		{
			throw new APINotFoundException("Book description " + id + " not found");
		}

		return optional.get();
	}

	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('EMPLOYEE')")
	@RequestMapping(value = "/bookDescription", method = RequestMethod.POST)
	public ResponseEntity<Void> addBookDescription(@Valid @RequestBody BookDescription bookDescription)
	{
		BookDescription newBookDescription = bookDescriptionService.addBookDescription(bookDescription);

		URI location = ServletUriComponentsBuilder
		   .fromCurrentRequest()
		   .path("/{id}")
		   .buildAndExpand(newBookDescription.getId())
		   .toUri()
		;

		return ResponseEntity.created(location).build();
	}

	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('EMPLOYEE')")
	@RequestMapping(value = "/bookDescription/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateBookDescription(@PathVariable("id") int id, @Valid @RequestBody BookDescription bookDescription)
	{
		BookDescription newBookDescription = bookDescriptionService.updateBookDescription(id, bookDescription);

		URI location = ServletUriComponentsBuilder
		   .fromCurrentRequest()
		   .path("/{id}")
		   .buildAndExpand(newBookDescription.getId())
		   .toUri()
		;

		return ResponseEntity.created(location).build();
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/bookDescription/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBookDescription(@PathVariable("id") int id)
	{
		bookDescriptionService.deleteBookDescription(id);

		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
