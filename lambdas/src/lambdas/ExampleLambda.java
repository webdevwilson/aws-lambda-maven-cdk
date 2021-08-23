package lambdas;

import java.util.Map;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.common.base.Joiner;

public class ExampleLambda implements RequestHandler<Map<String, String>, String> {

    @Override
    public String handleRequest(final Map<String, String> event, final Context context) {
        System.out.println("Received event: " + event);
        // using an external dependency from a layer
        final String msg = Joiner.on(" ").join("Hello", "from", "Java!");
        System.out.println(msg);
        return null;
    }
}