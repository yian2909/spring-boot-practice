package top.xg.springboot.thymeleaf.model;

public class Task {
    private Long id;
    private String name;
    private boolean completed;

    public Task(String name, Long id) {
        this.name = name;
        this.id = id;
        this.completed = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
