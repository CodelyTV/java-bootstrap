package tv.codely.java_basic_skeleton;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
public class Greeter {
	@NonNull
	private final String greet;

    public String greet() {
        return "Hello " + this.greet;
    }
    
    

}
