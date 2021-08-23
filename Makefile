
build:
	mvn clean package

deploy: build
	cd infra; cdk deploy

.PHONY := build deploy