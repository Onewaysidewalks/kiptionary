package ninja.onewaysidewalks.kiptionary;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

public class KiptionarySpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
    private static final Set<String> supportedApplicationIds = new HashSet<String>();
    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds.add("amzn1.echo-sdk-ams.app.cb0d6937-3948-450b-82bc-643e816d38f6");
    }

    public KiptionarySpeechletRequestStreamHandler() {
        super(new KiptionarySpeechlet(), supportedApplicationIds);
    }
}