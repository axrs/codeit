# codeit
Open Source JCU Open Day Gamification Project

* [Dependencies](#dependencies)
* [Setup](#setup)
* [Development](#development)
  * [Server](#server)
  * [Figwheel](#figwheel)
  * [LESS](#less)
* [Unit Tests](#unit-tests)  
* [Project Structure and files](#project-structure-and-files)

## Dependencies

* [Leiningen][1] 2.0 or above for everything build related
* [VirtualBox][2] and [Vagrant][3] for virtualising the [PostgreSQL][4] database
* [LessCSS][6] is used to help write the application specific CSS
* [Reagent][7] and [Re-Frame][8] are used as the front end UI framework
* [Figwheel][11] is used to provide hot reloading to the web browser while coding.
* A modified variant of [BareCSS][10] is used for all visual and aesthetics

The project was built from the *[Luminus][5]* template. It's recommended
reading through some of the documentation before diving in. The [Re-Frame][9]
documentation is extremely comprehensive and will provide insight into how the
UI views are rendered to the end user.

[1]: https://github.com/technomancy/leiningen
[2]: https://www.virtualbox.org/
[3]: https://www.vagrantup.com/
[4]: https://www.postgresql.org/
[5]: http://www.luminusweb.net/
[6]: http://lesscss.org/
[7]: https://github.com/reagent-project/reagent
[8]: https://github.com/Day8/re-frame
[9]: https://github.com/Day8/re-frame/tree/master/docs
[10]: http://barecss.com/
[11]: https://github.com/bhauman/lein-figwheel
[12]: http://localhost:3000/

## Setup

Configure and run the Vagrant box which hosts the PostgreSQL database-url and
migrate the database to the latest revision.

```bash
vagrant up
./codeit.sh clean
```

## Development

There are three [Leiningen][1] commands that are used to assist the developer.
Each command watches for changes and reloads components accordingly.

### Server

The **codeit** web server can be started by issuing the following command in
a new terminal instance.

```bash
lein run
```

Once running, open your web browser to [http://localhost:3000/][12] to start
using the application.

### Figwheel

> Figwheel builds your ClojureScript code and hot loads it into the browser as you are coding!

It is a core tool in the `ClojureScript` toolkit and provides the powerful
functionality to see the web browser reload changes without modifying state.
Meaning any changes made, paths taken, etc. are still applied. This is not your
typical browser reload.

```bash
lein figwheel
```

No other changes are required. Point your web browser to
[http://localhost:3000/][12] to start using the application with auto-refreshing.

### LESS

To watch for `.less` file changes and trigger a recompilation, run the following
command in a new terminal instance:

```bash
lein less auto
```

Alternatively, issue the following command to compile the `.less` into `.css`
once:

```bash
lein less once
```

## Unit Tests

Unit tests are placed in the `codeit.test.*` namespace and try to be as
inclusive as possible. To date, the tests only cover the server and validator
integrations.

To test everything is okay, issue the following in a terminal instance:

```bash
lein test
```

## Project Structure and files

```
//TODO
```