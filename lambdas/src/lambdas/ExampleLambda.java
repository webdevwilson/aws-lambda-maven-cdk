package lambdas;

import java.util.Map;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ExampleLambda implements RequestHandler<Map<String, String>, String> {

    @Override
    public String handleRequest(final Map<String, String> events, final Context context) {
        System.out.println("Hello from Java! " + events);
        return null;
    }
}