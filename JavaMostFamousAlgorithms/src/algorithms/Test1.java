public class Test1 {
    private Test4 test4;
    private Test2 test2;

    public Test1() {
        this.test4 = new Test4();
        this.test2 = new Test2();
    }

    public void method1() {
        test2.getTest3().test3Method();
        test4.getTest5().test5Method();
    }
}

public class Test2 {
    private Test3 test3;

    public Test2() {
        this.test3 = new Test3();
    }

    public Test3 getTest3() {
        return test3;
    }
}

public class Test3 {
    public void test3Method() { }
}

public class Test4 {
    private Test5 test5;

    public Test4() {
        this.test5 = new Test5();
    }

    public Test5 getTest5() {
        return test5;
    }
}

public class Test5 {
    public void test5Method() { }
}
