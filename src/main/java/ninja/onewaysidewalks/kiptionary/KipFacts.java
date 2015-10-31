package ninja.onewaysidewalks.kiptionary;

import ninja.onewaysidewalks.kiptionary.models.KipFact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class KipFacts {
    private static final Logger log = LoggerFactory.getLogger(KipFacts.class);

    private static final Random RANDOM_GENERATOR = new Random();

    private static final KipFact[] FACTS = new KipFact[] {
            new KipFact("She has the most amazing eyes."),
            new KipFact("She is cute to boot."),
            new KipFact("She has a great sense of passion when it comes to teaching."),
            new KipFact("Her cuddle game is way strong."),
            new KipFact("She can make Sam's day brighter just by being around."),
            new KipFact("She is unbelievably funny when she tries to rearrange furniture in her sleep.")
    };


    public static KipFact getRandomFact() {
        int index = RANDOM_GENERATOR.nextInt(8) % FACTS.length;
        log.info("Using index {}", index);
        return FACTS[index];
    }

}
