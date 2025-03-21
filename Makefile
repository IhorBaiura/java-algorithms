.PHONY: test-unit test-unit-coverage

test-unit:
	mvn clean test

test-unit-coverage:
	mvn clean test jacoco:report
