package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloWorldTest {

    @Test
    public void greetingTest() {
        assertThat(HelloWorld.greeting()).isEqualTo("Hello, World!");
    }
}
