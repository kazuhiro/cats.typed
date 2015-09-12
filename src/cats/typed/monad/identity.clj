(ns cats.typed.monad.identity
  (:require [clojure.core.typed :as t]
            [cats.monad.identity :as identity]))

(t/ann-datatype [[a :variance :covariant]]
                cats.monad.identity.Identity
                [v :- a])

(t/defalias Identity
  (t/TFn [[x :variance :covariant]] (cats.monad.identity.Identity x)))

(t/ann ^:no-check cats.monad.identity/identity
       (t/All [x] [x -> (Identity x)]))
