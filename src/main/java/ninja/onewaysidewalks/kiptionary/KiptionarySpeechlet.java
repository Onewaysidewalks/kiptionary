package ninja.onewaysidewalks.kiptionary;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KiptionarySpeechlet implements Speechlet {
    private static final Logger log = LoggerFactory.getLogger(KiptionarySpeechlet.class);

    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        // any initialization logic goes here
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        return getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        if (Intents.RANDOM_FACT.equalsIgnoreCase(intentName)) {
            return getRandomFactResponse();
        } else if (Intents.HELP.equals(intentName)) {
            return getHelpResponse();
        } else if (Intents.END.equals(intentName)) {
            return getEndResponse();
        } else {
            throw new SpeechletException("Unknown Intent");
        }
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
        // any cleanup logic goes here
    }

    /**
     * Creates and returns a {@code SpeechletResponse} with a welcome message.
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse getWelcomeResponse() {
        String speechText = Messages.WELCOME_MESSAGE;

        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("Kiptionary");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }

    /**
     * Creates and returns a message with a closing statement, i.e. goodbye
     * @return SpeechletResposne only spoken message of closing
     */
    private SpeechletResponse getEndResponse() {
        String speechText = Messages.END_MESSAGE;

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech);
    }

    /**
     * Creates a {@code SpeechletResponse} for the RandomFactIntent
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse getRandomFactResponse() {
        String speechText = KipFacts.getRandomFact().getFact() + Messages.NEXT_STEPS_MESSAGE;

        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("Kiptionary Random Fact");
        card.setContent(KipFacts.getRandomFact().getFact());

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }

    /**
     * Creates a {@code SpeechletResponse} for the help intent. Should be a repeat of the Welcome response
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse getHelpResponse() {
        String speechText = Messages.WELCOME_MESSAGE;


        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt);
    }
}