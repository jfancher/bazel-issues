# bazel-issues - Java header compilation failure

In this particular arrangement of classes and dependencies, Java header compilation fails.

- `@maven//:com_google_guava_guava` provides `AbstractFuture` (extends `InternalFutureFailureAccess`)
- `@maven//:com_google_guava_failureaccess` provides `InternalFutureFailureAccess`
- `//:lib` defines `Outer` and `Outer$Inner`; `Inner` extends `AbstractFuture`

Other conditions that seem to be necessary:
- `Inner` is non-static
- `Inner` declares a method with itself in the signature

```console
$ bazel version
Build label: 3.4.1
Build target: bazel-out/k8-opt/bin/src/main/java/com/google/devtools/build/lib/bazel/BazelServer_deploy.jar
Build time: Tue Jul 14 06:27:53 2020 (1594708073)
Build timestamp: 1594708073
Build timestamp as int: 1594708073

$ bazel run :Main
[...]
Compiling Java headers liblib-hjar.jar (1 source file) failed (Exit 1)
[...]
Outer.java:7: error: could not locate class file for com.google.common.util.concurrent.internal.InternalFutureFailureAccess
        public Inner i() { return this; }

$ bazel run --java_header_compilation=false :Main
[...]
lib.Outer@5ecddf8f
```
