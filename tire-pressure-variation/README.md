# Tire Pressure Monitoring System Variation

## Goal
Be able to make characterization tests for `Alarm`'s `check` function without changing the method signature.

# Launch mutation tests

Click on `maven` tab in your IDE or run these commands:

`$ mvn test-compile org.pitest:pitest-maven:mutationCoverage`

`$ firefox target/pit-reports/`

## References

Based on an exercise from [Luca Minudel](https://twitter.com/lukadotnet?lang=en)'s [TDD with Mock Objects And Design Principles exercises](https://github.com/lucaminudel/TDDwithMockObjectsAndDesignPrinciples)

