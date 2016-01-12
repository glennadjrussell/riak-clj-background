class cljrk::lein {
  class { 'java':
    distribution	=> 'jdk',
    package		=> 'java-1.8.0-openjdk-headless',
  }

  include wget

  file { "/usr/local/share/lein":
    ensure	=> directory,
  }->
  wget::fetch { 'lein':
    source	=> 'https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein',
    destination	=> '/tmp/lein',
    cache_dir	=> '/var/cache/wget',
  }->
  file { 'lein':
    owner	=> 'vagrant',
    source	=> '/tmp/lein',
    path	=> '/usr/local/share/lein/lein',
    mode	=> '555',
  }

  file { '/etc/profile.d/append-lein.sh':
    mode	=> '644',
    content	=> 'PATH=$PATH:/usr/local/share/lein',
  }
}
