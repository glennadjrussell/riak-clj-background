# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.box = "puppetlabs/centos-7.0-64-puppet"

  config.vm.box_check_update = true

  config.vm.provider "virtualbox" do |vb|
    vb.memory = "4096"
  end

  config.vm.provision "shell", inline: <<-SHELL
    sudo gpg2 --keyserver hkp://keys.gnupg.net --recv-keys 409B6B1796C275462A1703113804BB82D39DC0E3
    sudo yum install -y gem
    sudo yum install -y epel-release
    gem install r10k
    gem install bundler
    mkdir -p /opt/puppetlabs/puppet/modules; /usr/bin/chown vagrant.vagrant /opt/puppetlabs/puppet/modules
  SHELL

  config.vm.provision "shell", :privileged => false, inline: <<-R10K
    PUPPETFILE=/vagrant/Puppetfile \
    PUPPETFILE_DIR=/opt/puppetlabs/puppet/modules \
    /usr/local/bin/r10k puppetfile install || :
  R10K

  config.vm.provision "puppet" do |puppet|
    puppet.environment_path = "environments"
    puppet.environment = "dev"
  end
end
