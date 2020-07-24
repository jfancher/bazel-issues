package lib;

import com.google.common.util.concurrent.AbstractFuture;

public class Outer {
    public class Inner extends AbstractFuture<Void> {
        public Inner i() { return this; }
    }
}
