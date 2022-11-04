package org.example.Object;
// this is Greeting class and we have the attributes ,the constructors and setter y getter methods
public class Greeting {
    public  int id;
    public  String content;

    public Greeting() {
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Greeting(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
