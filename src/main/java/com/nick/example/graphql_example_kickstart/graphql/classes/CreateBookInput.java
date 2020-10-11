package com.nick.example.graphql_example_kickstart.graphql.classes;

public class CreateBookInput {

    private String name;
    private int pageCount;
    private String authorId;

    public CreateBookInput(String name, int pageCount, String authorId) {
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
