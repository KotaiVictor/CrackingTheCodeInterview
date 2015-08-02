package com.kotai.cracking.chapter8.problem5;

import java.util.List;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public class Book {
  private final int bookId;
  private final String bookTitle;
  private final String description;
  private List<String> pages = Lists.newArrayList();

  public Book(int bookId, String title, String description) {
    this.bookId = bookId;
    this.bookTitle = title;
    this.description = description;
  }

  public void loadPages(List<String> pages) {
    this.pages.clear();
    this.pages.addAll(pages);
  }

  public int getBookId() {
    return bookId;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public String getDescription() {
    return description;
  }

  public int getSize() {
    return pages.size();
  }

  public Optional<String> getPage(int pageNumber) {
    String page = null;
    if (pageNumber >= 0 && pageNumber < pages.size()) {
      page = pages.get(pageNumber);
    }
    return Optional.fromNullable(page);
  }
}
