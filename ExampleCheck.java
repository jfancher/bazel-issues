package example;

import static com.google.errorprone.matchers.Matchers.instanceMethod;

import com.google.auto.service.AutoService;
import com.google.errorprone.BugPattern;
import com.google.errorprone.BugPattern.SeverityLevel;
import com.google.errorprone.VisitorState;
import com.google.errorprone.bugpatterns.BugChecker;
import com.google.errorprone.bugpatterns.BugChecker.MethodInvocationTreeMatcher;
import com.google.errorprone.matchers.Description;
import com.google.errorprone.matchers.Matcher;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.MethodInvocationTree;

@BugPattern(
    name = "ExampleCheck",
    summary = "Don't call this",
    severity = SeverityLevel.ERROR
)
@AutoService(BugChecker.class)
public class ExampleCheck extends BugChecker implements MethodInvocationTreeMatcher {
    private static final Matcher<ExpressionTree> STRING_GETBYTES =
        instanceMethod().onExactClass("java.lang.String").named("getBytes").withParameters();

    @Override
    public Description matchMethodInvocation(MethodInvocationTree tree, VisitorState state) {
        if (!STRING_GETBYTES.matches(tree, state)) {
            return Description.NO_MATCH;
        }
        return describeMatch(tree);
    }
}
