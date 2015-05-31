# Play Framework 2.3.9 Project Template

A Scala project template bundled with Play 2.x + TypeScript + Webpack + Scalariform + Scalastyle + Configured security options by default.

## Contents

Client side:

* altJS
    * [TypeScript]: TypeScript is a superset of JavaScript that compiles to clean JavaScript output.
* preprocessors:
    * [Stylus]: expressive, robust, feature-rich CSS preprocessor
    * [Jade]: robust, elegant, feature rich template engine for nodejs
* code quality:
    * [tslint]: a static analysis linter for TypeScript.
* build tools:
    * [Webpack]: Packs CommonJs/AMD modules for the browser.
    * Webpack + Play integration:
        * Assets are auto-reloaded by `activator run`.
        * Assets are minified before `activator dist`.
* bundled libraries:
    * jQuery 2.1.4
* others:
    * source map (only enabled in dev environment)
    * production codes are minified.
    * `console.log` is automatically removed from production codes.

Storages:

* [ScalikeJDBC]: A tidy SQL-based DB access library for Scala developers.
* MySQL Connector

Server behavior modifications:

* [Google HTML Compressor]: Remove unnecessary white spaces and comments from HTML in response.
* [SecurityHeaders]: Send headers to make apps much secure.

Code quality supports:

* Very strict scalac options.
* [Scalariform]: Automatic code reforming on compile.
* [Scalastyle]: Scala style checker with very strict rules.
* [Scapegoat]: Scala style checker for optional.

Others:

* Documentation is disabled to speed up compilation by default.


## Requirements

* npm
* node.js

## Quick Start

Generate a new project using [giter8].

```
g8 shouldbee/play-scala
cd yourapp
```

Install node modules.

```
make bootstrap
```

Then start Play server.

```
./activator run
```

Open http://localhost:9000/ with your browser and enjoy!

## Customize

### /node_modules and /typings are git-ignored by default

If you want to check in node_modules and types, you can comment out [these lines of .gitignore](https://github.com/shouldbee/play-scala.g8/blob/master/src/main/g8/.gitignore#L11-L12).


[Webpack]: http://webpack.github.io/
[TypeScript]: http://www.typescriptlang.org/
[Stylus]: https://learnboost.github.io/stylus/
[Jade]: http://jade-lang.com/
[tslint]: https://github.com/palantir/tslint

[ScalikeJDBC]: http://scalikejdbc.org/
[Google HTML Compressor]: https://code.google.com/p/htmlcompressor/
[SecurityHeaders]: https://www.playframework.com/documentation/2.3.x/SecurityHeaders
[Scalariform]: https://github.com/mdr/scalariform
[Scalastyle]: http://www.scalastyle.org/
[Scapegoat]: https://github.com/sksamuel/scalac-scapegoat-plugin

[giter8]: https://github.com/n8han/giter8/
