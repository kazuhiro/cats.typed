(ns cats.typed.monad.exception-test
  (:require [clojure.test :refer :all]
            [cats.monad.identity :as identity]
            [cats.typed.monad.identity :refer :all]
            [clojure.core.typed :as t]))

(t/ann typed-identity [Integer -> (Identity Integer)])
(defn- typed-identity [x] (identity/identity x))
