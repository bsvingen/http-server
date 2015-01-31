[![travis-ci.org](https://travis-ci.org/bsvingen/http-server.svg?branch=master)](https://travis-ci.org/bsvingen/http-server)


http-server
===========

Simple HTTP server, serving files from local disk.

Requires [Leiningen](http://leiningen.org/).

Build using

```bash
lein bin
```

and copy `target/http-server` to a directory in `PATH`.

Run like

```bash
http-server 8080
```

from the directory with the files you want to serve.
