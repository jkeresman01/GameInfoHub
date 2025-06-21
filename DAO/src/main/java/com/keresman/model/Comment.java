package com.keresman.model;

public final class Comment implements Comparable<Comment> {

    private int commentId;
    private String title;
    private String content;

    public Comment() {
    }

    public Comment(int commentId, String title, String content) {
        this.commentId = commentId;
        this.title = title;
        this.content = content;
    }

    public Comment(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", title=" + title + ", content=" + content + '}';
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.commentId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        return this.commentId == other.commentId;
    }

    @Override
    public int compareTo(Comment o) {
        return Integer.compare(commentId, o.commentId);
    }

}
