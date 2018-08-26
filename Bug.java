package example;

class Bug {
    void repro() {
        // note: this does not depend on BugDep2
        // _but_ there is an overload that does with the same number of args
        // this is important -- change the name or arg count and the bug goes away
        BugDep1.useDep2(0);
    }
}
