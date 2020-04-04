package Java_ShiLi.Text115;

public class Employee implements Comparable<Employee> {//实现comparable接口
    
    private int id;
    private String name;
    private int age;
    
    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    @Override
    public int compareTo(Employee o) {//定义的比较方法
        if (id > o.id) {
            return 1;
        } else if (id < o.id) {
            return -1;
        }
        return 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("员工的编号：" + id + ", ");
        sb.append("员工的姓名：" + name + ", ");
        sb.append("员工的年龄：" + age);
        return sb.toString();
    }
}
