package com.oraclejava.day6.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue //오라클에서는 Sequence
    private Long id;

    private String login;

    private Boolean disabled; // 정지 블로거: true

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") // ALL = 지우면 다 지워진다 Persist = 만들때만, 지울때는 남는다
    private Set<BlogPost> blogPosts = new HashSet<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Set<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(Set<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }
}
