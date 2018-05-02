
class Admin extends Person{

    int Authority;

    public void classify(){

    }
}

class User extends Person{

}

class Person{
    int id;
    String name;
    int age;

    public Person() {
    }

    public void borrowBooks(){

    }

    public void returnBooks(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


public class PersonTest {

    public static void main(String[] args) {
        Person p1=new User();
        p1.setName("user1");
        p1.setAge(18);

        System.out.println("name:"+p1.getName()+""+"age:"+p1.getAge());
    }
}
