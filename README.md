# aws-lambda-maven-cdk

Deploying Java lambda with Maven and CDK

## Commands

**Note:** CDK is required on your machine to deploy the solution

`mvn clean package` - build the solution

`cd infra; cdk deploy` - deploy the solution

# Structure

* `cdk` - Deploys lambda with CDK
* `lambdas` - Contains lambda functions
* `layer` - Creates layer for use by the lambdas