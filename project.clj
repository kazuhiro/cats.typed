(defproject cats.typed "0.1.0-SNAPSHOT"
  :description "org.clojure/core.typed definitions for funcool/cats library"
  :url "https://github.com/kazuhiro/cats.typed"
  :license {:name "BSD (2 Clause)"
            :url "http://opensource.org/licenses/BSD-2-Clause"}
  :dependencies [[org.clojure/clojure "1.7.0" :scope "provided"]
                 [org.clojure/core.typed "0.3.11"]
                 [funcool/cats "0.6.1" :scope "provided"]]
  :plugins [[lein-typed "0.3.5"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
