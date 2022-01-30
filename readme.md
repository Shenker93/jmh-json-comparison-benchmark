![Build Status](https://github.com/Shenker93/jmh-json-comparison-benchmark/actions/workflows/benchmark_run.yml/badge.svg)

**INSTALLATION**

Just use _mvn clean install_ command.
You will get _benchmarks.jar_ file in _target_ directory as a result.
Just use _java -jar target/benchmarks.jar_ command to start benchmarking.

**BENCHMARKING**

This benchmark compares some java libraries to serialize and deserialize json. Now Jackson and gson libraries are used.
Some simple scenarios are shown, however, it covers basic operations that are used while dealing with json.
I hope to create more complex scenarios in future, as well as to add another Java (or even another jvm-based languages 
like Scala or Kotlin) libraries to this short comparative overview. Also, if you have any ideas or PR's, you are welcome:)

By default, 10 warm-up and measurement iterations are used in benchmarks. 
However, feel free to change this value to our own. 
_@Warmup_ and _@Measurement_ annotations are used in StreamComputing class definition to define number of iterations.
Also you can change BenchmarkMode 

You can also use command-line args to change this settings or specify another (use _-h_ to view full list).
Comparing to annotations, command-line args have higher priority.

Some benchmarks are available on travis-ci build page (benchmark is wrapped into junit test, see build icon on the top of readme). 
However, according to some sources, such results accuracy can be lower, so it's better to use commands from _installation_ block.
