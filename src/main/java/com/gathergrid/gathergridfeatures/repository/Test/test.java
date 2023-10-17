package com.gathergrid.gathergridfeatures.repository.Test;


import com.gathergrid.gathergridfeatures.domain.Comment;
import com.gathergrid.gathergridfeatures.repository.interfaces.CommentRepositry;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.CommentRepositryImpl;

public class test {
    public static void main(String[] args) {
//        Comment comment = new Comment("hi",3);
        CommentRepositry cr = new CommentRepositryImpl();
//        cr.save(comment, 1L, 1L);
        Comment comment2 = new Comment("hiUpdated",3);
        cr.update(comment2);
    }
}
