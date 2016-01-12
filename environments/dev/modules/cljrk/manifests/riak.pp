class cljrk::riak {
  include packagecloud

  packagecloud::repo { "basho/riak":
    type	=> 'rpm',
  }->
  package { "riak":
    ensure	=> present,
  }->
  service { "riak":
    ensure	=> running,
  }
}
