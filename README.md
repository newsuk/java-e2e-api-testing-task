# Running tests

## Requirements
- Java 17+
- Maven
- IDE

## Running the tests
```shell
mvn test
```

# Objective

This task is designed to assess your ability to write and update automated API tests against a GraphQL and REST endpoint, using either Java/Rest Assured or TypeScript/Playwright. The aim is to validate that specific properties and values returned by the API conform to requirements.

# Entitlements
## Background:
The endpoint featureDecisions accepts an array featureCodes. Previously, your colleague wrote a test verifying that when requesting all features, the returned list included an object with a code property set to `fp-1113`.

## New Requirement:
You need to write a new automated test that:

Sends a GraphQL query which requests only the object with `code = "fp-1113"` by passing this value in the featureCodes array.
Verifies that the response includes an object code: "fp-1113" and its `outcomeAsBoolean` property is `false`.

## Write the Test:

Modify the GraphQL query to:
featureDecisions(featureCodes: ["fp-1113"]) { ... }
Assert that the returned data contains only the required object, and that its `outcomeAsBoolean` property is equal to `false`.

## Refactor the code

If you think the code might be refactored to improve readability and re-usability please do so.

# Proposition bootstrap
## Task 1: Validate Proposition Details
Objective:
Write a test to verify that the endpoint returns proposition details that match expected business logic.

__Endpoint:__ 
```
https://join.thetimes.com/checkout/bootstrap?pc=ONS3001SZS7PB
```

__Instructions:__

Make a request to the endpoint. Assert that:

- The object at data.propositions has the property code set to "MP1161".
- The property isFree is false.
- The countries array contains "GBR".
- The array property paymentType contains "PAYPAL".

## Task 2: Check Payment Details and Onboarding

__Objective:__

Write a test that ensures payment and onboarding information is returned correctly for the proposition.

__Instructions:__

- Make a request to the endpoint. Assert that:
- The property monthlyCost under data.propositions is "30.00".
- The property paymentInitialAmount under data.propositions is "1.00".
- The property onboardingSteps includes "NEWSLETTERS" and "TIMES_PLUS".
- The property showOnboarding is true.

## Task 3: Customer Details and Subscription Status
__Objective:__
Create a test to check that customer details and subscription information are as expected for a new or unregistered user.

__Instructions:__

Make a request to the endpoint. Assert that:
- The object under data.customer has all the following properties set to null: email, displayName, firstName, lastName, dateOfBirth, title, and phone.
- The property hasActiveSubscription under data.customer is set to false.
- The property accountAgeLessThan30Seconds under data.customer is set to false.
- The property checkoutType is "CHECKOUT".

# Deliverables
Code files containing automated tests (in Java/Rest Assured or TS/Playwright).
Brief notes explaining assumptions and your approach.