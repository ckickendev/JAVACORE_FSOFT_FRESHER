package fa.training.customannotation.test;

import java.lang.reflect.Method;
import fa.training.customannotation.AnnotationMarker;
import fa.training.customannotation.MyMarker;

public class TestAnnotationReflection {
	public static void main(String[] args) {
		AnnotationMarker runner = new AnnotationMarker();
        Method[] methods = runner.getClass().getMethods();
 
        for (Method method : methods) {
            MyMarker myMarker = method.getAnnotation(MyMarker.class);
            if (myMarker != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
	}

}
