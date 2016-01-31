(defproject cats.typed "0.1.1-SNAPSHOT"
  :description "org.clojure/core.typed definitions for funcool/cats library"
  :url "https://github.com/kazuhiro/cats.typed"
  :license {:name "BSD (2 Clause)"
            :url "http://opensource.org/licenses/BSD-2-Clause"}
  :dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]
                 [org.clojure/core.typed "0.3.20"]
                 [funcool/cats "1.2.1" :scope "provide"]] ;; 1.2.1
  :plugins [[lein-typed "0.3.5"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
