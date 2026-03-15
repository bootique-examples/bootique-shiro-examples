package io.bootique.examples.shiro;

import io.bootique.BQModule;
import io.bootique.Bootique;
import io.bootique.di.Binder;
import io.bootique.jersey.JerseyModule;

public class App implements BQModule {

    public static void main(String[] args) {
        Bootique
                .app(args)
                .autoLoadModules()
                .module(App.class)
                .args("-s", "--config=classpath:bootique.yml")
                .exec()
                .exit();
    }

    @Override
    public void configure(Binder binder) {
        JerseyModule.extend(binder)
                .addResource(ShiroController.class)
                .addResource(LoginController.class);
    }
}
