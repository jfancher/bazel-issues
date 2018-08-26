package example;

class BugDep1 {
    public static void useDep2(int i) {}
    public static void useDep2(BugDep2 stub) {}
}
