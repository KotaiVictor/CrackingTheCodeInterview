package com.kotai.cracking.chapter8.problem5;

import com.google.common.base.Optional;

public class BookReader {

  private Book activeBook;
  private final User activeUser;
  private int currentPage;
  private String title;

  public BookReader(User user) {
    this.activeUser = user;
    this.activeBook = new DefaultBook();
  }

  public void loadBook(Book book) {
    this.activeBook = book;
    currentPage = 0;
    refreshDisplay();
  }

  public void goToPage(int page) {
    if (page > activeBook.getSize()) {
      page = activeBook.getSize();
    } else if (page < 0) {
      page = 0;
    }

    currentPage = page;
    refreshPage();
    refreshProgress();
  }

  public void turnPageForward() {
    goToPage(currentPage + 1);
  }

  public void turnPageBackward() {
    goToPage(currentPage - 1);
  }

  private void refreshDisplay() {
    refreshTitle();
    refreshProgress();
    refreshPage();
  }


  private void refreshPage() {
    // refreshes the viewd page
    Optional<String> possiblePage = activeBook.getPage(currentPage);
    if (possiblePage.isPresent()) {
      displayPage(possiblePage.get());
    }
  }

  private void displayPage(String string) {
    // displays page
  }

  private void refreshProgress() {
    // refreshes the progress
  }

  private void refreshTitle() {
    this.title = activeBook.getBookTitle();
    // refresh display
  }
}
