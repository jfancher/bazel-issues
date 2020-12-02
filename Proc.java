package ex;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic.Kind;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("ex.Anno")
public class Proc extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Elements els = processingEnv.getElementUtils();
        for (Element el : roundEnv.getElementsAnnotatedWith(Anno.class)) {
            if (els.isDeprecated(el)) {
                processingEnv.getMessager().printMessage(Kind.WARNING, "deprecated");
            }
        }
        return true;
    }
}
