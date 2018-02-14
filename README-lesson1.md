# Scala for Java developers

The plan of this course is getting started with Scala for developers who mainly work with Java. 

Before starting to check the code, it is recommendable to read some useful commands of [SBT.](https://github.com/soniarodriguez/scala-for-java-devs/tree/lesson1-java/sbt-getting-started.md)

Then, let's check some differences in a HelloWorld app in [Java](https://github.com/soniarodriguez/scala-for-java-devs/blob/master/src/main/java/AppJavaRunner.java)
vs [Scala](https://github.com/soniarodriguez/scala-for-java-devs/blob/master/src/main/scala/AppScalaRunner.scala).


## Lesson 1. Getting Started with Scala and SBT

In this lesson, you will familiarize with SBT and Scala. In the code, there are two Java interfaces:
`FileReader` and `PrincingService`, they have been implemented in Java. Check what they do, then, try to
fix the failing tests by implementing in Scala the non-implemented methods. There are 2 different implementations
in Scala for `PrincingService`, ideally you will start with `PricingServiceMutableImpl` which is the closer to
the traditional Java. Then, move to `PricingServiceImmutableImpl`.

*Note: Non-implemented methods are represented with `???`.

### Section I. Imperative Programming vs Functional Programming
1. Implement in Scala the first two methods of `hotels.service.impl.PricingServiceMutableImpl` in an Imperative
programming way.
    - `convertToExchangeRateAsScala`
    - `findPricesBelowThresholdAsScala`

2. Implement using Scala the first two methods of `hotels.service.impl.PricingServiceImmutableImpl` in an Functional
programming way.
   - `convertToExchangeRateAsScala`
   - `findPricesBelowThresholdAsScala`

3. Implement using Scala the remaining method of `hotels.service.impl.PricingServiceMutableImpl` in an Imperative
   programming way.
      - `findMaxPriceAsScala`

4. Implement using Scala the remaining method of `hotels.service.impl.PricingServiceImmutableImpl` in an Functional
   programming way.
      - `findMaxPriceAsScala`
   

### Section II. Reading a file
1. Implement in Scala the method of `hotels.service.impl.FileReaderImpl`.
    - `readFileAsScala`