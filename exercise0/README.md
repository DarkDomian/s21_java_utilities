# Description of Tech Stack

I cannot use IntelliJ IDEA due to wa*, so I will use Visual Studio Code instead.

## Repository Initialization

First, I initialize the repository with `git init`. Then I prepare the Gradle workspace by running:

```
gradle init --type java-application --dsl kotlin
```

During the interactive Gradle initialization script, I select:
- Project name: `Smart_Utilities`
- Java version: 18
- Test framework: `JUnit Jupiter`
- Other options (which I can't remember)

After that, I use scripts to customize the repository:

```
for i in {0..10}; do
  cp -r app exercise$i
done

echo """
include($(for i in {1..9}; do echo -n "\"exercise$i\","; done))
""" >> settings.gradle.kts
```