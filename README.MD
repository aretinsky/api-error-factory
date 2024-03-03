Example of usage:

```java 
import org.aretinsky.lib.apierrorfactory.ErrorFactory;

...

public void doSomething() {
    throw ErrorFactory.exceptionBuilder(BusinessErrorCode.YOUR_BUSINESS_ERROR_CODE)
            .arg("argumentName", "argument value")
            .message("your message text")
            .build();
}

```

You will see following http response, when exception occurred:
```json
HTTP STATUS: 422 - Unprocessable Entity

{
  "errorType": "BUSINESS",
  "errorCodeResponse": {
    "name": "01",
    "value": "YOUR_BUSINESS_ERROR_CODE"
  },
  "message": "your message text 'argumentName=argument value'"
}
```