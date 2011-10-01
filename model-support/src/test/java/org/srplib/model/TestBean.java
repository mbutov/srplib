package org.srplib.model;

/**
 * @author Q-APE
 */
public class TestBean {

    private String id;

    private String name;

    private int age;

    public static TestBean create() {
        TestBean testBean = new TestBean();
        testBean.setId("id");
        testBean.setName("Name");
        testBean.setAge(27);
        return testBean;
    }

    public TestBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
