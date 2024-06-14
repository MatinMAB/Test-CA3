package ir.ramtung.impl1;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class NonEmptyStringGenerator extends Generator<String> {
    public NonEmptyStringGenerator() {
        super(String.class);
    }

    @Override
    public String generate(SourceOfRandomness random, GenerationStatus status) {
        int length = random.nextInt(1, 20); // Generate strings of length 1 to 20
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) random.nextInt('a', 'z' + 1));
        }
        return sb.toString();
    }
}
