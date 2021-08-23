package cdk;

import software.amazon.awscdk.core.*;

import software.amazon.awscdk.services.lambda.*;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.logs.RetentionDays;
import software.amazon.awscdk.services.s3.assets.AssetOptions;

import java.util.Arrays;

public class Stack extends software.amazon.awscdk.core.Stack {

    public Stack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public Stack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // Create a layer from the layer module
        final LayerVersion layer = new LayerVersion(this, "layer", LayerVersionProps.builder()
                .code(Code.fromAsset("../layer/target/bundle"))
                .compatibleRuntimes(Arrays.asList(Runtime.JAVA_8))
                .build()
        );

        // The code that defines your stack goes here
        new Function(this, "JavaFn", FunctionProps.builder()
                .runtime(Runtime.JAVA_8)
                .code(Code.fromAsset("../lambdas/target/lambdas.jar"))
                .handler("lambdas.ExampleLambda")
                .layers(Arrays.asList(layer))
                .memorySize(1024)
                .timeout(Duration.seconds(30))
                .logRetention(RetentionDays.ONE_WEEK)
                .build());
    }

    public static void main(final String[] args) {
        final App app = new App();
        new Stack(app, "Stack", StackProps.builder().build());
        app.synth();
    }
}