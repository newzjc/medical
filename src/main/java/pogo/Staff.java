package pogo;

public class Staff {
    private String id;
    private String branch;
    private String name;
    private String sex;
    private String age;
    private String address;
    private String email;
    private String password;

    public Staff() {
    }

    public Staff(String id,String password){
        this.id=id;
        this.password=password;
    }

    public Staff(String id, String branch, String name, String sex, String age, String address, String email, String password) {
        this.id = id;
        this.branch = branch;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
