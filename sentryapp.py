import sentry_sdk
from sentry_sdk.integrations.logging import LoggingIntegration

sentry_sdk.init(
    dsn="https://e093ee9a2dd0f692e7c59588e009fee3@o4507496686878720.ingest.us.sentry.io/4507498011820032",
    integrations=[LoggingIntegration()]
)

def divide(a, b):
    return a / b

def main():
    try:
        print("Dividing 10 by 0")
        result = divide(10, 0)
        print(f"Result: {result}")
    except ZeroDivisionError as e:
        print(f"An error occurred: {e}")
        sentry_sdk.capture_exception(e)
    
    try:
        print("Accessing an undefined variable")
        print(undefined_variable)
    except NameError as e:
        print(f"An error occurred: {e}")
        sentry_sdk.capture_exception(e)

if __name__ == "__main__":
    main()

