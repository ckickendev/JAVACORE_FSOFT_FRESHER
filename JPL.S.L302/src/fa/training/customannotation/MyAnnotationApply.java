package fa.training.customannotation;

public class MyAnnotationApply {
	@MyAnnotation(value = 100)
	public void greeting() {
		System.out.println("Greeting() from MyAnnotationApply");
	}

}
