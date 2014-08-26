package lectureEx;

class student extends Person1 {
    String studid;
    public void disp() {
        System.out.println(name); System.out.println(studid);
    }
    public void set() {
        super.set(); studid = "s001";
System.out.println("sdf");
    }
    public static void main(String args[]) {
        Person1 s1 = new student();
        s1.disp();
        s1.set();
        
        System.out.println(s1.toString());
    }
}
     
