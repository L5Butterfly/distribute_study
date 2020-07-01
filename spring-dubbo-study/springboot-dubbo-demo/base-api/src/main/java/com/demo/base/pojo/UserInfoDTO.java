package com.demo.base.pojo;

import java.io.Serializable;


/**
 * UserInfoDTO
 * @author oxygen
 * @date 2020/6/29
 **/
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = -4514799376280377560L;

    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 性别
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
