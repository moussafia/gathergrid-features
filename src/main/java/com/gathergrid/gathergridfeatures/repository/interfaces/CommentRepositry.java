package com.gathergrid.gathergridfeatures.repository.interfaces;

import com.gathergrid.gathergridfeatures.domain.Comment;

public interface CommentRepositry {
    public Comment save(Comment c);
    public Comment update(Comment c);
    public void delete(int comment_id,int user_id);
    public Comment show();
}
