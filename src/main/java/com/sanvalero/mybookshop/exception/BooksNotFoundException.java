package com.sanvalero.mybookshop.exception;

public class BooksNotFoundException extends RuntimeException{

        public BooksNotFoundException(){
            super();
    }

    public BooksNotFoundException(String message){
            super(message);
    }
    public BooksNotFoundException(long id){
            super("Book not found " + id );
    }
}
