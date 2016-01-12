# riak-clj-playground

A simple and quick way to start tinkering with riak and clojure (and Puppet if you are into that kind of thing). Uses:

* Vagrant
* Puppet
* Leiningen

## Installation

Download and install vagrant (https://www.vagrantup.com)

    $ vagrant up


## Usage
Write some clojure, blow riak up, destroy the vm and start again!

### Run basic clojure app ###
    $ vagrant ssh
    $ cd /vagrant
    $ lein run

## Tinkering with the code

This is a really simple project which relies on Clojure 1.7 and the Welle riak library (https://github.com/michaelklishin/welle). It opens a connection to riak, which is running on the local vm, creates a basic bucket, inserts some json into it, then reads it back.

Clojure code found in src/

## The Puppet code ##
It's a small project, but the few components are dividied into different manifests, in line with good practice.

Puppet code found in environments/dev/

For the record, I am really starting to hate config management tools

## License

Copyright © 2016 Glenn Russell

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
