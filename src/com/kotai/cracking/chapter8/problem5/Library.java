package com.kotai.cracking.chapter8.problem5;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Optional;

public class Library {
  private Map<Integer, Book> bookMap = new HashMap<>();

  public void addBook(Book newBook) {
    bookMap.put(newBook.getBookId(), newBook);
  }

  public void removeBook(Book bookToRemove) {
    bookMap.remove(bookToRemove.getBookId());
  }

  public void removeBook(int bookId) {
    bookMap.remove(bookId);
  }

  public Optional<Book> find(int id) {
    return Optional.fromNullable(bookMap.get(id));
  }
}
