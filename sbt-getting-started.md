# Getting started with SBT

SBT is a build tool, similar to Maven or Ant, that manages your dependencies using Ivy. It is *de facto* build tool in the Scala Community. Some of the main features are incremental compilation and an interactive shell.

The build definition goes in a file called `build.sbt`. This file must be located in the project's base directory.

You can use the sbt shell and type your tasks there or directly use the batch mode by typing: `sbt <tasks>`. For example:
```
sbt clean compile
```

## sbt shell
Run sbt in your project directory with no arguments to start the sbt shell.
```
$ sbt
```
To exit the sbt shell type `exit` or use Ctrl+D (Unix) or Ctrl+Z (Windows).

## Useful commands/tasks
* `clean`           ➤ To delete all compiled code (in `/target`).
* `compile`         ➤ To compile the main sources (in `src/main/scala` and `src/main/java`).
* `test`            ➤ To compile and run all tests in the project.
* `testOnly <test>` ➤ To run some specific classes.
* `testQuick`       ➤ To run only the failed tests in the previous run.
* `run <argument>*` ➤ To run the main class for the project.
* `package`         ➤ To create a jar with the classes compiled and the resources.
* `console`         ➤ To start the Scala interpreter. To return to sbt, type `:quit`.
* `reload`          ➤ To reload the build definition (if changes done in `build.sbt`, `project/*.scala`, `project/*.sbt`).
* `help <command>`  ➤ To get further help.


You can do continuous build and test by prefixing the command with `~`. For instance:
```
$ sbt
> ~testQuick
```
or
```
sbt ~testQuick
```


