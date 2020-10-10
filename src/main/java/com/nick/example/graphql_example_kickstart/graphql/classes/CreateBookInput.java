package com.nick.example.graphql_example_kickstart.graphql.classes;

public class CreateBookInput {

    String name;
    int pageCount;
    Long authorId;

    public CreateBookInput(String name, int pageCount, Long authorId) {
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
