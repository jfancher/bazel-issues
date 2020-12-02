# bazel-issues - Turbine error

`ClassCastException` when using `javax.lang.model.util.Elements` during header
compilation. This only happens with the JDK 15 toolchain.

```console
$ bazel version
Build label: 3.7.0
Build target: bazel-out/darwin-opt/bin/src/main/java/com/google/devtools/build/lib/bazel/BazelServer_deploy.jar
Build time: Tue Oct 20 13:31:07 2020 (1603200667)
Build timestamp: 1603200667
Build timestamp as int: 1603200667

$ bazel build --config=jdk15 //:C2
[...]
Compiling Java headers libC1-hjar.jar (1 source file) and running annotation processors (Proc)
  failed (Exit 1): java failed: error executing command external/jdk15_macos/bin/java
  -Xverify:none '--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED'
  '--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED'
  ... (remaining 12 argument(s) skipped)

[...]
<>: error: java.lang.ClassCastException:
  class com.google.turbine.processing.TurbineElement$TurbineExecutableElement cannot be cast to
  class com.google.turbine.processing.TurbineElement$TurbineTypeElement
  (com.google.turbine.processing.TurbineElement$TurbineExecutableElement and
  com.google.turbine.processing.TurbineElement$TurbineTypeElement are in unnamed module of loader
  'app')

	at com.google.turbine.processing.TurbineElements.isDeprecated(TurbineElements.java:133)
	at ex.Proc.process(Proc.java:20)
	at com.google.turbine.binder.Processing.process(Processing.java:181)
	at com.google.turbine.binder.Binder.bind(Binder.java:102)
	at com.google.turbine.main.Main.bind(Main.java:246)
	at com.google.turbine.main.Main.fallback(Main.java:221)
	at com.google.turbine.main.Main.compile(Main.java:165)
	at com.google.turbine.main.Main.compile(Main.java:127)
	at com.google.turbine.main.Main.main(Main.java:84)

# (Disabling header compilation works)
$ bazel build --config=jdk15 --java_header_compilation=false //:C2
[...]
INFO: From Building libC1.jar (1 source file) and running annotation processors (Proc):
warning: deprecated
Target //:C2 up-to-date:
  bazel-bin/libC2.jar

# (Older versions of Java work) 
$ bazel build //:C2
[...]
INFO: From Building libC1.jar (1 source file) and running annotation processors (Proc):
warning: deprecated
Target //:C2 up-to-date:
  bazel-bin/libC2.jar
```
